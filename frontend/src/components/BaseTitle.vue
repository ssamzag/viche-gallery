<template>
  <div class="title">
    <span class="title-span"></span>
    <div class="row ng-scope">
      <div class="column">
        <div class="block">
          <div class="text tt2 color-dark" contenteditable="false" style="position: relative; float:left">
            <h1 class="title-h1" style="letter-spacing: 5px;">
              {{ props.title }}
            </h1>
            <p class="title-p color-dark">{{ props.subTitle }}</p>
          </div>
          <div style="float:right" v-if="loginStatus">
            <div class="post-meta">
              <b-button class="title-h1"
                        v-if="write"
                        :to="write.url"
                        variant
                        style="float:right; font-size: 10px;">
                {{ props.write.text }}
              </b-button>
              <b-button class="title-h1"
                        v-if="props.delete"
                        @click="props.delete.click"
                        variant
                        style="float:right; font-size:10px; color:#d4bca7">
                {{ props.delete.text }}
              </b-button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup type="ts">
import {useUserStore} from "@/stores/user";
import {storeToRefs} from "pinia";

const {loginStatus} = storeToRefs(useUserStore())

const props = defineProps({
  title: {
    type: String,
    require: true
  },
  subTitle: {
    type: String,
    require: true
  },
  write: {
    type: Object,
    required: false
  },
  delete: {
    click: Object,
    required: false
  }
})

</script>

<style>
.color-dark {
  color: #0D0D0D
}

.title-span {
  display: none;
  width: 0;
  height: 0;
  position: fixed;
  top: -10px;
  z-index: -10
}

.title-h1 {
  color: #0D0D0D;
  font-size: 12px;
  letter-spacing: 3px;
  text-transform: uppercase;
  font-weight: normal;
}

.title-p {
  color: #0D0D0D;
  font-size: 13px;
  font-weight: normal;
  margin-top: 0px;
}

.title {
  margin-top: 0px;
  color: rgb(235, 235, 235);
  font-size: 13px;
  font-family: "Open Sans", sans-serif;
  line-height: 25px;
  letter-spacing: 0.5px;
  font-weight: normal;
}


</style>