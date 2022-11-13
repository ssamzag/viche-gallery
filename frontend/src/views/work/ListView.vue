<script setup type="ts">
import {defineComponent, onMounted, ref} from "vue";
import axios from "axios";
import VueEasyLightbox from "vue-easy-lightbox";
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";

const posts = ref([])
const imgsRef = ref([])
let index = 0;
onMounted(() => {
  t()
})
const t = () => {
  axios.get(`/api/works`).then(response => {
    response.data
        .forEach((r) => {
          r.attachments = r.attachments
              .map(fileName => '/api/images/' + fileName)
          r.attachments
              .forEach(src => imgsRef.value.push({title: r.title, src: src}))

          posts.value.push(r)
          r.imageStartIndex = index
          index += r.attachments.length
        })
  })
}
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

</script>

<template>
  <div
      style="color: rgb(235, 235, 235); font-size: 13px; font-family: &quot;Open Sans&quot;, sans-serif; line-height: 25px; letter-spacing: 0.5px; font-weight: normal;">
    <span style="display:none;width:0;height:0;position:fixed;top:-10px;z-index:-10"></span>
    <div class="row ng-scope">
      <div class="column">
        <div class="block">
          <div class="text tt2" contenteditable="false" style="position: relative;">
            <h1 style="color: #0D0D0D; font-size: 12px;  sans-serif; letter-spacing: 3px; text-transform: uppercase; font-weight: normal;">
              W O R K S
            </h1>
            <p style="color: #0D0D0D;">illustration works of VICHE.</p>
          </div>
        </div>
      </div>
    </div>

    <div style="display: block;">
      <div class="gallery-container">
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
              <img alt="blueberry sisters" class="image" :src="post.attachments[0]">
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>

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