// import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

const ApiService = {
    init() {
        // Vue.use(VueAxios, axios)
    },
    get(uri) {
        return axios.get(`${uri}`, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}` || '',
                Accept: 'application/json'
            }
        })
    },
    login(uri, config) {
        return axios.post(`${uri}`, {}, config)
    },
    post(uri, params) {
        return axios.post(`${uri}`, params, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}` || ''
            }
        })
    },
    update(uri, params) {
        return axios.put(uri, params, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}` || ''
            }
        })
    },
    delete(uri) {
        return axios.delete(uri, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}` || ''
            }
        })
    }
}

ApiService.init()

export default ApiService
