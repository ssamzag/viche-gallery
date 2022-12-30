import {defineStore} from 'pinia'
import {ref} from "vue";

export const useAlertStore = defineStore("alert", {
  state: () => ({
    alerts: ref([])
  }),
  actions: {
    vAlert(message: string, type = 'error') {
      // @ts-ignore
      this.alerts.push({message, type})
      setTimeout(() => {
        this.alerts.shift()
      }, 2000)
    },
    vSuccess(message: string) {
      this.vAlert(message, 'success')
    }
  }
})