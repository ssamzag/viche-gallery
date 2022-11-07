import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import BootstrapVue3 from 'bootstrap-vue-3'

import { QuillEditor } from '@vueup/vue-quill'
import '@vueup/vue-quill/dist/vue-quill.snow.css';
import '@vueup/vue-quill/dist/vue-quill.bubble.css';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import "@noonnu/maruburi-regular"
import '@kfonts/nanum-gothic'

const app = createApp(App);
app.use(router);

app.component('QuillEditor', QuillEditor)

app.use(BootstrapVue3)
app.mount("#app");
