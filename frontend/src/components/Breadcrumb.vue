<template>
    <ion-toolbar class = "breadcrumb-toolbar">
        <ion-buttons slot="start">
            <ion-back-button defaultHref="/" text="Zurück zur Startseite"></ion-back-button>
        </ion-buttons>
    </ion-toolbar>
</template>

<script>
import { IonToolbar, IonButtons, IonBackButton } from '@ionic/vue';
export default {
    name: 'Breadcrumb',
    components: {
        IonToolbar,
        IonButtons,
        IonBackButton,
    },
};
</script>

<style scoped>
.breadcrumb-toolbar {
  --background: #e0d9c8;
  --color: #000000;
}

ion-back-button {
  --color: #000000;
}

</style>