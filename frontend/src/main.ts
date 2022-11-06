import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'element-plus/theme-chalk/dark/css-vars.css'

import { QuillEditor } from '@vueup/vue-quill'
import '@vueup/vue-quill/dist/vue-quill.snow.css';
import '@vueup/vue-quill/dist/vue-quill.bubble.css';

const app = createApp(App);
app.use(router);
app.use(ElementPlus)

const globalOptions = {
    debug: 'info',
    modules: {
        toolbar: 'minimal'
    },
    placeholder: 'Compose an epic...',
    readOnly: true,
    theme: 'snow'
}
//QuillEditor.props.globalOptions.default = () => globalOptions
app.component('QuillEditor', QuillEditor)

app.mount("#app");