<script setup type="ts" xmlns:background_image="http://www.w3.org/1999/xhtml">
import {defineComponent, onMounted, ref, inject, computed} from "vue";
import axios from "axios";
import VueEasyLightbox from "vue-easy-lightbox";
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";
import {useRouter} from "vue-router";
import api from "@/api";
import {mapGetters, useStore} from "vuex";

const works = ref([])
const imgsRef = ref([])
let index = 0;

const visibleRef = ref(false)
const moveRef = ref(false)
const indexRef = ref(0) // default 0

const onShow = () => visibleRef.value = true
const onHide = () => visibleRef.value = false
const router = useRouter()

const showImg = (index) => {
  indexRef.value = index
  onShow()
}
const props = defineProps({
  workType: String,
  pageTitle: String,
  pageDesc: String
})

onMounted(() => {
  getList()
})

const store = useStore();
computed(() => store.state.login)

const buttonsSelected = ref("PORTFOLIO")
const buttonsOptions = [
  {text: 'PORTFOLIO', value: 'PORTFOLIO'},
  {text: 'STUDY', value: 'WORK'}
]

const getList = async () => {
  const response = await getWorks()
  response.data
      .forEach(r => {
        r.attachments.forEach(src => imgsRef.value.push({title: r.title, src: "/api/images/" + src}))
        r.imageStartIndex = index
        index += r.attachments.length
      })
  works.value = response.data
}

const getWorks = async () => {
  try {
    return await api.get(`/api/works?workType=${buttonsSelected.value}`)
  } catch (e) {
    alert(e)
  }
}

const deleteWork = (id) => {
  const result = confirm("삭제 하실라우?")
  if (result) {
    api.delete(`/api/works/${id}`)
        .then((res) => {
          getList()
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
      <Title :title="props.pageTitle" :subTitle="pageDesc" :write="{url:'/work/write',text:'WRITE'}"
             :delete="{click: deleteButton, text:'DELETE'}"></Title>
    </b-row>
    <b-row>
      <b-form-radio-group
          class="sub-radio"
          v-model="buttonsSelected"
          :options="buttonsOptions"
          button-variant="outline-gray"
          size="sm"
          name="radios-btn-outline"
          buttons
          @change="getList"
      ></b-form-radio-group>
    </b-row>
    <b-row>
      <b-col>
        <div class="mb-3 mt-" style="border-top: 1px solid #e6e6e6;position: relative;"></div>
      </b-col>
    </b-row>
    <b-row>
      <div class="gallery-container" style="display: block;">
        <div class="gallery">
          <div v-for="work in works" class="project artist-profile"
               :style="{position:'relative', backgroundImage:'url(/api/images/thumbnail/' + `${work.attachments[0]}` + ')'}">
            <a @click="showImg(work.imageStartIndex)" class="project-image" target="_self">
              <ul class="icons-list"
                  v-if="deleteToggle" style="z-index: 4">
                <b-button style="font-size:12px"
                          squared
                          variant="danger"
                          @click.stop="deleteWork(work.workId)">
                  DEL
                </b-button>
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
              <!--              <img alt="blueberry sisters" class="image" :src="'/api/images/thumbnail/' + work.attachments[0]"-->
              <!--                   style="width:100%; height:100%; object-fit:cover;">-->
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
    ></vue-easy-lightbox>
  </div>
</template>

<style>
.btn-check:checked + .btn, :not(.btn-check) + .btn:active, .btn:first-child:active, .btn.active, .btn.show {
  font-weight: bold;
  border-color:#ffffff !important;
  padding-left: 0px;
  font-size: 12px;
}
.btn-sm {
  padding: 0.25rem 10px 0 0 !important;
  font-size: 12px !important;
  color: #7a583a !important;
  letter-spacing: 1px
}

.form-check-inline {
  margin-right: 0 !important;
}
.form-control-sm {
  padding: 0 !important;
}
</style>