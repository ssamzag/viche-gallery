<script setup type="ts">
import {defineComponent, onMounted, ref, inject} from "vue";
import axios from "axios";
import VueEasyLightbox from "vue-easy-lightbox";
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";
import {useRouter} from "vue-router";

const works = ref([])
const imgsRef = ref([])
let index = 0;

const visibleRef = ref(false)
const moveRef = ref(false)
const indexRef = ref(0) // default 0

const onShow = () => visibleRef.value = true
const onHide = () => visibleRef.value = false
const onMoveDisable = () => moveRef.value = false
const router = useRouter()

const showImg = (index) => {
  indexRef.value = index
  onShow()
}

onMounted(() => {
  getList()
})

const getList = () => {
  axios.get(`/api/works`).then(response => {
    works.value = []
    response.data
        .forEach((r) => {
          r.attachments = r.attachments
              .map(fileName => '/api/images/' + fileName)
          r.attachments
              .forEach(src => imgsRef.value
                  .push({title: r.title, src: src}))

          works.value.push(r)
          r.imageStartIndex = index
          index += r.attachments.length
        })
  })
}

const deleteWork = (id) => {
  const result = confirm("삭제 하실라우?")
  if (result) {
    axios.delete(`/api/works/${id}`,
        {
          headers: {
            authorization: "Bearer " + localStorage.getItem("token")
          }
        })
        .then((res) => {
          console.log(res)
          getList()
          //router.go()
        })
        .catch(() => alert("삭제 실패"))

  }
}
const deleteToggle = inject('login')

const deleteButton = () => {
  deleteToggle.value = !deleteToggle.value
}

</script>

<template>
  <b-col>
    <b-row>
      <Title title="WORKS" subTitle="illustration works of VICHE." :write="{url:'/work/write',text:'WRITE'}" :delete="{click: deleteButton, text:'DELETE'}"></Title>
    </b-row>
    <b-row>
      <div class="gallery-container" style="display: block;">
        <div class="gallery">
          <div v-for="work in works" class="project artist-profile" style="position:relative">
            <a @click="showImg(work.imageStartIndex)" class="project-image" target="_self">
              <ul class="icons-list"
                  v-if="deleteToggle" style="z-index: 4">
                  <b-button style="font-size:12px"
                            squared
                      variant="danger"
                      @click.stop="deleteWork(work.workId)">DEL</b-button>
              </ul>
              <ul class="icons-list">
                <li v-if="work.attachments.length > 1">
                  <font-awesome-icon icon="images" size="xs"/>
                </li>
              </ul>
              <div class="overlay">
                <div class="info">
                  <img alt="Viche" class="avatar" height="40" src="/api/images/SCR-20221107-v15.png">
                  <div class="title">{{ work.title }}</div>
                  <div class="name">Viche</div>
                </div>
              </div>
              <img alt="blueberry sisters" class="image" :src="work.attachments[0]"
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