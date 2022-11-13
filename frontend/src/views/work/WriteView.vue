<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const title = ref("")

const content = ref("")
const router = useRouter();

let storedFiles = ref([""])

const write = () => {
  axios.post('/api/works', {
    title: title.value,
    content: content.value,
    attachments: storedFiles.value
  })
      .then((response) => router.replace("/work"))
      .catch(error => console.log(error))
}
const file = ref()

const handleFileUpload =  () => {
  let formData = new FormData();
  [...file.value.files].forEach(file =>
      formData.append("multipartFiles", file));

  axios.post("/api/images/upload", formData,
      {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
      .then((response) => {
        console.log(response.data);
        storedFiles = ref([]);
         [...response.data].forEach(res => {
          storedFiles.value.push(res.storeFileName)
        })
      })
}

</script>

<template>
  <input multiple ref="file" v-on:change="handleFileUpload" type="file">
  <div>
    <input v-model="title" placeholder="제목을 입력해 주세요"/>
    <input v-model="content" placeholder="내용을 입력해 주세요"/>
  </div>
  <div class="mt-2">
  </div>
  <div class="mt-2">
    <b-button @click="write()">작성하기</b-button>
  </div>
</template>

<style>

</style>