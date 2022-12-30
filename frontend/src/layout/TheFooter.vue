<template>
  <footer id="footer" class="mx-4">
    <p class="copyright">
      COPYRIGHT {{new Date().getFullYear()}}. VICHE ALL RIGHTS RESERVED.
    </p>
    <p class="copyright">
      WEB DEV & DESIGNED BY <a href="mailto:alsgh0345@gmail.com">MINHO</a>
    </p>
  </footer>
</template>

<script setup>
</script>

<style>
#footer {
  /*border-top: 1px solid #e6e6e6;*/
  padding: 18px 0 18px 0;
  background-color: #FFFFFF;
  display:block;
}

#footer .copyright {
  font-size: 0.75em;
  color: #999;
  margin-bottom: 3px
}

#footer a {
  text-decoration: none;
  color: #7a583a;
}
</style>
