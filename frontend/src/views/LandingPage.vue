<template>
    <ion-page>
        <ion-header>
            <ion-toolbar class="header-and-footer">
                <ion-title>Boutique Hotel Technikum</ion-title>
            </ion-toolbar>
        </ion-header>

        <ion-content :fullscreen="true" class="ion-padding">
            <div class="container">
                <img src="@/assets/logo.png" alt="Technikum Booking Logo" class="hotel-image" />
                <h1 style="text-align: center;">Willkommen im Boutique Hotel Technikum</h1>

                <ion-card class="card-content">
                    <ion-card-content class="card-content" style="background-color:#f7f3e9;">Erleben Sie Luxus und Komfort in unserem
                        exklusiven Hotel am Strand. Ob für einen
                        romantischen Kurzurlaub, einen Familienurlaub oder eine Geschäftsreise, unser Hotel bietet die
                        perfekte Unterkunft für jeden Anlass.</ion-card-content>
                </ion-card>
                <h2>Erleben Sie einen unvergesslichen Aufenthalt</h2>

                <ion-card class="card-content">
                    <ion-card-content style="background-color:#f7f3e9;">
                        Genießen sie den Komfort und die Annehmlichkeiten unserer erstklassigen Zimmer und Suiten.
                    </ion-card-content>
                </ion-card>
                <div class="button-container">
                     <ion-button class="custom-button position-button" expand="block" @click="goToRooms">Book
                    now!</ion-button>   
                </div>
            
            </div>
        </ion-content>

        <ion-footer>
            <ion-toolbar class="header-and-footer">
                <ion-buttons slot="end">
                    <ion-button @click="goToImpressum">Impressum</ion-button>
                    <ion-button @click="goToAbout">About</ion-button>
                </ion-buttons>
            </ion-toolbar>
        </ion-footer>

    </ion-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { useRouter } from 'vue-router';
import { IonHeader, IonPage, IonToolbar, IonTitle, IonContent, IonCard, IonCardContent, IonButton, IonFooter } from '@ionic/vue';

export default defineComponent({
    components: {
        IonHeader,
        IonPage,
        IonToolbar,
        IonTitle,
        IonContent,
        IonCard,
        IonCardContent,
        IonButton,
        IonFooter
    },
    name: 'LandingPage',
    setup() {
        const router = useRouter();
        const goToRooms = () => {
            router.push({ name: 'Rooms' });
        };
        const goToImpressum = () => {
            router.push({ name: 'Impressum'})
        };
        const goToAbout = () => {
            router.push({ name: 'About' });
        };
        return { goToRooms, goToImpressum, goToAbout};
    }
});
</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    text-align: left;
    padding: 16px;
    height: 100%;
    background-color: #f7f3e9;
    box-sizing: border-box;
}

.card-content {
     white-space: normal;
    overflow: hidden;
    overflow-y: auto;
    text-overflow: ellipsis;
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

.button-container {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    margin: 20px 0;
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
    max-height: 100%;
    display: flex;
    flex-direction: column;
}

ion-button {
    margin-top: 20px;
}


</style>