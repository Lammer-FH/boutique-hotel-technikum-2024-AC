import { defineStore } from 'pinia';
import axios from 'axios';

type Guest = {
  id: null | number;
  firstName: string;
  lastName: string;
  email: string;
};

type Booking = {
  id: null | number;
  roomId: number;
  startDate: string;
  endDate: string;
  breakfast: boolean;
}

export const useBookingStore = defineStore ('booking', {
  state: () => ({
    guest: {
      id:null,
      firstName: '',
      lastName: '',
      email: ''
    } as Guest,
    booking: {
        id: null,
        roomId: 123456,
        startDate: '',
        endDate: '',
        breakfast: false
    } as Booking
  }),
  actions: {
    async submitBooking(guestId: number) {
      const bookingData = {
        ...this.booking,
        guestId: guestId
      };

      try {
        const bookingResponse = await axios.post('http://localhost:8080/bookings', bookingData);
        return bookingResponse.data.id;
      } catch (error) {
        console.error('There was an error creating the booking!', error);
        throw error;
      }
    },
    async submitGuest() {
      try {
        const guestResponse = await axios.post('http://localhost:8080/guests', this.guest);
        this.guest.id = guestResponse.data.id;
        return guestResponse.data.id;
      } catch (error) {
        console.error('There was an error creating the guest!', error);
        throw error;
      }
    }
  }
});
