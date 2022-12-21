<script>
export default {
  name: 'TitleComponent',
  props: ['title'],
  watch: {
    title: {
      immediate: true,
      handler() {
        document.title = this.title + " - Viche Gallery";
      }
    }
  },
  render () {
  },
}
</script>
