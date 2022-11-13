<template>
  <div
      style="color: rgb(235, 235, 235); font-size: 13px; font-family: &quot;Open Sans&quot;, sans-serif; line-height: 25px; letter-spacing: 0.5px; font-weight: normal;">
    <span style="display:none;width:0;height:0;position:fixed;top:-10px;z-index:-10"></span>
    <div class="row ng-scope">
      <div class="column">
        <div class="block">
          <div class="text tt2" contenteditable="false" style="position: relative;">
            <h1 style="color: #0D0D0D; font-size: 12px;  sans-serif; letter-spacing: 3px; text-transform: uppercase; font-weight: normal;">
              I N T R O D U C E
            </h1>
            <p style="color: #0D0D0D;">About illustrator VICHE</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <b-container class="text-center" style="color:#495057">
    <b-row class="my-3" align-h="center">
      <b-col cols="">
        <a class="navbar-brand" href="https://www.youtube.com/channel/UCmF76cRFXJ2l_re7bt5S8qg" target="_blank">
          <font-awesome-icon icon="fa-brands fa-youtube" size="2x"/>
        </a>
      </b-col>
      <b-col cols="">
        <a class="navbar-brand" href="https://twitter.com/VICHE_00" target="_blank">
          <font-awesome-icon icon="fa-brands fa-twitter" size="2x"/>
        </a>
      </b-col>
      <b-col cols="">
        <a class="navbar-brand" href="https://www.instagram.com/viche_22/" target="_blank">
          <font-awesome-icon icon="fa-brands fa-instagram" size="2x"/>
        </a>
      </b-col>
      <b-col cols="">
        <a class="navbar-brand" href="mailto:rhkfdkr@naver.com" target="_blank">
          <font-awesome-icon icon="fa-solid fa-envelope" size="2x"/>
        </a>
      </b-col>
      <b-col cols="">
        <a class="navbar-brand" href="" target="_blank">
          <font-awesome-icon icon="fa-solid fa-comment" size="2x"/>
        </a>
      </b-col>
    </b-row>
    <b-row>
      <b-carousel
          style="text-shadow: 1px 1px 2px #333;"
          :interval="5000"
          background="white"

          no-touch="false"
          class="carousel-fade">
        <b-carousel-slide
            class="image-box"
            active
            img-src="/api/images/685a257.jpeg">
<!--          <h1>안녕하세요!</h1>-->
<!--          <p>Some more detailed description or whatever content.</p>-->
        </b-carousel-slide>
        <b-carousel-slide
            class="image-box"
            active
            img-src="/api/images/SCR-20221106-1sj.jpeg">
<!--          <h1>안녕하세요!</h1>-->
<!--          <p>Some more detailed description or whatever content.</p>-->
        </b-carousel-slide>

<!--        <b-carousel-slide class="image-thumbnail">-->
<!--          <template #img>-->
<!--            <img class="image-thumbnail"-->
<!--                 src="/api/images/SCR-20221106-1sj.jpeg"-->
<!--                 alt="image slot"-->
<!--            />-->
<!--          </template>-->
<!--                    <h1>Third slide</h1>-->
<!--                    <p>Constains a customized background image</p>-->
<!--        </b-carousel-slide>-->
      </b-carousel>
    </b-row>

  </b-container>
</template>

<script>

</script>

<style>
.image-box {
  height: 500px;
  overflow: hidden;
  margin: 0 auto;
}

.image-thumbnail {
  width: 100%;
  height: 100%;

  object-fit: cover;
}
</style>