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
              <ion-datetime id="startDatetime" presentation="date"></ion-datetime>
            </ion-modal>
          </div>

          <div class="datepicker-item">
            <label>To:</label>
            <ion-datetime-button datetime="endDatetime"></ion-datetime-button>
            <ion-modal :keep-contents-mounted="true">
              <ion-datetime id="endDatetime" presentation="date"></ion-datetime>
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
            <p>Guest capacity: {{ room.guest_capacity }}</p>
            <p>Room size: {{ room.size_sqm }}</p>
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
import { defineComponent, ref, onMounted } from 'vue';
import Breadcrumb from '../components/Breadcrumb.vue';
import CustomSelect from '../components/CustomSelect.vue';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonPage, IonFooter, IonDatetimeButton, IonModal, IonDatetime, IonLabel, IonSelect, IonSelectOption } from '@ionic/vue';
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
    IonLabel,
    IonSelect,
    IonSelectOption,
    CustomSelect
  },
  name: 'RoomSelectionPage',
  setup() {
        const selectedOptions = ref([]);
        const rooms = ref([]);
        const loading = ref(true);
    
    onMounted(async () => {
        try {
            const response = await axios.get('http://localhost:8080/rooms');
            rooms.value = response.data;

        } catch (error) {
            console.error('Error fetching rooms', error);
        } finally {
            loading.value = false;
        }
    });

        return { selectedOptions, rooms, loading };
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
.select-container {
  margin-bottom: 16px;
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
