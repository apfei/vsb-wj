<template>
  <body id="login-page">
    <el-form class="login-container" label-position="right" label-width="70px">
      <h3 class="login_title">系统登录</h3>
      <el-form-item label="用户名:">
        <el-input type="text" v-model="User.name" auto-complete="off" placeholder="请输入用户名">
      </el-input>
      </el-form-item>
      <el-form-item label="密码:">
        <el-input type="password" v-model="User.password" auto-complete="off" placeholder="请输入密码">
        </el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="login">登录
        </el-button>
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      User: {
        name: '',
        password: ''
      },
      responseResult: []
    }
  },

  methods: {
    login () {
      this.$axios
        .post('/login', {
          name: this.User.name,
          password: this.User.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/index'})
          }
        })
        .catch(failResponse => {
        })
    }
  }
}
</script>
<style>
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  #login-page {
    background:url("../assets/img-login.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }
</style>
