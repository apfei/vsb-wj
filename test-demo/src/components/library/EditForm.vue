<template>
  <div>
    <i class="el-icon-circle-plus-outline" @click="editFrom = true"></i>
    <el-dialog title="修改/添加" :visible.sync="editFrom" @close="clear">
      <el-form v-model="form" style="text-align: left" ref="dataForm">
        <el-form-item label="书名" :label-width="labelwidth" prop="title">
          <el-input v-model="form.title" auto-complete="off" placeholder=""></el-input>
        </el-form-item>
        <el-form-item label="作者" :label-width="labelwidth" prop="author">
          <el-input v-model="form.author" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版日期" :label-width="labelwidth" prop="date">
          <el-input v-model="form.date" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版社" :label-width="labelwidth" prop="press">
          <el-input v-model="form.press" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="封面" :label-width="labelwidth" prop="cover">
          <el-input v-model="form.cover" auto-complete="off"></el-input>
          <img-uplod @onUpload="uploadImg" ref="imgUpload"></img-uplod>
        </el-form-item>
        <el-form-item label="简介" :label-width="labelwidth" prop="abs">
          <el-input v-model="form.abs" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="分类" :label-width="labelwidth" prop="category">
          <el-select v-model="form.category.id" placeholder="请选择分类">
            <el-option label="文学" value="1"></el-option>
            <el-option label="流行" value="2"></el-option>
            <el-option label="文化" value="3"></el-option>
            <el-option label="生活" value="4"></el-option>
            <el-option label="经济" value="5"></el-option>
            <el-option label="科技" value="6"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="form.id" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="editFrom = false">取消</el-button>
        <el-button type="primary" @click="onSubmit">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import ImgUplod from './ImgUplod'
export default {
  name: 'EditForm',
  components: {ImgUplod},
  data () {
    return {
      editFrom: false,
      form: {
        id: '',
        title: '',
        author: '',
        date: '',
        press: '',
        cover: '',
        abs: '',
        category: {
          id: '',
          name: ''
        }
      },
      labelwidth: '120px'
    }
  },
  methods: {
    clear () {
      this.form = {
        id: '',
        title: '',
        author: '',
        date: '',
        press: '',
        cover: '',
        abs: '',
        category: ''
      }
    },
    onSubmit () {
      this.$axios
        .post('/books', {
          id: this.form.id,
          title: this.form.title,
          author: this.form.author,
          date: this.form.date,
          press: this.form.press,
          cover: this.form.cover,
          abs: this.form.abs,
          category: this.form.category
        }).then(resp => {
          if (resp && resp.status === 200) {
            this.editFrom = false
            this.$emit('onSubmit')
          }
        })
    },
    uploadImg () {
      this.form.cover = this.$refs.imgUpload.url
    }
  }
}
</script>

<style scoped>
  .el-icon-circle-plus-outline {
    margin: 50px 0 0 20px;
    font-size: 100px;
    float: left;
    cursor: pointer;
  }
</style>
