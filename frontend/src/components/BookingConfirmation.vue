<template>
    <ion-page>
      <ion-header>
        <ion-toolbar class="header-and-footer">
          <ion-title>Booking Confirmation</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-content class="ion-padding">
        <h2>Your booking has been confirmed!</h2>
        <ion-list class="form-list">
          <ion-item class="form-item">
            <ion-label>First Name</ion-label>
            <ion-note>{{ guest.firstName }}</ion-note>
          </ion-item>
          <ion-item class="form-item">
            <ion-label>Last Name</ion-label>
            <ion-note>{{ guest.lastName }}</ion-note>
          </ion-item>
          <ion-item class="form-item">
            <ion-label>Email</ion-label>
            <ion-note>{{ guest.email }}</ion-note>
          </ion-item>
          <ion-item class="form-item">
            <ion-label>Breakfast</ion-label>
            <ion-note>{{ booking.breakfast ? 'Yes' : 'No' }}</ion-note>
          </ion-item>
          <ion-item class="form-item">
            <ion-label>Start Date</ion-label>
            <ion-note>{{ booking.startDate }}</ion-note>
          </ion-item>
          <ion-item class="form-item">
            <ion-label>End Date</ion-label>
            <ion-note>{{ booking.endDate }}</ion-note>
          </ion-item>
        </ion-list>
      </ion-content>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { useBookingStore } from '../stores/useBookingStore';
  import {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonList,
    IonItem,
    IonLabel,
    IonNote
  } from '@ionic/vue';
  
  const bookingStore = useBookingStore();
  const { guest, booking } = bookingStore;
  </script>
  
  <style scoped>
  /* (your existing styles) */
  </style>
  