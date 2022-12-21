<template>
  <label> {{ label }}</label>
  <input v-model="value" type="text">
</template>

<script setup>
import {computed, defineEmits} from "vue";

const props = defineProps(['title', 'label'])
const emit = defineEmits(['update:title'])
const value = computed({
  get() {
    return props.title
  },
  set(value) {
    emit('update:title', value)
  }
})
</script>
<!--<script>-->
<!--// import {computed} from "vue";-->
<!--//-->
<!--// export default {-->
<!--//   // props:['title', 'label'],-->
<!--//   // emits:['update:title'],-->
<!--//   name: "LabelComponent",-->
<!--//   setup(props, {emit}) {-->
<!--//     const value = computed({-->
<!--//       get() {-->
<!--//         return props.title-->
<!--//       },-->
<!--//       set(value) {-->
<!--//         emit('update:title', value)-->
<!--//       }-->
<!--//     })-->
<!--//     return {value};-->
<!--//   }-->
<!--}-->
<!--</script>-->

<style scoped>

</style>