<script setup lang="ts">

import {ElMessage} from "element-plus";
import {h, onMounted, ref} from "vue";
import {useRouter} from "vue-router";
import axios from "axios";

const posts = ref([])
const router = useRouter()

onMounted(() => {
  axios.get(`/api/posts`).then(response => {
    console.log(response);

    [...response.data.postResponses].forEach(r => posts.value.push(r))
  })

  // const clean = sanitizeHtml(response.data.content, {
  //   allowedTags: ['p', 'b', 'i', 'em', 'strong', 'a', 'br', 'li', 'blockquote', 'h1', 'ol',
  //   'spellcheck', 'pre', 'span'],
  //   allowedAttributes: {
  //     'a': ['href']
  //   },
  //   allowedIframeHostnames: ['www.youtube.com']
  // });
  // post.value.content = clean
})

const read = (id) => {
  router.replace("/post/" + id)
}

</script>

<template>
  <b-col>
    <b-row>
      <Title title="POST" subTitle="Work Diary, Daily Life, Etc." :write="{url:'/post/write',text:'write'}"></Title>
    </b-row>
    <b-row>
      <b-card-group columns>
        <b-card
            toggleable="md"
            border-variant="white" bg-variant="white" text-variant="dark"
            v-for="post in posts"
            :img-src="'/api/images/' + post.thumbnailFile"
            img-alt="Image"
            class="small"
            body-border-variant="white"
            @click="read(post.id)"
        >
          <b-row>
            <b-col align-self="center" class="p-0">
              <h6>{{ post.title }}</h6>
              <b-card-text class="small text-muted">비체•{{ post.createdDate.substring(0, 10) }}</b-card-text>
            </b-col>
          </b-row>

        </b-card>
      </b-card-group>

    </b-row>
  </b-col>


</template>

<style>

</style>