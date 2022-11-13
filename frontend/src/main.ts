import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import BootstrapVue3 from 'bootstrap-vue-3'
import { QuillEditor } from '@vueup/vue-quill'
import VueEasyLightbox from 'vue-easy-lightbox';
import VueUploadComponent from 'vue-upload-component'
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { fab } from '@fortawesome/free-brands-svg-icons'

import '@vueup/vue-quill/dist/vue-quill.snow.css';
import '@vueup/vue-quill/dist/vue-quill.bubble.css';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import "@noonnu/maruburi-regular"
import '@kfonts/nanum-gothic'
import 'vue-easy-lightbox/external-css/vue-easy-lightbox.css'
import './assets/gallery.css'

const app = createApp(App);
app.use(router);
app.use(VueEasyLightbox)
app.use(BootstrapVue3)
library.add(fab, fas)
app.component('QuillEditor', QuillEditor)
app.component('file-upload', VueUploadComponent)
app.component('font-awesome-icon', FontAwesomeIcon)

app.mount("#app");
