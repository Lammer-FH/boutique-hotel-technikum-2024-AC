import { defineStore } from 'pinia';
import axios from 'axios';

export interface Room {
  id: number;
  title: string;
  description: string;
  guestCapacity: number;
  sizeSqm: number;
}

interface RoomSelectionState {
  rooms: Room[];
  loading: boolean;
  startDate: string;
  endDate: string;
  page: number;
  size: number;
  hasMoreRooms: boolean;
}

export const useRoomSelectionStore = defineStore('roomSelection', {
  state: (): RoomSelectionState => ({
    rooms: [],
    loading: true,
    startDate: '',
    endDate: '',
    page: 0,
    size: 5, // Set the size to 5 for 5 rooms per page
    hasMoreRooms: false,
  }),
  actions: {
    async fetchRooms() {
      this.loading = true;
      try {
        const params: Record<string, any> = {
          page: this.page,
          size: this.size,
        };

        if (this.startDate) {
          params.startDate = this.startDate;
        }

        if (this.endDate) {
          params.endDate = this.endDate;
        }

        const response = await axios.get('http://localhost:8080/rooms', { params });
        this.rooms = response.data;
        this.hasMoreRooms = response.data.length === this.size;
      } catch (error) {
        console.error('Error fetching rooms', error);
      } finally {
        this.loading = false;
      }
    },
    updateStartDate(date: string) {
      this.startDate = date;
      this.page = 0; // Reset to first page
      this.fetchRooms();
    },
    updateEndDate(date: string) {
      this.endDate = date;
      this.page = 0; // Reset to first page
      this.fetchRooms();
    },
  },
});