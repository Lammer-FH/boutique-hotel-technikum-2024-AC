<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Book a Room</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content>
      <ion-list>
        <form @submit.prevent="submitBooking">
          <ion-item>
            <ion-label position="floating">First Name</ion-label>
            <ion-input v-model="guest.firstName" required></ion-input>
          </ion-item>
          <ion-item>
            <ion-label position="floating">Last Name</ion-label>
            <ion-input v-model="guest.lastName" required></ion-input>
          </ion-item>
          <ion-item>
            <ion-label position="floating">Email</ion-label>
            <ion-input type="email" v-model="guest.email" required></ion-input>
          </ion-item>
          <ion-item>
            <ion-label position="floating">Confirm Email</ion-label>
            <ion-input type="email" v-model="confirmEmail" required></ion-input>
          </ion-item>
          <ion-item>
            <ion-label>Breakfast</ion-label>
            <ion-toggle v-model="booking.breakfast"></ion-toggle>
          </ion-item>
          <ion-item>
            <ion-label position="floating">Start Date</ion-label>
            <ion-datetime display-format="YYYY-MM-DD" v-model="booking.startDate"></ion-datetime>
          </ion-item>
          <ion-item>
            <ion-label position="floating">End Date</ion-label>
            <ion-datetime display-format="YYYY-MM-DD" v-model="booking.endDate"></ion-datetime>
          </ion-item>
          <ion-button expand="full" type="submit">Submit</ion-button>
        </form>
      </ion-list>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue';
import axios from 'axios';
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
  IonDatetime
} from '@ionic/vue';

const guest = reactive({
  firstName: '',
  lastName: '',
  email: ''
});

const booking = reactive({
  roomId: 123456, // This should be dynamically set based on selected room
  startDate: '',
  endDate: '',
  firstName: '',
  lastName: '',
  email: '',
  breakfast: false
});
const confirmEmail = ref('');

// Method to handle form submission
const submitBooking = async () => {
  if (guest.email !== confirmEmail.value) {
    alert('Email addresses do not match.');
    return;
  }
  try {
    const guestResponse = await axios.post('http://localhost:8080/guests', guest);
    const guestId = guestResponse.data.id;

    const bookingData = {
      ...booking,
      guestId: guestId
    };

    const bookingResponse = await axios.post('http://localhost:8080/bookings', bookingData);
    alert('Booking confirmed: ' + bookingResponse.data.id);
  } catch (error) {
    console.error('There was an error creating the booking!', error);
  }
};

// Optional: Watcher to ensure dates are correctly formatted
import { watch } from 'vue';
watch(
  () => booking.startDate,
  (newVal) => {
    if (newVal && isNaN(Date.parse(newVal))) {
      booking.startDate = '';
    }
  }
);

watch(
  () => booking.endDate,
  (newVal) => {
    if (newVal && isNaN(Date.parse(newVal))) {
      booking.endDate = '';
    }
  }
);
</script>
