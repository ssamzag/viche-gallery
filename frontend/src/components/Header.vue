<template>
  <el-menu
      default-active="activeIndex"
      class="header"
      mode="horizontal"

      router="true"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      @select="handleSelect"
  >
    <el-menu-item index="/">
      <template #title>
        <el-icon>
          <picture-rounded/>
        </el-icon>
        <span>VICHE</span>
      </template>
    </el-menu-item>
    <div class="flex-grow"/>
    <el-menu-item index="1">WORK</el-menu-item>
    <el-menu-item index="/post">POST</el-menu-item>
    <el-menu-item index="3">SOCIALS</el-menu-item>
    <el-menu-item index="4">다크모드</el-menu-item>
  </el-menu>

</template>

<script lang="ts" setup>

import {ref} from 'vue'
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
  PictureRounded,
  PictureFilled
} from '@element-plus/icons-vue'
const activeIndex = ref('/')
</script>

<style>
.header {
  padding: 0;
}

.flex-grow {
  flex-grow: 1;
}

body {
  margin-top: 0;
  margin-left: 0;
}
</style>
