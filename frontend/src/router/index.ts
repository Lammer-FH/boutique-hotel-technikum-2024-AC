import { createRouter, createWebHistory } from "@ionic/vue-router";
import { RouteRecordRaw } from "vue-router";
import LandingPage from "../views/LandingPage.vue";
import ImpressumPage from "../views/ImpressumPage.vue";
import AboutPage from "../views/AboutPage.vue";
import RoomSelectionPage from "../views/RoomSelectionPage.vue";
import BookingPage from "../views/BookingPage.vue";
import BookingConfirmationPage from "../views/BookingConfirmationPage.vue";
import BookingReviewPage from "../views/BookingReviewPage.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    redirect: "/landing",
  },
  {
    path: "/landing",
    name: "LandingPage",
    component: LandingPage,
  },
  {
    path: "/impressum",
    name: "ImpressumPage",
    component: ImpressumPage,
  },
  {
    path: "/about",
    name: "AboutPage",
    component: AboutPage,
  },
  {
    path: "/rooms",
    name: "RoomSelectionPage",
    component: RoomSelectionPage,
  },
  {
    path: "/booking",
    name: "BookingPage",
    component: BookingPage,
    props: (route) => ({
      roomId: route.query.roomId,
      startDate: route.query.startDate,
      endDate: route.query.endDate,
    }),
  },
  {
    path: "/bookingreview",
    name: "BookingReviewPage",
    component: BookingReviewPage,
  },
  {
    path: "/bookings/:id",
    name: "BookingConfirmationPage",
    component: BookingConfirmationPage,
    props: true,
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
