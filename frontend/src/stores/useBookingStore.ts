import { defineStore } from 'pinia';
import axios from 'axios';

export const useBookingStore = defineStore('booking', {
  state: () => ({
    guest: {
      firstName: '',
      lastName: '',
      email: ''
    },
    booking: {
      roomId: 123456,
      startDate: '',
      endDate: '',
      breakfast: false
    }
  }),
  actions: {
    async submitBooking(guestId: number) {
      const bookingData = {
        ...this.booking,
        guestId: guestId
      };

      try {
        const bookingResponse = await axios.post('http://localhost:8080/bookings', bookingData);
        alert('Booking confirmed: ' + bookingResponse.data.id);
      } catch (error) {
        console.error('There was an error creating the booking!', error);
      }
    },
    async submitGuest() {
      try {
        const guestResponse = await axios.post('http://localhost:8080/guests', this.guest);
        return guestResponse.data.id;
      } catch (error) {
        console.error('There was an error creating the guest!', error);
        throw error;
      }
    }
  }
});
