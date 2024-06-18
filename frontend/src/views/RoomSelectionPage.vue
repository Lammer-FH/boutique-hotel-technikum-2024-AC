<template>
  <ion-page>
    <ion-header>
      <ion-toolbar class="header-and-footer">
        <ion-title>Room Selection Page</ion-title>
      </ion-toolbar>
      <BackButton />
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <RoomSelection />
    </ion-content>

    <ion-footer>
      <ion-toolbar class="header-and-footer">
        <ion-title></ion-title>
      </ion-toolbar>
    </ion-footer>
  </ion-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import BackButton from '../components/BackButton.vue';
import RoomSelection from '../components/RoomSelection.vue';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonPage, IonFooter } from '@ionic/vue';

export default defineComponent({
  components: {
    BackButton,
    RoomSelection,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonFooter
  },
  name: 'RoomSelectionPage',
});
</script>

<style scoped>
.header-and-footer {
  --background: #e0d9c8;
  text-align: center;
}
</style>