<template>
  <div>
    <input
        type="text"
        :value="firstName"
        @input="$emit('update:firstName', $event.target.value)"
    />
    <input
        type="text"
        :value="lastName"
        @input="$emit('update:lastName', $event.target.value)"
    />
<!--    <LabelInput label="성"-->
<!--                :model-value="firstname"-->
<!--                @update:model-value="value => $emit('update:firstname', value)"-->
<!--    ></LabelInput>-->
<!--    <LabelInput label="이름"-->
<!--                :model-value="lastname"-->
<!--                @update:model-value="value => $emit('update:lastname', value)"-->
<!--    ></LabelInput>-->
  </div>
</template>

<script setup>
import LabelInput from "@/views/test/LabelInput.vue";

defineProps({
  firstName: String,
  lastName: String
})

defineEmits(['update:firstName', 'update:lastName'])

// const props = defineProps(['firstname', 'lastname'])

</script>

<!--<script>-->
<!--import LabelInput from "@/views/test/LabelInput.vue";-->

<!--export default {-->
<!--  props: ['firstname', 'lastname'],-->
<!--  // emits: ['update:firstname', 'update:lastname'],-->
<!--  components: {-->
<!--    LabelInput-->
<!--  },-->
<!--  setup() {-->
<!--    return {}-->
<!--  }-->
<!--}-->

<!--</script>-->

<style scoped>

</style>