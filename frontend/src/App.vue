<template>
  <ion-app>
    <ion-header>
      <ion-toolbar>
        <ion-title>Room Booking</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content>
      <BookingForm />
    </ion-content>
  </ion-app>
</template>

<script setup lang="ts">
import { IonApp, IonHeader, IonToolbar, IonTitle, IonContent } from '@ionic/vue';
import BookingForm from './components/BookingForm.vue'; // Import the BookingForm component
</script>
