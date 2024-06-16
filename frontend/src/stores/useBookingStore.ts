import { defineStore } from 'pinia';
import axios from 'axios';

type Guest = {
  id: null | number;
  firstName: string;
  lastName: string;
  email: string;
};

type Room = {
  id: number;
  title: string;
  description: string;
  guestCapacity: number;
  sizeSqm: number;
};

type Booking = {
  id: null | number;
  room: Room | null;
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
        room: { 
          id: 123456,
          title: 'Test Room',
          description: 'A room for testing purposes',
          guestCapacity: 2,
          sizeSqm: 30,
        } as Room,
        startDate: '',
        endDate: '',
        breakfast: false
    } as Booking
  }),
  actions: {
    async submitBooking(guestId: number) {
      const bookingData = {
        ...this.booking,
        guestId: guestId,
        roomId: this.booking.room ? this.booking.room.id : null,
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
