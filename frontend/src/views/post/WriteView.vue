<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";
import {useAlertStore} from "@/stores/alert";

const router = useRouter();
const {vSuccess, vAlert} = useAlertStore()

const title = ref("")
const content = ref("")
let storedFiles = ref([
  {storeFileName: ""}
])
const file = ref()
const quill = ref()

const write = () => {
  axios.post('/api/posts', {
        title: title.value,
        content: content.value,
        attachments: storedFiles.value
      },
      {
        headers: {
          authorization: "Bearer " + localStorage.getItem("token")
        }
      })
      .then((response) => {
        vSuccess("글쓰기 완료")
        router.replace(response.data)
      })
      .catch(error => {
        vAlert(error.response.message)
      })
}

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
        [...response.data].forEach((res: any) => {
          storedFiles.value = []
          storedFiles.value.push(res.storeFileName)
          const imageHtml = `<img class="img-contnet" src="/api/images/${res.storeFileName}"/>`
          quill.value.setContents(imageHtml + quill.value.getContents())
        })
      })
      .catch(error => {
        file.value = null
        vAlert("업로드 실패")
      })
}
const toolbarOptions = [
  ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
  ['blockquote', 'code-block'],

  [{'list': 'ordered'}, {'list': 'bullet'}],
  [{'script': 'sub'}, {'script': 'super'}],      // superscript/subscript
  [{'indent': '-1'}, {'indent': '+1'}],          // outdent/indent
  [{'direction': 'rtl'}],                         // text direction

  [{'size': ['small', false, 'large', 'huge']}],  // custom dropdown
  [{'header': [1, 2, 3, 4, 5, 6, false]}],

  [{'color': []}, {'background': []}],          // dropdown with defaults from theme
  [{'font': []}],
  [{'align': []}],
  ['video', 'link'],

  ['clean']                                         // remove formatting button
];
</script>

<template>
  <b-col style="max-width:850px">
    <b-row>
      <div>
        <input v-model="title" placeholder="제목을 입력해 주세요" style="width:100%"/>
      </div>
    </b-row>
    <b-row>
      <div class="mt-2">
        <QuillEditor v-model:content="content"
                     ref="quill"
                     contentType="html"
                     theme="snow"
                     :toolbar="toolbarOptions"
                     style="height:500px"/>
      </div>
    </b-row>
    <b-row class="my-3">
      <input multiple ref="file" v-on:change="handleFileUpload" type="file">
    </b-row>
    <b-row style="position: relative; float:right">
      <div class="">
        <b-button squared variant="outline-secondary" @click="write()">글 작성하기</b-button>
      </div>
    </b-row>
  </b-col>
</template>

<style>

</style>