<template>
  <ion-page>
    <ion-header>
      <ion-toolbar class="header-and-footer">
        <ion-title>Book a Room</ion-title>
      </ion-toolbar>
      <Breadcrumb />
    </ion-header>
    <ion-content class="ion-padding">
      <ion-list class="form-list">
        <form @submit.prevent="navigateToReview">
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
            <ion-label position="floating">Confirm Email</ion-label>
            <ion-input type="email" v-model="confirmEmail" required></ion-input>
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
          <ion-button expand="full" type="submit" Submit color="secondary" class="custom-button">Next</ion-button>
        </form>
      </ion-list>
    </ion-content>
    <ion-footer>
      <ion-toolbar class="header-and-footer">
          <ion-title>Impressum</ion-title>
      </ion-toolbar>    
  </ion-footer>
  </ion-page>
</template>

<script setup lang="ts">
import { useBookingStore } from '../stores/useBookingStore';
import Breadcrumb from '../components/Breadcrumb.vue';
import { useRouter } from 'vue-router';
import { ref } from 'vue';
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
  IonFooter
} from '@ionic/vue';

const bookingStore = useBookingStore();
const { guest, booking } = bookingStore;
const confirmEmail = ref('');
const router = useRouter();

const navigateToReview = () => {
  if (guest.email.trim().toLowerCase() !== confirmEmail.value.trim().toLowerCase()) {
    alert('Email addresses do not match.');
    return;
  }

  if (booking.startDate == "" || booking.endDate == "") {
    alert('A date is missing');
    return;
  }
  router.push('/bookingreview');
};
</script>

<style scoped>

.ion-content {
  --background: #f7f3e9;
}

.form-item {
  margin-bottom: 15px;
}

.form-list {
  margin: 0 auto;
  max-width: 600px;
  background: #f7f3e9;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.hotel-image {
    width: 100%;
    max-width: 600px;
    height: auto;
    margin: 20px auto;
    border-radius: 15px;
}

.header-and-footer {
    --background: #e0d9c8;
    text-align: center;
}

.custom-button {
    --background: #847e71;
    --background-activated: #6e685e;
    --background-focused: #6e685e;
    --background-hover: #6e685e;
    --color: #ffffff;
}

.position-button {
    margin-top: 10px; 
}

h1 {
    font-size: 24px;
    font-weight: bold;
    margin: 20px 0 10px;
}

h2 {
    font-size: 18px;
    font-weight: bold;
    margin: 20px 0 10px;
}

ion-card {
    margin: 20px 0;
}

ion-button {
    margin-top: 20px;
}

ion-footer {
    position: fixed;
    bottom: 0;
    width: 100%;
    z-index: 10;
}



</style>