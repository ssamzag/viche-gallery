<script setup lang="ts">

import {ElMessage} from "element-plus";
import {h} from "vue";

const posts = [
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
  },{id: 4, title: "샬이 그림이다", content: "내용1", url: "/api/images/25ba047.jpg", create: "2022-03-01"},
  {
    id: 5,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/SCR-20221106-1r4.jpeg",
    create: "2022-03-01"
  }
]

const go = (a: string) => {
  ElMessage({
    message: h('p', null, [
      h('span', null, a),
      h('i', {style: 'color: teal'}, a),
    ]),
  })

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
              P O S T
            </h1>
            <p style="color: #0D0D0D;">Work diary, Tips, Study, etc.</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div>

    <b-card-group columns>
      <b-card
          toggleable="md"
          border-variant="white" bg-variant="white" text-variant="dark"
              v-for="post in posts"
              :img-src="post.url"
              img-alt="Image"
              class="small"
              body-border-variant="white"
      >
        <b-row>
          <b-col align-self="center" class="p-0">
            <h6>{{post.id}} {{ post.title }}</h6>
            <b-card-text class="small text-muted">비체•3일 전•조회수 1000</b-card-text>
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

  </div>
  <!--</b-card>-->
  <!--  <b-container fluid class="text-center">-->
  <!--  <el-row :gutter="10" v-infinite-scroll="load">-->
  <!--    <el-col-->
  <!--        v-for="post in posts"-->
  <!--        :key="post.id"-->
  <!--        :span="120"-->
  <!--        :offset=0-->
  <!--    >-->
  <!--      <el-card-->
  <!--          :body-style="{ padding: '0px', width:'100%' }"-->
  <!--          @click="go(post.title)">-->
  <!--        <div class="image-box">-->
  <!--          <el-image-->
  <!--              :src="post.url"-->
  <!--              :key="post.url"-->
  <!--              fit="cover"-->
  <!--              class="image-thumbnail"-->
  <!--              lazy-->
  <!--          />-->
  <!--        </div>-->

  <!--        <div style="padding: 15px">-->
  <!--          <span>{{ post.title }}</span>-->
  <!--          <div class="bottom">-->
  <!--            <time class="time">{{ post.create }}</time>-->
  <!--            &lt;!&ndash;            <el-button text class="button">Operating</el-button>&ndash;&gt;-->
  <!--          </div>-->
  <!--        </div>-->
  <!--      </el-card>-->
  <!--    </el-col>-->
  <!--  </el-row>-->
  <!--  </b-container>-->

</template>

<style>
body {
  margin-top: 30px
}

.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.image-box {

  height: 100px;
  overflow: hidden;
  margin: 0 auto;
}

.image-thumbnail {
  width: 100%;
  height: 100%;
}

</style>