import {fileURLToPath, URL} from "node:url";

import {defineConfig} from "vite";
import vue from "@vitejs/plugin-vue";
import vueJsx from "@vitejs/plugin-vue-jsx";
import Components from 'unplugin-vue-components/vite'
import {BootstrapVue3Resolver} from 'unplugin-vue-components/resolvers'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue(),
        vueJsx(),
        Components({
            resolvers: [BootstrapVue3Resolver()]
        })],
    resolve: {
        alias: {
            "@": fileURLToPath(new URL("./src", import.meta.url)),
            //'vue-easy-lightbox': 'vue-easy-lightbox/dist/external-css/vue-easy-lightbox.esm.min.js'
        },
    },
    server: {
        proxy: {
            "/api": {
                target: "http://localhost:8080",
                rewrite: (path) => path.replace(/^\/api/, "")
            }
        }
    }
});
