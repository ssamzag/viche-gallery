<template>
  <div
      style="color: rgb(235, 235, 235); font-size: 13px; font-family: &quot;Open Sans&quot;, sans-serif; line-height: 25px; letter-spacing: 0.5px; font-weight: normal;">
    <span style="display:none;width:0;height:0;position:fixed;top:-10px;z-index:-10"></span>
    <div class="row ng-scope">
      <div class="column">
        <div class="block">
          <div class="text tt2" contenteditable="false" style="position: relative;">
            <h1 style="color: #0D0D0D; font-size: 12px;  sans-serif; letter-spacing: 3px; text-transform: uppercase; font-weight: normal;">
                C O N T A C T S
            </h1>
            <p style="color: #0D0D0D;">Contacts for VICHE</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <b-container>
    <b-row>

      <b-carousel
          indicators
          style="text-shadow: 0px 0px 2px #000"
          :interval="5000"
          background="white"
          class="carousel-fade">
        <b-carousel-slide
            class="image-box"
            active
            img-src="/api/images/SCR-20221106-1xc.jpeg">
<!--          <h1>First slide</h1>-->
<!--          <p>Some more detailed description or whatever content.</p>-->
        </b-carousel-slide>

        <b-carousel-slide class="image-box">
          <template #img>
            <img class="image-thumbnail"
                 width="1024"
                 height="480"
                 src="/api/images/25ba047.jpg"
                 alt="image slot"
            />
          </template>
<!--          <h1>Third slide</h1>-->
<!--          <p>Constains a customized background image</p>-->
        </b-carousel-slide>
        <b-carousel-slide class="image-box">
          <template #img>
            <img class="image-thumbnail"
                 src="/api/images/SCR-20221106-1sj.jpeg"
                 alt="image slot"
            />
          </template>
<!--          <h1>Third slide</h1>-->
<!--          <p>Constains a customized background image</p>-->
        </b-carousel-slide>
      </b-carousel>
    </b-row>
    <b-row class="justify-content-md-center my-5">
      <b-col>
        <font-awesome-icon icon="fa-brands fa-youtube" size="3x"/>
      </b-col>
      <b-col>
        <font-awesome-icon icon="fa-brands fa-instagram" size="3x"/>
      </b-col>
      <b-col>
        <font-awesome-icon icon="fa-brands fa-twitter" size="3x"/>
      </b-col>
      <b-col><font-awesome-icon icon="fa-solid fa-envelope" size="3x"/></b-col>
      <b-col>
        <font-awesome-icon icon="fa-solid fa-comment" size="3x"/>
      </b-col>
    </b-row>
  </b-container>
    <div class="h2 mb-5">

      <!--    <font-awesome-icon icon="fa-brands fa-square-instagram" size="5x"/>-->



    </div>
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
  height:100%;

  object-fit: cover;
}
</style>