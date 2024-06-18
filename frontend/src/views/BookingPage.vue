<template>
  <ion-page>
    <ion-header>
      <ion-toolbar class="header-and-footer">
        <ion-title>Book a Room</ion-title>
      </ion-toolbar>
      <BackButton />
    </ion-header>
    <ion-content class="ion-padding">
      <ion-card>
        <ion-card-header>
          <ion-card-title>Your Booking Summary</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <p><strong>Start Date:</strong> {{ booking.startDate }}</p>
          <p><strong>End Date:</strong> {{ booking.endDate }}</p>
          <p><strong>Room Number:</strong> {{ booking.room?.id }}</p>
        </ion-card-content>
      </ion-card>
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
          <ion-button
            expand="full"
            type="submit"
            Submit
            color="secondary"
            class="custom-button"
            >Next</ion-button
          >
        </form>
      </ion-list>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import { useBookingStore } from "../stores/useBookingStore";
import BackButton from "../components/BackButton.vue";
import { useRouter, useRoute } from "vue-router";
import { ref, onMounted } from "vue";
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
  IonCardTitle,
  IonCardHeader,
  IonCardContent,
  IonCard,
} from "@ionic/vue";

export default {
  components: {
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
    IonCardTitle,
    IonCardHeader,
    IonCardContent,
    IonCard,
    BackButton,
  },
  setup() {
    const bookingStore = useBookingStore();
    const { guest, booking } = bookingStore;
    const confirmEmail = ref("");
    const router = useRouter();
    const route = useRoute();

    onMounted(() => {
      const roomId = route.query.roomId as string;
      const startDate = route.query.startDate as string;
      const endDate = route.query.endDate as string;

      if (roomId) {
        booking.room = {
          id: parseInt(roomId),
          title: "",
          description: "",
          guestCapacity: 0,
          sizeSqm: 0,
        };
      }
      if (startDate) {
        booking.startDate = startDate;
      }
      if (endDate) {
        booking.endDate = endDate;
      }
    });

    const navigateToReview = () => {
      if (
        guest.email.trim().toLowerCase() !==
        confirmEmail.value.trim().toLowerCase()
      ) {
        alert("Email addresses do not match.");
        return;
      }

      router.push("/bookingreview");
    };

    return { guest, booking, confirmEmail, router, navigateToReview };
  },
};
</script>
