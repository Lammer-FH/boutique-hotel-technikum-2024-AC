import { defineStore } from 'pinia';
import axios from 'axios';

export const useBookingStore = defineStore('booking', {
  state: () => ({
    guest: {
        id: null as null | number,
        firstName: '',
        lastName: '',
        email: ''
    },
    booking: {
        id: null as null | number,
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
        guestId: this.guest.id
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
    },
    async updateBooking() {
        try {
          await axios.put(`http://localhost:8080/bookings/${this.booking.id}`, this.booking);
          console.log('Booking updated successfully.');
        } catch (error) {
          console.error('Error updating booking:', error);
          throw error;
        }
      },
      async updateGuest() {
        try {
          await axios.put(`http://localhost:8080/guests/${this.guest.id}`, this.guest);
          console.log('Guest updated successfully.');
        } catch (error) {
          console.error('Error updating guest:', error);
          throw error;
        }
      }
  }
});
