<template>
    <ion-page>
        <ion-header>
            <ion-toolbar>
                <ion-title>Boutique Hotel Technikum 2024-ac</ion-title>
            </ion-toolbar>
        </ion-header>
    <div class="container">
                <img src="@/assets/logo.png" alt="Technikum Booking Logo" class="hotel-image"/>  
                    <h1>Willkommen bei Technikum Booking</h1>
                    <p>Bitte wählen Sie Ihr Datum und Zimmer</p>
                    <h2>Erleben Sie einen unvergesslichen Aufenthalt</h2>
                    <ion-card>
                        <ion-card-content>
                            Genießen sie den Komfort und die Annehmlichkeiten unserer erstklassigen Zimmer und Suiten.
                        </ion-card-content>
                    </ion-card>
                    <ion-button expand="block" @click="goToRooms">Book now!</ion-button>
                </div>

    </ion-page>
</template>

<script lang="ts">
import { useRouter } from 'vue-router';

export default {
    name: 'LandingPage',
    setup() {
        const router = useRouter();
        const goToRooms = () => {
            router.push({ name: 'Rooms'});
        };
        return { goToRooms };
    }    
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding: 16px;
  height: 100%;
}

.hotel-image {
    width: 100%;
  max-width: 600px;
  height: auto;
  margin: 20px auto;
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
</style>