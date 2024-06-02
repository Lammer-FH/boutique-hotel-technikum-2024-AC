<template>
    <ion-page>
        <ion-header>
            <ion-toolbar>
                <ion-title class="ion-text-center">Room Selection Page</ion-title>
            </ion-toolbar>
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

         <div class="select-container">
          <ion-label>Extras</ion-label>
          <ion-select :multiple="true" v-model="selectedOptions" placeholder="Select Options">
            <ion-select-option value="option1">Balcony</ion-select-option>
            <ion-select-option value="option2">Air Condition</ion-select-option>
            <ion-select-option value="option3">Bathroom</ion-select-option>
            <ion-select-option value="option4">Whirlpool</ion-select-option>
          </ion-select>
        </div>
            </div>

                        <div v-if="loading" class="loading">Loading...</div>
            <div v-else class="rooms-grid">
                <div v-for="room in rooms" :key="room.id" class="room-card">
          <img :src="`/images/rooms/room${room.id}.png`" alt="Room Image" class="room-image">   
                <h3>{{ room.title }}</h3>
             <p> Description: {{ room.description }}</p>    
               <p> Guest capacity: {{ room.guest_capacity }}</p>    
                <p> Room size: {{ room.size_sqm }}</p>
            </div>
            </div>
            

            

        </div>
        </ion-content>
    </ion-page>
</template>

<script lang="ts">
import { IonDatetime, IonDatetimeButton, IonModal, IonSelectOption, IonHeader, IonLabel, IonSelect, IonContent, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import { defineComponent, ref, onMounted } from 'vue';
import axios from 'axios';

export default defineComponent({
    components: { IonDatetime, IonDatetimeButton, IonModal, IonSelectOption, IonHeader, IonLabel, IonSelect, IonContent, IonPage, IonTitle, IonToolbar},
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
.container {
    padding: 16px;
    text-align: center;
}

.datepicker-container {
    display: flex;
    justify-content: center;
    gap: 16px;
}

h1 {
    margin: 16px 0;
}

.select-container {
  width: 100%;
  max-width: 400px;
  text-align: left;
  margin-bottom: 16px; /* Abstand zum nächsten Element */
}

.loading {
  font-size: 1.5em;
  color: #888;
}

.rooms-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 16px;
  margin-top: 16px;
}

.room-card {
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  padding: 16px;
  text-align: left;
}

.room-image {
  width: 100%;
  height: auto;
  border-radius: 8px 8px 0 0;
}
</style>
