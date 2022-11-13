<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const title = ref("")
const content = ref("")
const router = useRouter();

const write = () => {
  axios.post('/api/posts', {
    title: title.value,
    content: content.value
  })
      .then((response) => router.replace(response.headers.location))
      .catch(error => console.log(error))
}


</script>

<template>
  <div>
    <input v-model="title" placeholder="제목을 입력해 주세요"/>
  </div>
  <div class="mt-2">
    <QuillEditor v-model:content="content"
                 contentType="html"
                 theme="snow"
                 toolbar="essential"
                 style="height:500px"/>
  </div>
  <div class="mt-2">
    <b-button @click="write()">글 작성하기</b-button>
  </div>

</template>

<style>

</style>