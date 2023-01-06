import NotFoundView from "@/views/NotFoundView.vue";

const notFoundRoutes = [
  {
    path: "/:pathMatch(.*)*",
    name: "notFound",
    component: NotFoundView,
    meta: {
      title: "404 Error"
    }
  }
]

export default notFoundRoutes
