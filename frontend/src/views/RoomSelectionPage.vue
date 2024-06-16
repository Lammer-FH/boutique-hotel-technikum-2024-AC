<template>
  <ion-page>
    <ion-header>
      <ion-toolbar class="header-and-footer">
        <ion-title>Room Selection Page</ion-title>
      </ion-toolbar>
      <Breadcrumb />
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <div class="container">
        <div class="datepicker-container">
          <div class="datepicker-item">
            <label>From:</label>
            <ion-datetime-button datetime="startDatetime"></ion-datetime-button>
            <ion-modal :keep-contents-mounted="true">
              <ion-datetime id="startDatetime" presentation="date" @ionChange="updateStartDate"></ion-datetime>
            </ion-modal>
          </div>

          <div class="datepicker-item">
            <label>To:</label>
            <ion-datetime-button datetime="endDatetime"></ion-datetime-button>
            <ion-modal :keep-contents-mounted="true">
              <ion-datetime id="endDatetime" presentation="date" @ionChange="updateEndDate"></ion-datetime>
            </ion-modal>
          </div>
        </div>

        <CustomSelect />

        <div v-if="loading" class="loading">Loading...</div>
        <div v-else class="rooms-grid">
          <div v-for="room in rooms" :key="room.id" class="room-card">
            <img :src="`/images/rooms/room${room.id}.png`" alt="Room Image" class="room-image">
            <h3>{{ room.title }}</h3>
            <p>Description: {{ room.description }}</p>
            <p>Guest capacity: {{ room.guestCapacity }}</p>
            <p>Room size: {{ room.sizeSqm }}</p>
            <ion-button @click="navigateToBooking(room.id, startDate, endDate)">Book Now</ion-button>
          </div>
        </div>
      </div>
    </ion-content>

    <ion-footer>
      <ion-toolbar class="header-and-footer">
        <ion-title></ion-title>
      </ion-toolbar>
    </ion-footer>
  </ion-page>
</template>

<script lang="ts">
import { defineComponent, ref, watch } from 'vue';
import { useRouter } from 'vue-router';
import Breadcrumb from '../components/Breadcrumb.vue';
import CustomSelect from '../components/CustomSelect.vue';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonPage, IonFooter, IonDatetimeButton, IonModal, IonDatetime, IonButton } from '@ionic/vue';
import axios from 'axios';

export default defineComponent({
  components: {
    Breadcrumb,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonFooter,
    IonDatetimeButton,
    IonModal,
    IonDatetime,
    IonButton,
    CustomSelect
  },
  name: 'RoomSelectionPage',
  setup() {
    const router = useRouter();
    const selectedOptions = ref([]);
    const rooms = ref([]);
    const loading = ref(true);
    const startDate = ref('');
    const endDate = ref('');
    const page = ref(0);
    const size = ref(10);

    const formatDate = (dateString) => {
      const date = new Date(dateString);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, '0');
      const day = String(date.getDate()).padStart(2, '0');
      return `${year}-${month}-${day}`;
    };

    const fetchRooms = async () => {
      loading.value = true;
      try {
        const params = {
          page: page.value,
          size: size.value,
        };

        if (startDate.value) {
          params.startDate = formatDate(startDate.value);
        }

        if (endDate.value) {
          params.endDate = formatDate(endDate.value);
        }

        const response = await axios.get('http://localhost:8080/rooms', { params });
        rooms.value = response.data;
      } catch (error) {
        console.error('Error fetching rooms', error);
      } finally {
        loading.value = false;
      }
    };

    const updateStartDate = (event) => {
      startDate.value = event.target.value;
      fetchRooms();
    };

    const updateEndDate = (event) => {
      endDate.value = event.target.value;
      fetchRooms();
    };

    const navigateToBooking = (roomId, startDate, endDate) => {
      router.push({ 
        name: 'BookingForm', 
        query: { 
          roomId: roomId, 
          startDate: formatDate(startDate), 
          endDate: formatDate(endDate) 
        }
      });
    };

    watch([startDate, endDate, page, size], fetchRooms);

    fetchRooms();

    return { selectedOptions, rooms, loading, updateStartDate, updateEndDate, navigateToBooking };
  }
});
</script>

<style scoped>
.header-and-footer {
  --background: #e0d9c8;
  text-align: center;
}
.container {
  padding: 16px;
}
.datepicker-container {
  display: flex;
  justify-content: space-between;
  margin-bottom: 16px;
}
.datepicker-item {
  flex: 1;
  margin-right: 16px;
}
.datepicker-item:last-child {
  margin-right: 0;
}
.loading {
  text-align: center;
}
.rooms-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 16px;
}
.room-card {
  border: 1px solid #ccc;
  border-radius: 8px;
  padding: 16px;
  text-align: center;
}
.room-image {
  max-width: 100%;
  border-radius: 8px;
  margin-bottom: 16px;
}
</style>