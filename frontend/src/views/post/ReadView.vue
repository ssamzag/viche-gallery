<script setup lang="ts">
import {onMounted, ref} from "vue";
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
    // const clean = sanitizeHtml(response.data.content, {
    //   allowedTags: ['p', 'b', 'i', 'em', 'strong', 'a', 'br', 'li', 'blockquote', 'h1', 'ol',
    //   'spellcheck', 'pre', 'span'],
    //   allowedAttributes: {
    //     'a': ['href']
    //   },
    //   allowedIframeHostnames: ['www.youtube.com']
    // });
    // post.value.content = clean
    post.value.content = response.data.content
  })
})

const moveToEdit = function () {

}

const moveToList = function () {
  router.push("/post")
}
</script>

<template>
  <b-col>
    <b-row>
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

    <b-row class="my-3">
      <div class="content " v-html="post.content" style="max-width:1000px;">
      </div>
    </b-row>
    <b-row class="my-3">
      <b-col>
        <div class="d-flex justify-content-end" style="position: relative; float:left; margin-left:0">
          <b-button squared variant="outline-secondary" @click="moveToList()">목록</b-button>
        </div>
      </b-col>
      <b-col>
        <div class="d-flex justify-content-end" style="position: relative; float:right">
          <b-button squared variant="outline-secondary" @click="moveToEdit()">수정</b-button>
        </div>
      </b-col>
    </b-row>
  </b-col>
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
.content img {
  width: 100%;
  height: auto;
  object-fit: contain;
  display: block;
}
.content {
  font-size: 0.95rem;
  margin-top: 12px;
  color: #616161;
  white-space: break-spaces;
  line-height: 1.5;
}
</style>