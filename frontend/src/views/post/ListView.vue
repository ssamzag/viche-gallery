<script setup lang="ts">

import {ElMessage} from "element-plus";
import {h} from "vue";

const posts = [
  {id: 1, title: "샬이 그림이다", content: "내용1", url:"http://localhost:8080/images/25ba047.jpg", create: "2022-03-01"},
  {id: 2, title: "비체다", content: "내용1", url:"http://localhost:8080/images/SCR-20221106-1r4.jpeg", create: "2022-03-01"},
  {id: 3, title: "비체 태연이라능!", content: "내용1", url:"http://localhost:8080/images/SCR-20221106-1sj.jpeg", create: "2022-03-01"},
  {id: 3, title: "비체 !", content: "내용1", url:"http://localhost:8080/images/SCR-20221106-1xc.jpeg", create: "2022-03-01"},
]

const go = (a:string) => {
  ElMessage({
    message: h('p', null, [
      h('span', null, a),
      h('i', { style: 'color: teal' }, a),
    ]),
  })
}

</script>

<template>
  <el-row :gutter="10">
    <el-col
        v-for="post in posts"
        :key="post.id"
        :span="100"
        :offset=0
    >
      <el-card :body-style="{ padding: '0px', width:'350px' }" @click="go(post.title)">
        <div class="image-box" >
          <img
              :src="post.url"
              class="image-thumbnail"
          />
        </div>

        <div style="padding: 15px">
          <span>{{ post.title }}</span>
          <div class="bottom">
            <time class="time">{{ post.create }}</time>
<!--            <el-button text class="button">Operating</el-button>-->
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<style>
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
  width:350px;
  height:220px;
  overflow:hidden;
  margin:0 auto;
}

.image-thumbnail {
  width:100%;
  height:100%;
  object-fit:cover;
}
/*.scrollbar-demo-item {*/
/*  display: flex;*/
/*  align-items: center;*/
/*  justify-content: center;*/
/*  height: 50px;*/
/*  margin: 10px;*/
/*  text-align: center;*/
/*  border-radius: 4px;*/
/*  background: var(--el-color-primary-light-9);*/
/*  color: var(--el-color-primary);*/
/*}*/
</style>