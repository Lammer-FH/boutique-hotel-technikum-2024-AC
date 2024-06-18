<template>
  <div class="room-card">
    <img :src="`/images/rooms/room${room.id}.png`" alt="Room Image" class="room-image">
    <h3>{{ room.title }}</h3>
    <p>Description: {{ room.description }}</p>
    <p>Guest capacity: {{ room.guestCapacity }}</p>
    <p>Room size: {{ room.sizeSqm }}</p>
    <ion-button v-if="onClick" @click="onClick(room.id)" class="custom-button">Book Now</ion-button>
  </div>
</template>

<script lang="ts">
  import { IonButton } from '@ionic/vue';

  export default {
    components: {
      IonButton
    },
    props: {
      room: {
        type: Object,
        required: true
      },
      onClick: {
        type: Function,
        required: false,
      }
    },
  }
</script>

<style scoped>
  .room-card {
    border: 1px solid #ccc;
    border-radius: 8px;
    padding: 16px;
    text-align: center;
  }
  .room-image {
    max-width: 100%;
    border-radius: 8px;
    margin-bottom: 16px;
  }
</style>