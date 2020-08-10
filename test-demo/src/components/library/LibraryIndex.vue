<template>
  <el-container>
    <el-aside style="width: 200px; margin-top: 20px">
      <switch></switch>
      <SideMenu></SideMenu>
    </el-aside>
    <el-main>
      <books class="book-area"></books>
    </el-main>
  </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import Books from './Books'

export default {
  name: 'ALibrary',
  components: {SideMenu, Books}
}
</script>

<style scoped>
  .books-area {
    width: 500px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
