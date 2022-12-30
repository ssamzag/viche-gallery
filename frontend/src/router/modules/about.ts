import AboutView from "@/views/about/AboutView.vue";

const aboutRoutes = [
    {
        path: "/about",
        name: "about",
        component: AboutView,
        meta: {
            title: 'Introduce'
        }
    },
]

export default aboutRoutes