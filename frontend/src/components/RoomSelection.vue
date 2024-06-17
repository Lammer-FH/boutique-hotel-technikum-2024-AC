<template>
  <div class="container">
    <!-- Date pickers and custom select -->
    <div class="datepicker-container">
      <div class="datepicker-item">
        <label>From:</label>
        <ion-datetime-button datetime="startDatetime"></ion-datetime-button>
        <ion-modal :keep-contents-mounted="true">
          <ion-datetime id="startDatetime" presentation="date" @ionChange="onStartDateChange" :min="minDate" :value="startDate"></ion-datetime>
        </ion-modal>
      </div>
      <div class="datepicker-item">
        <label>To:</label>
        <ion-datetime-button datetime="endDatetime"></ion-datetime-button>
        <ion-modal :keep-contents-mounted="true">
          <ion-datetime id="endDatetime" presentation="date" @ionChange="onEndDateChange" :min="minEndDate" :value="endDate"></ion-datetime>
        </ion-modal>
      </div>
    </div>
    <CustomSelect @updateExtras="onExtrasChange" />
    <!-- Room display and pagination -->
    <div v-if="store.loading" class="loading">Loading...</div>
    <div v-else class="rooms-grid">
      <div v-for="room in store.rooms" :key="room.id">
        <RoomCard :room="room" :on-click="navigateToBooking" />
      </div>
    </div>
    <div class="pagination">
      <ion-button @click="prevPage" :disabled="store.page === 0" class="custom-button">Previous</ion-button>
      <span>Page {{ store.page + 1 }}</span>
      <ion-button @click="nextPage" :disabled="!store.hasMoreRooms" class="custom-button">Next</ion-button>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';
import { useRoomSelectionStore } from '../stores/useRoomSelectionStore';
import CustomSelect from '../components/CustomSelect.vue';
import RoomCard from '../components/RoomCard.vue';
import { IonDatetimeButton, IonModal, IonDatetime, IonButton } from '@ionic/vue';

export default defineComponent({
  components: {
    CustomSelect,
    IonDatetimeButton,
    IonModal,
    IonDatetime,
    IonButton,
    RoomCard,
  },
  setup() {
    const store = useRoomSelectionStore();
    const router = useRouter();

    const formatDate = (dateString: string) => {
      const date = new Date(dateString);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, '0');
      const day = String(date.getDate()).padStart(2, '0');
      return `${year}-${month}-${day}`;
    };

    const minDate = new Date().toISOString().split('T')[0]; // Today's date

    // Using ref for minEndDate and endDate
    const minEndDate = ref(minDate);
    const endDate = ref('');

    // Initialize endDate to default to the day after today's date
    const today = new Date();
    today.setDate(today.getDate() + 1); // Set to tomorrow
    endDate.value = today.toISOString().split('T')[0]; // Format as YYYY-MM-DD

    // Initialize startDate to current date
    const startDate = ref(formatDate(new Date().toISOString()));

    const onStartDateChange = (event: CustomEvent) => {
      const target = event.target as HTMLIonDatetimeElement;
      const selectedDate = new Date(target.value as string);
      selectedDate.setDate(selectedDate.getDate() + 1); // Set end date minimum to the day after start date
      minEndDate.value = selectedDate.toISOString().split('T')[0]; // Update minEndDate
      endDate.value = selectedDate.toISOString().split('T')[0]; // Set endDate to default to the day after start date
      const formattedDate = formatDate(String(target.value));
      store.updateStartDate(formattedDate); // Update startDate in store
      store.updateEndDate(endDate.value); // Update endDate in store
    };

    const onEndDateChange = (event: CustomEvent) => {
      const target = event.target as HTMLIonDatetimeElement;
      const formattedDate = formatDate(String(target.value));
      store.updateEndDate(formattedDate);
    };

    const onExtrasChange = (extras: string[]) => {
      store.updateExtras(extras);
    };

    const navigateToBooking = (roomId: number) => {
      const formattedStartDate = store.startDate;
      const formattedEndDate = store.endDate;

      if (!formattedStartDate || !formattedEndDate) {
        console.error('Start date or end date is not defined');
        return;
      }

      router.push({
        name: 'BookingForm',
        query: {
          roomId: roomId.toString(),
          startDate: formattedStartDate,
          endDate: formattedEndDate,
        },
      });
    };

    const prevPage = () => {
      if (store.page > 0) {
        store.page -= 1;
        store.fetchRooms();
      }
    };

    const nextPage = () => {
      if (store.hasMoreRooms) {
        store.page += 1;
        store.fetchRooms();
      }
    };

    onMounted(() => {
      // Prefill store with default values
      store.updateStartDate(startDate.value);
      store.updateEndDate(endDate.value);
      store.fetchRooms();
    });

    return { store, minDate, minEndDate, endDate, startDate, onStartDateChange, onEndDateChange, onExtrasChange, navigateToBooking, prevPage, nextPage };
  }
});
</script>

<style scoped>
.container {
  padding: 16px;
}
.datepicker-container {
  display: flex;
  justify-content: space-between;
  margin-bottom: 16px;
}
.datepicker-item {
  flex: 1;
  margin-right: 16px;
  display: flex;
  align-items: center;
}
.datepicker-item:last-child {
  margin-right: 0;
}
.datepicker-item label {
  margin-right: 8px;
}
.loading {
  text-align: center;
}
.rooms-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 16px;
}
.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 16px;
}
.pagination ion-button {
  margin: 0 8px;
}
.custom-button {
  --background: #847e71;
  --background-activated: #6e685e;
  --background-focused: #6e685e;
  --background-hover: #6e685e;
  --color: #ffffff;
}
</style>
