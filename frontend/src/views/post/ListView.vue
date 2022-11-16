<script setup lang="ts">

import {ElMessage} from "element-plus";
import {defineProps, h, onMounted, ref} from "vue";
import {useRouter} from "vue-router";
import axios from "axios";

const posts1 = [
  {id: 1, title: "샬이 그림이다", content: "내용1", url: "/api/images/25ba047.jpg", create: "2022-03-01"},
  {
    id: 2,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/SCR-20221106-1r4.jpeg",
    create: "2022-03-01"
  },
  {
    id: 3,
    title: "비체 태연이라능!",
    content: "내용111111",
    url: "/api/images/SCR-20221106-1sj.jpeg",
    create: "2022-03-01"
  }, {id: 4, title: "샬이 그림이다", content: "내용1", url: "/api/images/25ba047.jpg", create: "2022-03-01"},
  {
    id: 5,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/SCR-20221106-1r4.jpeg",
    create: "2022-03-01"
  }
]
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
      <Title title="POST" subTitle="Work Diary, Daily Life, Etc." :button="{url:'/post/write',text:'write'}"></Title>
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
              <b-card-text class="small text-muted">비체•{{post.createdDate.substring(0, 10)}}</b-card-text>
            </b-col>
          </b-row>

          <!--        <b-row>-->
          <!--          <b-col align-self="center" class="p-0" cols="auto">-->
          <!--            <img src="/api/images/SCR-20221107-v15.png" style="width:50px"/>-->
          <!--          </b-col>-->
          <!--          <b-col align-self="center">-->
          <!--            <span style="color:#535353; font-size:16px!important">{{ post.title }}</span>-->
          <!--            <b-card-text class="small text-muted">Last updated 3 mins ago</b-card-text>-->
          <!--          </b-col>-->
          <!--        </b-row>-->
        </b-card>
      </b-card-group>

    </b-row>
  </b-col>


</template>

<style>

</style>