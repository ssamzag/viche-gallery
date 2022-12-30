import LoginView from "@/views/login/LoginView.vue";

const authRoutes = [
    {
        path: "/login",
        name: "login",
        component: LoginView,
        meta: {
            login: true,
            title: "Login"
        }
    },
]

export default authRoutes