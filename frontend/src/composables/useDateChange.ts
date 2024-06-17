// src/composables/useDateChange.ts
import { ref } from 'vue';
import { useRoomSelectionStore } from '../stores/useRoomSelectionStore';
import { formatDate } from '../utils/dateUtils'; 

export function useDateChange() {
  const roomSelectionStore = useRoomSelectionStore();
  const minEndDate = ref(new Date().toISOString().split('T')[0]); // Today's date as min end date

  const onStartDateChange = (event: CustomEvent) => {
    const target = event.target as HTMLIonDatetimeElement;
    const selectedDate = new Date(target.value as string);
    selectedDate.setDate(selectedDate.getDate() + 1); // Set end date minimum to the day after start date
    minEndDate.value = selectedDate.toISOString().split('T')[0]; // Update minEndDate
    const formattedStartDate = formatDate(String(target.value));
    roomSelectionStore.updateStartDate(formattedStartDate);
    roomSelectionStore.updateEndDate(formatDate(selectedDate.toISOString())); // Set endDate to default to the day after start date
  };

  const onEndDateChange = (event: CustomEvent) => {
    const target = event.target as HTMLIonDatetimeElement;
    const formattedEndDate = formatDate(String(target.value));
    roomSelectionStore.updateEndDate(formattedEndDate);
  };

  return {
    minEndDate,
    onStartDateChange,
    onEndDateChange,
  };
}
