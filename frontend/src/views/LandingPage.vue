<template>
    <ion-page>
        <ion-header>
            <ion-toolbar class="header-and-footer">
                <ion-title>Boutique Hotel Technikum</ion-title>
            </ion-toolbar>
        </ion-header>
        <div class="container">
            <img src="@/assets/logo.png" alt="Technikum Booking Logo" class="hotel-image" />
            <h1 style="text-align: center;">Willkommen im Boutique Hotel Technikum</h1>

            <ion-card>
                <ion-card-content style="background-color:#f7f3e9;">Erleben Sie Luxus und Komfort in unserem exklusiven Hotel am Strand. Ob für einen
                    romantischen Kurzurlaub, einen Familienurlaub oder eine Geschäftsreise, unser Hotel bietet die
                    perfekte Unterkunft für jeden Anlass.</ion-card-content>
            </ion-card>
            <h2>Erleben Sie einen unvergesslichen Aufenthalt</h2>

            <ion-card>
                <ion-card-content style="background-color:#f7f3e9;">
                    Genießen sie den Komfort und die Annehmlichkeiten unserer erstklassigen Zimmer und Suiten.
                </ion-card-content>
            </ion-card>
            <ion-button class="custom-button position-button" expand="block" @click="goToRooms">Book now!</ion-button>
        </div>

        <ion-footer>
            <ion-toolbar class="header-and-footer">
                <ion-title>Impressum</ion-title>
            </ion-toolbar>    
        </ion-footer>

    </ion-page>
</template>

<script lang="ts">
import { useRouter } from 'vue-router';

export default {
    name: 'LandingPage',
    setup() {
        const router = useRouter();
        const goToRooms = () => {
            router.push({ name: 'Rooms' });
        };
        return { goToRooms };
    }
}
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