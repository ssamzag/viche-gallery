import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store"

import BootstrapVue3 from 'bootstrap-vue-3'
import { QuillEditor } from '@vueup/vue-quill'
import VueEasyLightbox from 'vue-easy-lightbox';
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { fab } from '@fortawesome/free-brands-svg-icons'
import KakaoLogin from 'vue3-kakao-login'
import {BToastPlugin} from 'bootstrap-vue-3'

import vue3GoogleLogin from 'vue3-google-login'

import '@vueup/vue-quill/dist/vue-quill.snow.css';
import '@vueup/vue-quill/dist/vue-quill.bubble.css';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import "@noonnu/maruburi-regular"
import '@kfonts/nanum-gothic'
import 'vue-easy-lightbox/external-css/vue-easy-lightbox.css'
import './assets/gallery.css'

library.add(fab, fas)

const app = createApp(App);
app.use(router);
app.use(VueEasyLightbox)
app.use(BootstrapVue3)
app.use(store)
app.use(BToastPlugin)

app.use(KakaoLogin, {apiKey : "javascript key"})

const clientId = "149959106613-aobfaeltked69ejhppv7d3h5nmmv3b1d"

app.use(vue3GoogleLogin, {
    clientId: clientId,
    scope: "email"
})

app.config.globalProperties.$token = ""

app.component('QuillEditor', QuillEditor)
app.component('font-awesome-icon', FontAwesomeIcon)

app.mount("#app");
