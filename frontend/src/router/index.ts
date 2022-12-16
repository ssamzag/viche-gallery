import {createRouter, createWebHistory} from "vue-router";
import PostWriteView from "../views/post/WriteView.vue";
import PostListView from "../views/post/ListView.vue";
import PostReadView from "../views/post/ReadView.vue";
import WorkListView from "../views/work/ListView.vue";
import AboutView from "../views/about/AboutView.vue";
import WorkWriteView from "../views/work/WriteView.vue";
import LoginView from "../views/login/LoginView.vue";
import NotFoundView from "../views/NotFoundView.vue";

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
            component: PostWriteView,
            meta: {auth: true}
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
        },
        {
            path: "/about",
            name: "about",
            component: AboutView,
        },
        {
            path: "/work/write",
            name: "workWrite",
            component: WorkWriteView,
            meta: {auth: true}
        },
        {
            path: "/Login",
            name: "login",
            component: LoginView,
            meta: {login: true}
        },
        {
            path: "/:pathMatch(.*)*",
            name: "notFound",
            component: NotFoundView
        }
    ],
});

router.beforeEach((to, from, next) => {
    const token = localStorage.getItem("token")
    if (to.meta.auth && !token) {
        next('/login')
        return
    }
    if (to.meta.login && token) {
        next('/')
        return
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