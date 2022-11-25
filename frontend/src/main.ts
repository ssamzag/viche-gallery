import {createApp, ref} from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store"
import axios from "@/api/axios"

import BootstrapVue3 from 'bootstrap-vue-3'
import { QuillEditor } from '@vueup/vue-quill'
import VueEasyLightbox from 'vue-easy-lightbox';
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { fab } from '@fortawesome/free-brands-svg-icons'
import {BToastPlugin} from 'bootstrap-vue-3'

import '@vueup/vue-quill/dist/vue-quill.snow.css';
import '@vueup/vue-quill/dist/vue-quill.bubble.css';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import "@noonnu/maruburi-regular"
import '@kfonts/nanum-gothic'
import 'vue-easy-lightbox/external-css/vue-easy-lightbox.css'
import './assets/gallery.css'
import type {Ref, UnwrapRef} from "@vue/reactivity";

library.add(fab, fas)

const app = createApp(App);
app.use(router);
app.use(VueEasyLightbox)
app.use(BootstrapVue3)
app.use(store)
app.use(BToastPlugin)


app.provide('login', ref(false))

app.component('QuillEditor', QuillEditor)

app.component('font-awesome-icon', FontAwesomeIcon)
app.mount("#app");
