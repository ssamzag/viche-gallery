import WorkListView from "@/views/work/ListView.vue";
import WorkWriteView from "@/views/work/WriteView.vue";

const workRoutes = [
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
    path: "/work/write",
    name: "workWrite",
    component: WorkWriteView,
    meta: {
      auth: true,
      title: "Work Write"
    }
  },
]

export default workRoutes