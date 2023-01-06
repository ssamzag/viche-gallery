import AboutView from "@/views/about/AboutView.vue";

const mainRoutes = [
  {
    path: "/",
    name: "home",
    component: AboutView,
    meta: {
      title: 'Home'
    }
  },
]

export default mainRoutes