<template>
    <ion-page>
      <ion-header>
        <ion-toolbar class="header-and-footer">
          <ion-title>Your booking has been confirmed!</ion-title>
        </ion-toolbar>
        <Breadcrumb />
      </ion-header>
      <ion-content class="ion-padding">
        <div class="container">

          <!-- Summary -->
          <ion-card>
            <ion-card-header>
              <ion-card-title>Summary</ion-card-title>
            </ion-card-header>
            <ion-card-content>
              <p><strong>First Name:</strong> {{ guest.firstName }}</p>
              <p><strong>Last Name:</strong> {{ guest.lastName }}</p>
              <p><strong>Email:</strong> {{ guest.email }}</p>
              <p><strong>Breakfast:</strong> {{ booking.breakfast ? 'Yes' : 'No' }}</p>
              <p><strong>Start Date:</strong> {{ booking.startDate }}</p>
              <p><strong>End Date:</strong> {{ booking.endDate }}</p>
            </ion-card-content>
          </ion-card>

          <!-- Room -->
          <ion-card>
            <ion-card-header>
              <ion-card-title>Your Room</ion-card-title>
            </ion-card-header>
            <ion-card-content>
              <p><strong>Name:</strong> {{ booking.room?.title }}</p>
              <p><strong>Description:</strong> {{ booking.room?.description }}</p>
              <p><strong>Size:</strong> {{ booking.room?.sizeSqm }}m<sup>2</sup></p>
            </ion-card-content>
          </ion-card>

          <!-- Maps -->
          <ion-card>
            <ion-card-header>
              <ion-card-title>How to get there?</ion-card-title>
            </ion-card-header>
            <ion-card-content>
              <GoogleMaps />
            </ion-card-content>
          </ion-card>

          <!-- Contact -->
          <ion-card>
            <ion-card-header>
              <ion-card-title>Contact</ion-card-title>
            </ion-card-header>
            <ion-card-content>
              <p><strong>E-Mail:</strong> <a href="mailto:support@technikum-botique.at">support@technikum-botique.at</a></p>
              <p><strong>Telephone:</strong> +43 664 123 456</p>
            </ion-card-content>
          </ion-card>
        </div>
      </ion-content>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { useBookingStore } from '../stores/useBookingStore';
  import Breadcrumb from '../components/Breadcrumb.vue';
  import GoogleMaps from '../components/GoogleMaps.vue';
  import {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonCard,
    IonCardHeader,
    IonCardContent,
    IonCardTitle
  } from '@ionic/vue';
  
  const bookingStore = useBookingStore();
  const { guest, booking } = bookingStore;
  </script>
  
  <style scoped>
    .container {
      max-width: 800px;
      margin: 0 auto 0 auto;
    }
  </style>
  