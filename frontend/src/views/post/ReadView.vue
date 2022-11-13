<script setup lang="ts">
import {defineProps, onMounted, ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const router = useRouter()

const props = defineProps({
  postId: {
    type: [Number, String],
    require: true
  }
})

const post = ref({
  title: "",
  content: ""
})

onMounted(() => {
  axios.get(`/api/posts/${props.postId}`).then(response => {
    post.value.title = response.data.title
    const clean = sanitizeHtml(response.data.content, {
      allowedTags: ['p', 'b', 'i', 'em', 'strong', 'a', 'br', 'li', 'blockquote', 'h1', 'ol',
      'spellcheck', 'pre', 'span'],
      allowedAttributes: {
        'a': ['href']
      },
      allowedIframeHostnames: ['www.youtube.com']
    });
    post.value.content = clean
    //post.value.content = response.data.content
  })
})

const moveToEdit = function () {

}

const moveToList = function() {
  router.push("/post")
}
</script>

<template>
  <b-row class="p-1">
    <b-col>
      <div>
        <b-card-text class="text-muted">
          잡담
        </b-card-text>
      </div>
      <h2 class="title">{{ post.title }}</h2>
      <div class="sub">
        <b-card-text class="text-muted">
          비체•3일 전
        </b-card-text>
      </div>
    </b-col>
  </b-row>

  <b-row class="">
    <b-col>
      <div class="content " v-html="post.content"></div>
    </b-col>
  </b-row>
  <b-row class="p-3">
    <b-col>
      <div class="d-flex justify-content-end">
        <b-button @click="moveToList()">목록</b-button>
      </div>
      <div class="d-flex justify-content-end">
        <b-button @click="moveToEdit()">수정</b-button>
      </div>
    </b-col>
  </b-row>
</template>

<style>
.title {
  font-size: 1.6rem;
  font-weight: 600;
  color: #383838;
  margin-top: 10px;
}

.sub {
  margin-top: 10px;
  font-size: 0.78rem;
}

.regDate {
  margin-left: 10px;
  color: #6b6b6b;
}

.content {
  font-size: 0.95rem;
  margin-top: 12px;
  color: #616161;
  white-space: break-spaces;
  line-height: 1.5;
}
</style>