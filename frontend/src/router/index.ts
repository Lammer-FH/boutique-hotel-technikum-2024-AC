import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import LandingPage from '../views/LandingPage.vue';
import Impressum from '../views/Impressum.vue';
import About from '../views/About.vue';
import RoomSelectionPage from '../views/RoomSelectionPage.vue';
import BookingForm from '../components/BookingForm.vue';
import BookingConfirmation from '../components/BookingConfirmation.vue';
import BookingReview from '../components/BookingReview.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/landing'
  },
  {
    path: '/landing',
    name: 'Landing',
    component: LandingPage
  },
  {
    path: '/impressum',
    name: 'Impressum',
    component: Impressum
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/rooms',
    name: 'Rooms',
    component: RoomSelectionPage
  },
  {
    path: '/booking',
    name: 'BookingForm',
    component: BookingForm,
    props: route => ({
      roomId: route.query.roomId,
      startDate: route.query.startDate,
      endDate: route.query.endDate
    })
  },
  {
    path: '/bookingreview',
    name: 'BookingReview',
    component: BookingReview
  },
  {
    path: '/bookings/:id',
    name: 'BookingConfirmation',
    component: BookingConfirmation,
    props: true,
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router