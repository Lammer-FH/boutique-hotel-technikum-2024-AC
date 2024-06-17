<template>
    <ion-page>
      <ion-header>
        <ion-toolbar class="header-and-footer">
          <ion-title>Booking (ID: {{ bookingId }})</ion-title>
        </ion-toolbar>
        <Breadcrumb />
      </ion-header>
      <ion-content class="ion-padding">
        <div class="container">
          <div v-if="store.loading">
            Loading the Booking...
          </div>
          <div v-else>
            <!-- Summary -->
            <ion-card>
              <ion-card-header>
                <ion-card-title>Summary</ion-card-title>
              </ion-card-header>
              <ion-card-content>
                <p><strong>First Name:</strong> {{ store.booking.guest.firstName }}</p>
                <p><strong>Last Name:</strong> {{ store.booking.guest.lastName }}</p>
                <p><strong>Email:</strong> {{ store.booking.guest.email }}</p>
                <p><strong>Breakfast:</strong> {{ store.booking.breakfast ? 'Yes' : 'No' }}</p>
                <p><strong>Start Date:</strong> {{ store.booking.startDate }}</p>
                <p><strong>End Date:</strong> {{ store.booking.endDate }}</p>
              </ion-card-content>
            </ion-card>

            <div v-if="store.booking.room">
              <RoomCard :room="store.booking.room" />
            </div>

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
        </div>
      </ion-content>
    </ion-page>
</template>
  
<script lang="ts">
  import { useBookingStore } from '../stores/useBookingStore';
  import Breadcrumb from '../components/Breadcrumb.vue';
  import GoogleMaps from '../components/GoogleMaps.vue';
  import RoomCard from './RoomCard.vue';
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
  import { useRoute } from 'vue-router';
  import { onMounted } from 'vue';

  export default {
    components: {
      Breadcrumb,
      GoogleMaps,
      RoomCard,
      IonPage,
      IonHeader,
      IonToolbar,
      IonTitle,
      IonContent,
      IonCard,
      IonCardHeader,
      IonCardContent,
      IonCardTitle
    },
    setup: () => {
      const route = useRoute();
      const store = useBookingStore();

      const bookingId = Array.isArray(route.params.id) ? Number(route.params.id[0]) : Number(route.params.id);

      onMounted(() => {
        store.loadBooking(bookingId);
      });
      
      return { store, bookingId };
    },
  }
</script>
  
  <style scoped>
    .container {
      max-width: 800px;
      margin: 0 auto 0 auto;
    }
  </style>
  