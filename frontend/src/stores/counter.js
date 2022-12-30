import {defineStore} from "pinia"

export const useCounterStore = defineStore("counter", {
  state: () => ({
    counter: 0,
  }),
  getters: {
    doubleCount: state => state.counter * 2,
    doubleCountPlusOne() {
      return this.doubleCount + 1
    }
  },
  actions: {
    increment() {
      this.counter++;
    }
  }
})
