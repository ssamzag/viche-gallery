<template>
  <LabelComponent v-model:title="firstname" label="제목"></LabelComponent>
  <Username v-model:firstanme="firstname" v-model:lastname="lastname"></Username>
  <b-container >
    <b-row>
      <b-col class="px-0 col-6" v-for="com in 13" lg="4" xl="2" xxl="1">
        <b-card-img
          src="https://vichegallery.com/api/images/348f193.jpeg"
          alt="Image"
          class="rounded-0"
      ></b-card-img>
      </b-col>
    </b-row>
  </b-container>
</template>

<script setup>
import {ref} from "vue";
import Username from "@/views/test/Username.vue";
import LabelComponent from "@/views/test/LabelInput.vue";

const firstname = ref("최")
const lastname = ref("민호")

</script>

<style scoped>

</style>