import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import PostWriteView from "../views/post/WriteView.vue";
import PostListView from "../views/post/ListView.vue";
import PostReadView from "../views/post/ReadView.vue";
import WorkListView from "../views/work/ListView.vue";
import AboutView from "../views/about/AboutView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: AboutView,
    },
    {
      path: "/post/write",
      name: "write",
      component: PostWriteView
    },
    {
      path: "/post",
      name: "list",
      component: PostListView

    },
    {
      path: "/post/:postId",
      name: "read",
      component: PostReadView,
      props: true
    },
    {
      path: "/work",
      name: "worklist",
      component: WorkListView,
      props: true
    }
    ,
    {
      path: "/about",
      name: "about",
      component: AboutView,
      props: true
    }
  ],
});

export default router;