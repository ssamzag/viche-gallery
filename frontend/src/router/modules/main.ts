import MainView from "@/views/about/AboutView.vue";

const mainRoutes = [
  {
    path: "/",
    name: "home",
    component: MainView,
    meta: {
      title: 'Home'
    }
  },
]

export default mainRoutes