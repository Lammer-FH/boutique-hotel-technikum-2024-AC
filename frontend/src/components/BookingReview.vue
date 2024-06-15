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
          <ion-button expand="full" @click="editMode = true" color="secondary" class="custom-button">Edit Booking</ion-button>
        </ion-card-content>
      </ion-card>

      <!-- Edit Section -->
      <ion-list class="form-list" v-if="editMode">
        <form @submit.prevent="updateBooking">
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
          <ion-item class="form-item">
            <ion-label position="floating">Start Date</ion-label>
            <ion-datetime display-format="YYYY-MM-DD" v-model="booking.startDate" required></ion-datetime>
          </ion-item>
          <ion-item class="form-item">
            <ion-label position="floating">End Date</ion-label>
            <ion-datetime display-format="YYYY-MM-DD" v-model="booking.endDate" required></ion-datetime>
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
import { ref } from 'vue';
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
} from '@ionic/vue';

const bookingStore = useBookingStore();
const { guest, booking } = bookingStore;
const router = useRouter();
const editMode = ref(false);

const updateBooking = async () => {
  try {
    const guestId = await bookingStore.submitGuest();
    await bookingStore.submitBooking(guestId);
    router.push('/confirmation');
  } catch (error) {
    console.error('There was an error updating the booking!', error);
  }
};
</script>

<style scoped>
/* Your existing styles */
</style>
