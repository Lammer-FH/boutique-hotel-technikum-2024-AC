<template>
    <ion-page>
        <ion-header>
            <ion-toolbar>
                <ion-title class="ion-text-center">Room Selection Page</ion-title>
            </ion-toolbar>
        </ion-header>


        <div class="container">
            <div class="datepicker-container">

                <div class="datepicker-item">
                    <label>From:</label>
                    <ion-datetime-button datetime="startDatetime"></ion-datetime-button>
                    <ion-modal :keep-contents-mounted="true">
                        <ion-datetime id="startDatetime" presentation="date"></ion-datetime>
                    </ion-modal>
                </div>

                <div class="datepicker-item">
                    <label>To:</label>
                    <ion-datetime-button datetime="endDatetime"></ion-datetime-button>
                    <ion-modal :keep-contents-mounted="true">
                        <ion-datetime id="endDatetime" presentation="date"></ion-datetime>
                    </ion-modal>
                </div>

         <div class="select-container">
          <ion-label>Options</ion-label>
          <ion-select :multiple="true" v-model="selectedOptions" placeholder="Select Options">
            <ion-select-option value="option1">Option 1</ion-select-option>
            <ion-select-option value="option2">Option 2</ion-select-option>
            <ion-select-option value="option3">Option 3</ion-select-option>
            <ion-select-option value="option4">Option 4</ion-select-option>
          </ion-select>
        </div>

            </div>
            <h1>...</h1>

        </div>
    </ion-page>
</template>

<script lang="ts">
import { IonDatetime, IonDatetimeButton, IonModal, IonSelectOption } from '@ionic/vue';
import { defineComponent, ref } from 'vue';

export default defineComponent({
    components: { IonDatetime, IonDatetimeButton, IonModal, IonSelectOption },
    name: 'RoomSelectionPage',
    setup() {
        const selectedOptions = ref([]);
        return { selectedOptions };
    }
});
</script>



<style scoped>
.container {
    padding: 16px;
    text-align: center;
}

.datepicker-container {
    display: flex;
    justify-content: center;
    gap: 16px;
}

h1 {
    margin: 16px 0;
}

.select-container {
  width: 100%;
  max-width: 400px;
  text-align: left;
  margin-bottom: 16px; /* Abstand zum nächsten Element */
}
</style>
