<template>
  <transition name="slide-fade">
    <div  class="app-alert" v-if="show">
      <b-alert :variant="alertStyle" :modelValue="show">{{ message }}</b-alert>
    </div>
  </transition>
</template>

<script setup type="ts">
import {computed} from "vue";

const props = defineProps({
  show: {
    type: Boolean,
    default: false
  },
  message: {
    type: String,
    required: true
  },
  type: {
    type: String,
    default: "error",
    validator: value => ["success", "error"].includes(value)
  }
})

const alertStyle = computed(() => props.type === "error" ? "danger" : "success")
</script>

<style scoped>
.app-alert {
  position: fixed;
  top: 100px;
  right: 10px
}

.slide-fade-enter-active {
  transition: all 0.5s ease-out;
}

.slide-fade-leave-active {
  transition: all 0.5s cubic-bezier(1, 0.5, 0.8, 1);
}

.slide-fade-enter-from,
.slide-fade-leave-to {
  transform: translatey(-10px);
  opacity: 0;
}
</style>