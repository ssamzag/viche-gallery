import PostWriteView from "@/views/post/WriteView.vue";
import PostListView from "@/views/post/ListView.vue";
import PostReadView from "@/views/post/ReadView.vue";
import PostModifyView from "@/views/post/ModifyView.vue";

const postRoutes = [
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
]
export default postRoutes