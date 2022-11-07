<template>

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
      <h1>First slide</h1>
      <p>Some more detailed description or whatever content.</p>
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
      <h1>Third slide</h1>
      <p>Constains a customized background image</p>
    </b-carousel-slide>
    <b-carousel-slide class="image-box">
      <template #img>
        <img class="image-thumbnail"
             src="/api/images/SCR-20221106-1sj.jpeg"
             alt="image slot"
        />
      </template>
      <h1>Third slide</h1>
      <p>Constains a customized background image</p>
    </b-carousel-slide>
  </b-carousel>
</template>

<script>

</script>

<style>
.image-box {
  width: 1000px;
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