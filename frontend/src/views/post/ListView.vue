<script setup lang="ts">

import {onMounted, ref} from "vue";
import {useRouter} from "vue-router";
import axios from "axios";

const posts = ref([])
const router = useRouter()

onMounted(() => {
  axios.get(`/api/posts`).then(response => {
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
  router.push("/post/" + id)
}

</script>

<template>
  <b-col>
    <b-row>
      <Title title="POST" subTitle="Work Diary, Daily Life, Etc." :write="{url:'/post/write',text:'WRITE'}"></Title>
    </b-row>
    <b-row>
      <b-card-group columns>
        <b-card
            toggleable="md"
            border-variant="white" bg-variant="white" text-variant="dark"
            v-for="post in posts"
            :img-src="'/api/images/thumbnail/' + post.thumbnailFile"
            img-alt="Image"
            class="small"
            body-border-variant="white"
            @click="read(post.id)"
            style="margin-top: 0.75rem; margin-bottom: 0"
        >
          <b-row>
            <b-col align-self="center" class="p-0">
              <h6 class="ellipsis" style="font-size: 15px">{{ post.title }}</h6>
              <b-card-text class="small text-muted">
                <div class="author-meta" style="font-size:16px">
                  <span class="nickname">
                    VICHE
                  </span>
                  <span class="date">
                      {{ post.createdDate.substring(0, 10) }}
                    </span>
                </div>
<!--                비체•{{ post.createdDate.substring(0, 10) }}-->
              </b-card-text>
            </b-col>
          </b-row>

        </b-card>
      </b-card-group>

    </b-row>
  </b-col>


</template>

<style>
.ellipsis {
  width:300px;
  display:block;
  text-overflow: ellipsis;
  white-space:nowrap;
  overflow:hidden;
}

.author-meta .date {
  float: left;
  margin-left: 10px;
  font-size: 0.7em;
  color: #999;
  line-height: 20px;
}
.author-meta .nickname {
  float: left;
  font-size: 0.775em;
  line-height: 20px;
}
.author-meta span {
  display: inline-block;
}
.post-meta span:before {
  content: "";
  display: inline-block;
  width: 1px;
  height: 9px;
  margin: 0 9px;
  background-color: #b3b3b3;
  vertical-align: middle;
}
.post-meta span:first-child:before {
  content: none;
}
.author-meta .date:before, .author-meta .date a:before {
  content: "";
  display: inline-block;
  width: 1px;
  height: 9px;
  margin-right: 10px;
  background-color: #b2b2b2;
}
</style>