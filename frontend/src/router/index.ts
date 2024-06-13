import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import LandingPage from '../views/LandingPage.vue';
import RoomSelectionPage from '../views/RoomSelectionPage.vue';
import BookingForm from '../components/BookingForm.vue';

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
    path: '/rooms',
    name: 'Rooms',
    component: RoomSelectionPage
  },
  {
    path: '/booking',
    name: 'BookingForm',
    component: BookingForm
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
