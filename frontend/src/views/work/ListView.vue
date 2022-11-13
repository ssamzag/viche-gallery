
<script setup type="ts">

const posts = [
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
    id: 5,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/17dbabe.jpeg",
    create: "2022-03-01"
  }, {
    id: 2,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/Fgd08-jaYAE9p4b.jpeg",
    create: "2022-03-01"
  },
  {
    id: 3,
    title: "비체 태연이라능!",
    content: "내용111111",
    url: "/api/images/Fgdm7apakAEtDen.png",
    create: "2022-03-01"
  },
  {
    id: 5,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/FgPiEcxaEAA16ti.jpeg",
    create: "2022-03-01"
  }, {
    id: 2,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/Fg4BG7jVsAAvKlC.jpeg",
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
    id: 5,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/17dbabe.jpeg",
    create: "2022-03-01"
  }, {
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
    id: 5,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/17dbabe.jpeg",
    create: "2022-03-01"
  }, {
    id: 2,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/SCR-20221106-1r4.jpeg",
    create: "2022-03-01"
  }, {
    id: 2,
    title: "비체다",
    content: "내용14124124214214142 asdfasdfads",
    url: "/api/images/SCR-20221106-1r4.jpeg",
    create: "2022-03-01"
  },
]
</script>

<template>
  <description position="top" page="page" site="site" class="ng-isolate-scope"><!-- ngIf: description.showDesc() -->
    <div id="description_container_428560q1qlDAQC" pb-style="description.style"
         class="description top description-container blockContent" ng-if="description.showDesc()"
         bind-unsafe-html="pageOrSection.BlockContent" block-content=""
         style="color: rgb(235, 235, 235); font-size: 13px; font-family: &quot;Open Sans&quot;, sans-serif; line-height: 25px; letter-spacing: 0.5px; font-weight: normal;">
      <span id="VERIFY_428560q1qlDAQC_HASH" class="DO_NOT_REMOVE_OR_COPY_AND_KEEP_IT_TOP ng-scope"
            style="display:none;width:0;height:0;position:fixed;top:-10px;z-index:-10"></span>
      <div class="row ng-scope" id="AVJJDYKWI">
        <div class="column" id="WUZDYOTGR">
          <div class="block" id="XFZHATLXF">
            <div class="text tt2" contenteditable="false" style="position: relative;"><h1
                style="color: #0D0D0D; font-size: 12px; font-family: Lato, sans-serif; letter-spacing: 3px; text-transform: uppercase; font-weight: normal;">
              W O R K S</h1>

              <p style="color: #0D0D0D;">Selection of digital art.</p>
            </div>
            <span class="movehandle"></span><span class="confhandle"></span>
          </div>
        </div>
      </div>

    </div><!-- end ngIf: description.showDesc() --></description>

  <div style="display: block; min-height: 1207px;" with-min-height="154">
    <div class="gallery-container">
      <div class="gallery">
        <div v-for="post in posts" class="project artist-profile">
          <f></f>
          <a class="project-image" target="_self">
            <ul class="icons-list"></ul>
            <div class="overlay">
              <div class="info">
                <img alt="Viche" class="avatar" height="40"
                     src="/api/images/SCR-20221107-v15.png">
                <div class="title" ng-bind-html="project.title">{{ post.title }}</div>
                <div class="name">Viche</div>
              </div>
            </div>
            <img alt="blueberry sisters"
                 class="image"
                 ng-class="{ 'img-blur' : project.hide_as_adult }"
                 :ng-src="post.url"
                 :src="post.url">
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<style>

</style>