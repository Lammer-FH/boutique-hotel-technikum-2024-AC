<template>
    <ion-page>
        <ion-header>
            <ion-toolbar class="header-and-footer">
                <ion-title>About</ion-title>
            </ion-toolbar>
            <Breadcrumb />
        </ion-header>

        <ion-content :fullscreen="true" class="ion-padding">
            <div class="container">
                <ion-card>
                    <ion-card-content style="background-color:#f7f3e9;">
                        <p>Willkommen im Boutique Hotel Technikum!</p>
                        <p>Unser Hotel liegt direkt am Strand und bietet luxuriöse Unterkünfte für jeden Anlass.</p>
                        <p>Wir sind stolz darauf, unseren Gästen erstklassigen Service und unvergessliche Erlebnisse zu bieten.</p>
                    </ion-card-content>
                </ion-card>
                <ion-card>
                    <ion-card-content style="background-color:#f7f3e9;">
                        <p>Unsere Mission:</p>
                        <p>Wir möchten Ihren Aufenthalt so angenehm und komfortabel wie möglich gestalten. Unser engagiertes Team steht Ihnen jederzeit zur Verfügung.</p>
                        <p>Kontaktieren Sie uns gerne für weitere Informationen oder besondere Wünsche.</p>
                    </ion-card-content>
                </ion-card>
            </div>
        </ion-content>

        <ion-footer>
            <ion-toolbar class="header-and-footer">
                <ion-buttons slot="end">
                    <ion-button @click="goToImpressum">Impressum</ion-button>
                </ion-buttons>
            </ion-toolbar>
        </ion-footer>
    </ion-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { useRouter } from 'vue-router';
import { IonHeader, IonPage, IonToolbar, IonTitle, IonContent, IonCard, IonCardContent, IonFooter } from '@ionic/vue';
import Breadcrumb from '../components/BackButton.vue';

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
        Breadcrumb
    },
    name: 'About',
    setup () {
        const router = useRouter();
        const goToImpressum = () => {
            router.push({ name: 'Impressum' });
        }
        return { goToImpressum };
    }

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
