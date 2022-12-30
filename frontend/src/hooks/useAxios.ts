import axios from "axios";
import {isRef, ref, unref, watchEffect} from "vue";

axios.defaults.baseURL = import.meta.env.VITE_APP_API_URL

const defaultConfig = {
    method: "get"
}
export const useAxios = (url: string, config = {params: {}}) => {
    const response = ref()
    const data = ref(null)
    const error = ref(null)
    const loading = ref(false)

    const {params} = config

    const execute = () => {
        axios(url, {
            ...defaultConfig,
            ...config,
            params: unref(params)
        })
            .then((res) => {
                clear();

                data.value = res.data
                response.value = res
                loading.value = true
            }).catch((err) => {
            error.value = err
        }).finally(() => {
            loading.value = false
        })
    }

    runExecute();

    function clear() {
        data.value = null
        error.value = null
    }

    function runExecute() {
        if (isRef(params)) {
            watchEffect(execute)
        } else {
            execute()
        }
    }

    return {
        response,
        data,
        error,
        loading
    }
}
