import {defineStore} from "pinia";
import AuthService from "@/api/modules/auth";
import {ref} from "vue";

export const useUserStore = defineStore("userStore", {
  state: () => ({
    accessToken: "",
    loginStatus: !!localStorage.getItem('token')
  }),
  getters: {
    getAccessToken(state) {
      return state.accessToken
    },
    isLogin(state) {
      return state.loginStatus
    }
  },
  actions: {
    async login(userInfo: object) {
      const login = await AuthService.login(userInfo)
      localStorage.setItem('token', login.data.accessToken)
      this.accessToken = login.data.accessToken
      this.loginStatus = true
    },
    logout() {
      localStorage.setItem('token', "")
      this.accessToken = ""
      this.loginStatus = false
    }
  }
})