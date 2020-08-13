<template>
  <div class="search-bar">
    <el-input @keyup.enter.native="SearchKeyword" placeholder="通过书名或作者搜索"
    prefix-icon="el-icon-search" size="small" v-model="keywords"
    style="width: 400px;margin-right: 10px">
    </el-input>
  <el-button size="small" type="primary" icon="el-icon-search" @click="SearchKeyword">搜索</el-button>
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
    SearchKeyword () {
      this.$emit('onSearch')
    }
  }
}
</script>

<style scoped>
  .search-bar {
    margin-bottom: 30px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
