<template>
  <div>
    <el-input @keyup.enter.native="Search" placeholder="通过书名或作者搜索"
    prefix-icon="el-icon-search" size="small" v-model="keywords"
    style="width: 400px;margin-right: 10px"></el-input>
  <el-button size="small" type="primary" icon="el-icon-search" @click="Search">搜索</el-button>
  </div>
</template>

<script>
export default {
  name: 'SearchBar',
  data () {
    return {
      keywords: '',
      books: [],
      cardLoading: []
    }
  },
  methods: {
    Search () {
      this.$emit('onSearch')
    }
  }
}
</script>

<style scoped>

</style>
