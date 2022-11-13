<script type="ts">

const posts = [
  {
    id: 1, title: "샬이 그림이다", content: "내용1", url: "/api/images/25ba047.jpg", create: "2022-03-01"
  },
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
  },
  {
    id: 4, title: "샬이 그림이다", content: "내용1", url: "/api/images/25ba047.jpg", create: "2022-03-01"
  },
  {
    id: 5,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/SCR-20221106-1r4.jpeg",
    create: "2022-03-01"
  }
]

import VueEasyLightbox from 'vue-easy-lightbox'
import { ref, defineComponent } from 'vue'

const imgs = ['/api/images/SCR-20221106-1r4.jpeg', '/api/images/SCR-20221106-1sj.jpeg', '/api/images/SCR-20221106-1xc.jpeg',
  { title: 'test img', src: '/api/images/SCR-20221106-1r4.jpeg' }]

export default defineComponent({
  components: {
    VueEasyLightbox
  },
  setup() {
    const visibleRef = ref(false)
    const indexRef = ref(0) // default 0
    const imgsRef = imgs
    // Img Url , string or Array of string
    // ImgObj { src: '', title: '', alt: '' }
    // 'src' is required
    // allow mixing

    const onShow = () => visibleRef.value = true
    const onHide = () => visibleRef.value = false


    const showSingle = (img) => {
      imgsRef.value = img
      imgsRef.title = "hihi"
      // or
      // imgsRef.value  = {
      //   title: 'this is a placeholder',
      //   src: 'http://via.placeholder.com/350x150'
      // }
      onShow()
    }
    const showMultiple = (images) => {
      if (images) {
        imgsRef.value = images
      } else {
        imgsRef.value = imgs
      }

      // or
      // imgsRef.value = [
      //   { title: 'test img', src: 'http://via.placeholder.com/350x150' },
      //   'http://via.placeholder.com/350x150'
      // ]
      indexRef.value = 0 // index of imgList
      onShow()
    }
    const showImg = (index) => {
      indexRef.value = index
      onShow()
    }
    const onPrev = (oldIndex, newIndex) =>
      alert(oldIndex + "  " + newIndex);

    return {
      visibleRef,
      indexRef,
      imgsRef,
      showSingle,
      showMultiple,
      showImg,
      onHide,
      onPrev: onPrev
    }
  }
})


const a = ref([])

</script>

<template>
  <div>
    <button @click="showSingle">Show single picture.</button>
    <button @click="showMultiple">Show a group of pictures.</button>

    <vue-easy-lightbox
        :visible="visibleRef"
        :imgs="imgsRef"
        :index="indexRef"
        @hide="onHide"
        @on-prev="onPrev"
        moveDisabled="true"
    ></vue-easy-lightbox>
  </div>

  <b-row square cols="1" cols-sm="1" cols-md="1" cols-lg="1" cols-xl="3" class="my-">
    <b-col class="box">
      <b-img @click="showSingle('/api/images/SCR-20221106-1xc.jpeg')" md="4"
             class="my-4 content" rounded fluid-grow src="/api/images/SCR-20221106-1xc.jpeg" alt="Image 1"></b-img>
    </b-col>

    <b-col class="box" square>
      <b-img @click="showMultiple(['/api/images/SCR-20221106-1r4.jpeg', '/api/images/SCR-20221106-1sj.jpeg', '/api/images/SCR-20221106-1xc.jpeg'])"
          class="my-4 content"  square  fluid-grow src="/api/images/SCR-20221106-1r4.jpeg" alt="Image 1"></b-img>
    </b-col>
    <b-col square>
      <b-img @click="showImg(1)" class="my-4 content" square rounded fluid-grow src="/api/images/SCR-20221106-1sj.jpeg" alt="Image 1"></b-img>
    </b-col>
    <b-col>
      <b-img class="my-4" rounded fluid-grow src="/api/images/SCR-20221106-1xc.jpeg" alt="Image 1"></b-img>
    </b-col>
    <b-col>
      <b-img class="my-4" rounded fluid-grow src="/api/images/SCR-20221106-1sj.jpeg" alt="Image 1"></b-img>
    </b-col>
    <b-col>
      <b-img class="my-4" rounded fluid-grow src="/api/images/SCR-20221106-1sj.jpeg" alt="Image 1"></b-img>
    </b-col>
    <b-col>
      <b-img class="my-4" rounded fluid-grow src="/api/images/SCR-20221106-1xc.jpeg" alt="Image 1"></b-img>
    </b-col>
  </b-row>

  <div class="row">
    <div class="col-xs-4 square" style="background-color: lightgray"></div>
    <div class="col-xs-4 square" style="background-color: lightgreen"></div>
    <div class="col-xs-4 square" style="background-color: lightgreen"></div>
    <div class="col-xs-4 square" style="background-color: lightgray"></div>
    <div class="col-xs-4 square" style="background-color: lightgreen"></div>
  </div>
</template>

<style lang="scss">

.el-row {
  margin-bottom: 20px;
}

.el-row:last-child {
  margin-bottom: 0;
}

.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}


.square:before{
  content: "";
  display: block;
  padding-top: 100%;  /* initial ratio of 1:1*/
}
</style>