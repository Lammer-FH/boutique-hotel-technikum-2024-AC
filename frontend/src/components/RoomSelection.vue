<template>
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
          <ion-button @click="navigateToBooking(room.id)">Book Now</ion-button>
        </div>
      </div>
    </div>
  </template>
  
  <script lang="ts">
  import { defineComponent, ref, watch } from 'vue';
  import { useRouter } from 'vue-router';
  import CustomSelect from '../components/CustomSelect.vue';
  import { IonDatetimeButton, IonModal, IonDatetime, IonButton } from '@ionic/vue';
  import axios from 'axios';
  
  interface Room {
    id: number;
    title: string;
    description: string;
    guestCapacity: number;
    sizeSqm: number;
  }
  
  export default defineComponent({
    components: {
      CustomSelect,
      IonDatetimeButton,
      IonModal,
      IonDatetime,
      IonButton
    },
    setup() {
      const router = useRouter();
      const selectedOptions = ref([]);
      const rooms = ref<Room[]>([]);
      const loading = ref(true);
      const startDate = ref('');
      const endDate = ref('');
      const page = ref(0);
      const size = ref(10);
  
      const formatDate = (dateString: string) => {
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
      };
  
      const fetchRooms = async () => {
        loading.value = true;
        try {
          const params: Record<string, any> = {
            page: page.value,
            size: size.value,
          };
  
          if (startDate.value) {
            params.startDate = startDate.value;
          }
  
          if (endDate.value) {
            params.endDate = endDate.value;
          }
  
          const response = await axios.get('http://localhost:8080/rooms', { params });
          rooms.value = response.data;
        } catch (error) {
          console.error('Error fetching rooms', error);
        } finally {
          loading.value = false;
        }
      };
  
      const updateStartDate = (event: CustomEvent) => {
        const target = event.target as HTMLIonDatetimeElement;
        const formattedDate = formatDate(String(target.value));
        startDate.value = formattedDate;
        console.log('Updated start date:', startDate.value);
        fetchRooms();
      };
  
      const updateEndDate = (event: CustomEvent) => {
        const target = event.target as HTMLIonDatetimeElement;
        const formattedDate = formatDate(String(target.value));
        endDate.value = formattedDate;
        console.log('Updated end date:', endDate.value);
        fetchRooms();
      };
  
      const navigateToBooking = (roomId: number) => {
        const formattedStartDate = startDate.value;
        const formattedEndDate = endDate.value;
        console.log('Navigating to Booking Form with:', { roomId, formattedStartDate, formattedEndDate });
  
        if (!formattedStartDate || !formattedEndDate) {
          console.error('Start date or end date is not defined');
          return;
        }
  
        router.push({ 
          name: 'BookingForm', 
          query: { 
            roomId: roomId.toString(), 
            startDate: formattedStartDate, 
            endDate: formattedEndDate 
          }
        });
      };
  
      watch([startDate, endDate, page, size], fetchRooms);
  
      fetchRooms();
  
      return { selectedOptions, rooms, loading, updateStartDate, updateEndDate, navigateToBooking, startDate, endDate };
    }
  });
  </script>
  
  <style scoped>
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