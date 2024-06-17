<template>
  <ion-page>
    <ion-header>
      <ion-toolbar class="header-and-footer">
        <ion-title>Review Your Booking</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content class="ion-padding">
      <!-- Summary Section -->
      <ion-card>
        <ion-card-header>
          <ion-card-title>Your Booking Summary</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <p><strong>First Name:</strong> {{ guest.firstName }}</p>
          <p><strong>Last Name:</strong> {{ guest.lastName }}</p>
          <p><strong>Email:</strong> {{ guest.email }}</p>
          <p><strong>Breakfast:</strong> {{ booking.breakfast ? 'Yes' : 'No' }}</p>
          <p><strong>Start Date:</strong> {{ booking.startDate }}</p>
          <p><strong>End Date:</strong> {{ booking.endDate }}</p>
          <p><strong>Room Number:</strong> {{ booking.room?.id }}</p>
          <ion-button expand="full" @click="editMode = true" color="secondary" class="custom-button">Edit Booking</ion-button>
        </ion-card-content>
      </ion-card>

      <!-- Edit Section -->
      <ion-list class="form-list" v-if="editMode">
        <form @submit.prevent="updateBooking">
          <ion-item class="date-picker">
            <div class="datepicker-container">
              <div class="datepicker-item">
                <label>From:</label>
                <ion-datetime-button datetime="startDatetime"></ion-datetime-button>
                <ion-modal :keep-contents-mounted="true">
                  <ion-datetime id="startDatetime" presentation="date" @ionChange="onStartDateChange" :min="minDate" :value="booking.startDate"></ion-datetime>
                </ion-modal>
              </div>
              <div class="datepicker-item">
                <label>To:</label>
                <ion-datetime-button datetime="endDatetime"></ion-datetime-button>
                <ion-modal :keep-contents-mounted="true">
                  <ion-datetime id="endDatetime" presentation="date" @ionChange="onEndDateChange" :min="minEndDate" :value="booking.endDate"></ion-datetime>
                </ion-modal>
              </div>
            </div>
          </ion-item>
          <ion-item class="form-item">
            <ion-label>Room Number</ion-label>
            <ion-select v-model="selectedRoomId" interface="popover" placeholder="Select Room">
              <ion-select-option v-for="room in roomSelectionStore.rooms" :key="room.id" :value="room.id">
                {{ room.title }} (Room ID: {{ room.id }})
              </ion-select-option>
            </ion-select>
          </ion-item>
          <ion-item class="form-item">
            <ion-label position="floating">First Name</ion-label>
            <ion-input v-model="guest.firstName" required></ion-input>
          </ion-item>
          <ion-item class="form-item">
            <ion-label position="floating">Last Name</ion-label>
            <ion-input v-model="guest.lastName" required></ion-input>
          </ion-item>
          <ion-item class="form-item">
            <ion-label position="floating">Email</ion-label>
            <ion-input type="email" v-model="guest.email" required></ion-input>
          </ion-item>
          <ion-item class="form-item">
            <ion-label>Breakfast</ion-label>
            <ion-toggle v-model="booking.breakfast"></ion-toggle>
          </ion-item>
          <ion-button expand="full" type="submit" color="secondary" class="custom-button" @click="editMode = false">Save Changes</ion-button>
        </form>
      </ion-list>

      <!-- Always Visible Update Button -->
      <ion-button expand="full" v-if="!editMode" @click="updateBooking" color="primary" class="custom-button">Submit Booking</ion-button>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { useBookingStore } from '../stores/useBookingStore';
import { useRoomSelectionStore } from '../stores/useRoomSelectionStore';
import { ref, onMounted, watch } from 'vue';
import { useRouter } from 'vue-router';
import {
  IonPage,
  IonList,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonButton,
  IonContent,
  IonItem,
  IonLabel,
  IonInput,
  IonToggle,
  IonDatetime,
  IonCard,
  IonCardHeader,
  IonCardTitle,
  IonCardContent,
  IonSelect,
  IonSelectOption,
  IonDatetimeButton,
  IonModal,
} from '@ionic/vue';

const bookingStore = useBookingStore();
const roomSelectionStore = useRoomSelectionStore();
const { guest, booking } = bookingStore;
const router = useRouter();
const editMode = ref(false);
const minDate = new Date().toISOString().split('T')[0]; // Today's date
const minEndDate = ref(minDate);
const selectedRoomId = ref(booking.room?.id);

const formatDate = (dateString: string) => {
  const date = new Date(dateString);
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const day = String(date.getDate()).padStart(2, '0');
  return `${year}-${month}-${day}`;
};

const onStartDateChange = (event: CustomEvent) => {
  const target = event.target as HTMLIonDatetimeElement;
  const selectedDate = new Date(target.value as string);
  selectedDate.setDate(selectedDate.getDate() + 1); // Set end date minimum to the day after start date
  minEndDate.value = selectedDate.toISOString().split('T')[0]; // Update minEndDate
  booking.startDate = formatDate(String(target.value));
  booking.endDate = formatDate(selectedDate.toISOString()); // Set endDate to default to the day after start date
  roomSelectionStore.updateStartDate(booking.startDate); // Update startDate in store
  roomSelectionStore.updateEndDate(booking.endDate); // Update endDate in store
};

const onEndDateChange = (event: CustomEvent) => {
  const target = event.target as HTMLIonDatetimeElement;
  booking.endDate = formatDate(String(target.value));
  roomSelectionStore.updateEndDate(booking.endDate);
};

const updateBooking = async () => {
  try {
    const guestId = await bookingStore.submitGuest();
    await bookingStore.submitBooking(guestId);
    router.push('/confirmation');
  } catch (error) {
    console.error('There was an error updating the booking!', error);
  }
};

watch(selectedRoomId, (newRoomId) => {
  if (newRoomId !== undefined) {
    booking.room = roomSelectionStore.rooms.find(room => room.id === newRoomId) || null;
  }
});

onMounted(() => {
  // Prefill store with default values
  roomSelectionStore.updateStartDate(booking.startDate || minDate);
  roomSelectionStore.updateEndDate(booking.endDate || minDate);
});
</script>

<style scoped>
/* Your existing styles */
</style>
