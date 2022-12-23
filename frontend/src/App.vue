<script>
import TheHeader from "@/layout/TheHeader.vue";
import TheContent from "@/layout/TheContent.vue";
import TheFooter from "@/layout/TheFooter.vue";

export default {
  name: 'App',
  components: {TheFooter, TheContent, TheHeader},
  watch: {
    $route: {
      immediate: true,
      handler(to, from) {
        const defaultTitle = 'Viche Gallery'
        document.title = to.meta.title + " - " + defaultTitle || defaultTitle;
      }
    },
  }
};
</script>

<template>
    <TheHeader/>
    <TheContent/>
    <TheFooter/>
</template>

<style>
#app {
  font-family: "나눔고딕", "nanum-gothic", sans-serif;
}

</style>