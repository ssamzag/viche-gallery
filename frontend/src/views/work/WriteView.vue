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
      },
      {
        headers: {
          'Authorization': `Bearer ${localStorage.token}`
        }
      })
      .then(() => router.replace("/work"))
      .catch(error => alert(error.response))
}
const file = ref()
const validateFiles = () => {
  const errors = [];

  [...file.value.files].forEach(file => {
        const ext = file.name.split('.').pop().toLowerCase();
        if (!['bmp', 'png', 'jpg', 'jpeg', 'gif'].includes(ext)) {
          errors.push(file.name)
        }
      }
  )

  if (errors.length > 0) {
    file.value.clear()
    alert("이미지 파일만 업로드 가능합니다")
    throw new Error("이미지 파일 아님")
  }
}

const handleFileUpload = () => {
  validateFiles()

  let formData = new FormData();
  [...file.value.files].forEach(file =>
      formData.append("multipartFiles", file)
  );

  axios.post("/api/images/upload", formData,
      {
        headers: {
          'Content-Type': 'multipart/form-data',
          'Authorization': `Bearer ${localStorage.token}`
        }
      })
      .then((response) => {
        console.log(response.data);
        storedFiles = ref([]);
        [...response.data].forEach(res => {
          storedFiles.value.push(res.storeFileName)
        })
      })
      .catch(error => {
        file.value = null
        alert("업로드 실패")
      })
}
</script>

<template>
  <div>
    <b-col>
      <b-row>
        <input multiple ref="file" v-on:change="handleFileUpload" type="file"></b-row>
      <b-row>
        <div class="mt-2">
          <input v-model="title" placeholder="제목을 입력해 주세요"/>
        </div>
      </b-row>
      <b-row>
        <div class="mt-2">
          <input v-model="content" placeholder="내용을 입력해 주세요"/>
        </div>
      </b-row>
      <b-row>
        <div class="mt-2">
          <b-button squared variant="outline-secondary" @click="write()" >작성하기</b-button>
        </div>
      </b-row>
    </b-col>
  </div>
</template>

<style>

</style>