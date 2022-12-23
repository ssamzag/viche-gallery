import {createRouter, createWebHistory} from "vue-router";
import PostWriteView from "../views/post/WriteView.vue";
import PostListView from "../views/post/ListView.vue";
import PostReadView from "../views/post/ReadView.vue";
import WorkListView from "../views/work/ListView.vue";
import AboutView from "../views/about/AboutView.vue";
import WorkWriteView from "../views/work/WriteView.vue";
import LoginView from "../views/login/LoginView.vue";
import NotFoundView from "../views/NotFoundView.vue";
import PostModifyView from "../views/post/ModifyView.vue";
import TestView from "../views/test/TestView.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: "/",
            name: "home",
            component: AboutView,
            meta: {
                title: 'Home'
            }
        },
        {
            path: "/post/write",
            name: "write",
            component: PostWriteView,
            meta: {
                auth: true,
                title: 'POST WRITE'
            }
        },
        {
            path: "/post",
            name: "list",
            component: PostListView,
            meta: {
                title: 'Post'
            }
        },
        {
            path: "/post/:postId",
            name: "PostDetail",
            component: PostReadView,
            props: true,
            meta: {
                title: ''
            }
        },
        {
            path: "/post/modify/:postId",
            name: "postModify",
            component: PostModifyView,
            props: true,
            meta: {
                title: 'Post Modify',
                pageDesc: '',
            }
        },
        {
            path: "/work",
            name: "worklist",
            component: WorkListView,
            props: {
                pageTitle: 'works',
                pageDesc: 'Illustration works of VICHE'

            },
            meta: {
                title: 'Works',
                keepAlive: false
            }
        },
        {
            path: "/about",
            name: "about",
            component: AboutView,
            meta: {
                title: 'Introduce'
            }
        },
        {
            path: "/work/write",
            name: "workWrite",
            component: WorkWriteView,
            meta: {
                auth: true,
                title: "Work Write"
            }
        },
        {
            path: "/login",
            name: "login",
            component: LoginView,
            meta: {
                login: true,
                title: "Login"
            }
        },
        {
            path: "/TestView",
            name: "test",
            component: TestView
        },
        {
            path: "/:pathMatch(.*)*",
            name: "notFound",
            component: NotFoundView,
            meta: {
                title: "404 Error"
            }
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