<script setup type="ts">
import {defineComponent, onMounted, ref} from "vue";
import axios from "axios";
import VueEasyLightbox from "vue-easy-lightbox";
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";

const posts = ref([])
const imgsRef = ref([])
let index = 0;

const visibleRef = ref(false)
const moveRef = ref(false)
const indexRef = ref(0) // default 0

const onShow = () => visibleRef.value = true
const onHide = () => visibleRef.value = false
const onMoveDisable = () => moveRef.value = false

const showImg = (index) => {
  indexRef.value = index
  onShow()
}

onMounted(() => {
  axios.get(`/api/works`).then(response => {
    response.data
        .forEach((r) => {
          r.attachments = r.attachments
              .map(fileName => '/api/images/' + fileName)
          r.attachments
              .forEach(src => imgsRef.value
                  .push({title: r.title, src: src}))

          posts.value.push(r)
          r.imageStartIndex = index
          index += r.attachments.length
        })
  })
})


</script>

<template>
  <b-col>
    <b-row>
      <Title title="WORKS" subTitle="illustration works of VICHE." :button="{url:'/work/write',text:'write'}"></Title>
    </b-row>
    <b-row>
      <div class="gallery-container" style="display: block;">
        <div class="gallery">
          <div v-for="post in posts" class="project artist-profile">
            <a @click="showImg(post.imageStartIndex)" class="project-image" target="_self">
              <ul class="icons-list">
                <li v-if="post.attachments.length > 1">
                  <font-awesome-icon icon="images" size="xs"/>
                </li>
              </ul>
              <div class="overlay">
                <div class="info">
                  <img alt="Viche" class="avatar" height="40" src="/api/images/SCR-20221107-v15.png">
                  <div class="title">{{ post.title }}</div>
                  <div class="name">Viche</div>
                </div>
              </div>
              <img alt="blueberry sisters" class="image" :src="post.attachments[0]"
                   style="width:100%; height:100%; object-fit:cover;">
            </a>
          </div>
        </div>
      </div>
    </b-row>
  </b-col>

  <div>
    <vue-easy-lightbox
        :visible="visibleRef"
        :imgs="imgsRef"
        :index="indexRef"
        @hide="onHide"
        :moveDisabled="onMoveDisable"
    ></vue-easy-lightbox>
  </div>
</template>

<style>

</style>