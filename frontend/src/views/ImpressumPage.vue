<template>
  <ion-page>
    <ion-header>
      <ion-toolbar class="header-and-footer">
        <ion-title>Impressum</ion-title>
      </ion-toolbar>
      <BackButton />
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <div class="container">
        <ion-card>
          <ion-card-content style="background-color: #f7f3e9">
            <p>Betreiber der Seite:</p>
            <p>Boutique Hotel Technikum</p>
            <p>Adresse: Musterstraße 1, 12345 Musterstadt</p>
            <p>Telefon: +49 123 456789</p>
            <p>Email: info@hotel-technikum.de</p>
          </ion-card-content>
        </ion-card>
        <ion-card>
          <ion-card-content style="background-color: #f7f3e9">
            <p>Verantwortlich für den Inhalt nach § 55 Abs. 2 RStV:</p>
            <p>Max Mustermann</p>
            <p>Adresse: Musterstraße 1, 12345 Musterstadt</p>
          </ion-card-content>
        </ion-card>
      </div>
    </ion-content>

    <ion-footer>
      <ion-toolbar class="header-and-footer">
        <ion-buttons slot="end">
          <ion-button @click="goToAbout">About</ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-footer>
  </ion-page>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { useRouter } from "vue-router";
import {
  IonHeader,
  IonPage,
  IonToolbar,
  IonTitle,
  IonContent,
  IonCard,
  IonCardContent,
  IonFooter,
  IonButtons,
  IonButton,
} from "@ionic/vue";
import BackButton from "../components/BackButton.vue";

export default defineComponent({
  components: {
    IonHeader,
    IonPage,
    IonToolbar,
    IonTitle,
    IonContent,
    IonCard,
    IonCardContent,
    IonFooter,
    BackButton,
    IonButtons,
    IonButton,
  },
  name: "ImpressumPage",
  setup() {
    const router = useRouter();
    const goToAbout = () => {
      router.push({ name: "AboutPage" });
    };
    return { goToAbout };
  },
});
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  justify-content: left;
  align-items: center;
  text-align: left;
  padding: 16px;
  height: 100%;
  background-color: #f7f3e9;
}

.header-and-footer {
  --background: #e0d9c8;
  text-align: center;
}

h1 {
  font-size: 24px;
  font-weight: bold;
  margin: 20px 0 10px;
}

ion-card {
  margin: 20px 0;
}
</style>
