<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";
import {useRoute, useRouter} from "vue-router";
import {useAlertStore} from "@/stores/alert";

const title = ref("")
const content = ref("")
const router = useRouter()
const route = useRoute()
const {vSuccess, vAlert} = useAlertStore()
let storedFiles = ref([""])

const write = () => {
  axios.post('/api/works', {
        title: title.value,
        content: content.value,
        workType: selected.value,
        attachments: storedFiles.value
      },
      {
        headers: {
          'Authorization': `Bearer ${localStorage.token}`
        }
      })
      .then(() => {
        vSuccess("작성 완료")
        router.replace({path: "/work"})
      })
      .catch(error => vAlert(error.response))
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
    vAlert("이미지 파일만 업로드 가능합니다")
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
        storedFiles = ref([]);
        [...response.data].forEach(res => {
          storedFiles.value.push(res.storeFileName)
        })
        vSuccess("이미지 업로드 성공")
      })
      .catch(error => {
        file.value = null
        vAlert("업로드 실패")
      })
}
const selected = ref(route.query.workType)
const options = [
  {value: "PORTFOLIO", text: "PORTFOLIO"},
  {value: "STUDY", text: "STUDY"},
]
</script>

<template>
  <div>
    <b-col>
      <b-row>
        <div class="mt-2">
          <b-form-select v-model="selected" :options="options"></b-form-select>
        </div>
      </b-row>
      <b-row>
        <div class="mt-2">
          <b-form-input v-model="title" placeholder="제목을 입력해주세요"></b-form-input>

        </div>
      </b-row>
      <!--      <b-row>-->
      <!--        <div class="mt-2">-->
      <!--          <b-form-textarea-->
      <!--              id="textarea"-->
      <!--              v-model="content"-->
      <!--              placeholder="내용을 입력해주세요"-->
      <!--              rows="10"-->
      <!--              no-resize-->
      <!--              max-rows="6"-->
      <!--          ></b-form-textarea>-->
      <!--        </div>-->
      <!--      </b-row>-->
      <b-row class="mt-2">
        <b-col>
          <input multiple ref="file" v-on:change="handleFileUpload" type="file">
        </b-col>
      </b-row>
      <b-row>
        <b-col class="mt-2">
          <b-button squared variant="outline-secondary" @click="write()">작성하기</b-button>
        </b-col>
      </b-row>
    </b-col>
  </div>
</template>

<style>

</style>