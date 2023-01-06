import axios from 'axios'

const ApiService = {
  init() {
  },
  get(uri: String) {
    return axios.get(`${uri}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}` || '',
        Accept: 'application/json'
      }
    })
  },
  login(uri: string, config: object) {
    return axios.post(`${uri}`, {}, config)
  },
  post(uri: string, params: object) {
    return axios.post(`${uri}`, params, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}` || ''
      }
    })
  },
  update(uri: string, params: object) {
    return axios.put(uri, params, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}` || ''
      }
    })
  },
  delete(uri: string) {
    return axios.delete(uri, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}` || ''
      }
    })
  }
}

ApiService.init()

export default ApiService
