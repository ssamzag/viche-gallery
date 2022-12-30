import {createRouter, createWebHistory} from "vue-router";

import authRoutes from "@/router/modules/auth";
import aboutRoutes from "@/router/modules/about";
import postRoutes from "@/router/modules/post";
import workRoutes from "@/router/modules/work";
import notFoundRoute from "@/router/modules/notfound";
import testRoutes from "@/router/modules/test";
import mainRoutes from "@/router/modules/main";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        ...authRoutes,
        ...mainRoutes,
        ...aboutRoutes,
        ...postRoutes,
        ...workRoutes,
        ...notFoundRoute,
        ...testRoutes
    ]
});

router.beforeEach((to, from, next) => {
    const token = localStorage.getItem("token")
    if (to.meta.auth && !token) {
        next('/login')
        return false
    }
    if (to.meta.login && token) {
        next('/')
        return false
    }
    if (!sessionStorage.getItem("currentUrl")) {
        sessionStorage.setItem("currentUrl", "/")
    }
    if (to.path !== '/login') {
        sessionStorage.setItem("currentUrl", to.path)
    }

    next()
})

export default router;