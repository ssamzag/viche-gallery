import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import WriteView from "../views/post/WriteView.vue";
import ListView from "../views/post/ListView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/post/write",
      name: "write",
      component: WriteView
    },
    {
      path: "/post",
      name: "list",
      component: ListView

    }
  ],
});

export default router;