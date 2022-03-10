<template>
<div>
    <headertop></headertop>
<!-- <img src="../../static/image/img08.png" width="5%" height="5%" z-index=-1> -->
<section>

    <div class="container">
                <div class="form">
                    <h2>登录</h2>
                    <form>
                        <div class="inputBox">
                            <input type="text" id="username" placeholder="学生ID或者管理员ID" value="">
                        </div>
                        <div class="inputBox">
                            <input type="password" id="userpassword" value="" placeholder="密码">
                        </div>
                        


                        <p class="forget">没有账户?
                                <router-link to="/regist">注册</router-link>
                            </p>
                    </form>
                    <div class="inputBox">
                            <input type="submit" value="学生登录" @click="stusubmit()">
                            <input type="submit" class="rightup" value="管理员登录" @click="mngsubmit()">
                        </div>
                </div>
            </div>
</section>
</div>
</template>

<script>
import headertop from './headertop.vue'
import axios from 'axios';
import qs from 'qs';

export default ({
    name:"login",
    components:{headertop},
    data(){
        return{
            userid:{
                id:"",
                password:"",
                type:""
            },
            right:"",
            test:"",
        }
    },
    methods:{
    
        stusubmit(){
            var that = this;
            this.userid.id = document.getElementById('username').value
            this.userid.password = document.getElementById('userpassword').value
            this.userid.type = "学生"
            axios({

                method:"post",
                contentType: 'application/json',
                data:qs.stringify({
                    'username':that.userid.id,
                    'password':that.userid.password,
                    'type':that.userid.type,
                }),
                url:"http://localhost:8080/login",
            }).then(function(response){
                that.right = response.data;
                if(that.right == 200)
            {
                that.$router.push({path:'/stufunction',
                                    query:{id:that.userid.id}});
            }
            else{
                alert("账号或者密码错误")
            }
            })
            
        },
        mngsubmit(){
            var that = this;
            this.userid.id = document.getElementById('username').value
            this.userid.password = document.getElementById('userpassword').value
            this.userid.type="管理员"
            axios({
                method:"post",
                contentType: 'application/json',
                data:qs.stringify({
                    'username':that.userid.id,
                    'password':that.userid.password, 
                    'type':that.userid.type,
                }),
                url:"http://localhost:8080/login",
            }).then(function(response){
                if(response.data == 200)
            {
                that.$router.push({path:'/mngchoose',
                                    query:{id:that.userid.id}
                                    });
            }
            else{
                alert("账号或者密码错误")
            }
            })
        },
        
    }
})
</script>

<style>
.test{
    color: white;
}

section {
    /* 相对定位 */

    margin-top: 10%;
    position: relative;
    overflow: hidden;
    display: flex;
    justify-content: center;
 /* -webkit-transform: translate(-50%, -50%); */
            /* -moz-transform: translate(-50%, -50%); */
            /* -ms-transform: translate(-50%, -50%); */
            /* -o-transform: translate(-50%, -50%); */
            /* transform: translate(-50%, -50%); */
    /* align-items: center; */
    /* min-height: 100vh; */
    /* linear-gradient() 函数用于创建一个表示两种或多种颜色线性渐变的图片 */
    /* background: linear-gradient(to bottom, #f1f4f9, #dff1ff); */

}
.container {
    position: relative;
    width: 400px;
    height:400px;
    /* min-height: 400px; */
    background: rgba(255, 255, 255, 0.1);
    display: flex;
    justify-content: center;
    align-items: center;
    backdrop-filter: blur(5px);
    box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
    border: 2px solid aqua;
    border-radius: 8px;
    /* border-right: 1px solid rgba(255, 255, 255, 0.2); */
    /* border-bottom: 1px solid rgba(255, 255, 255, 0.2); */
}


.form {
    position: relative;
    width: 100%;
    height: 100%;
    padding: 50px;
}
 
/* 登录标题样式 */
 
.form h2 {
    position: relative;
    color: #fff;
    font-size: 24px;
    font-weight: 600;
    letter-spacing: 5px;
    margin-bottom: 30px;
    cursor: pointer;
}
 
/* 登录标题的下划线样式 */
 
.form h2::before {
    content: "";
    position: absolute;
    left: 0;
    bottom: -10px;
    width: 0px;
    height: 3px;
    background: #fff;
    transition: 0.5s;
}
 
.form h2:hover:before {
    width: 53px;
}
 
.form .inputBox {
    width: 100%;
    margin-top: 20px;
}
 
/* 输入框样式 */
 
.form .inputBox input {
    width: 100%;
    padding: 10px;
    background: rgba(255, 255, 255, 0.2);
    outline: none;
    border: none;
    border-radius: 30px;
    border: 1px solid rgba(255, 255, 255, 0.5);
    border-right: 1px solid rgba(255, 255, 255, 0.2);
    border-bottom: 1px solid rgba(255, 255, 255, 0.2);
    font-size: 16px;
    letter-spacing: 1px;
    color: #fff;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
}
 
.form .inputBox input::placeholder {
    color: #fff;
}
 
/* 登录按钮样式 */
 
.form .inputBox input[type="submit"] {
    background: #fff;
    color: #666;
    max-width: 100px;
    margin-bottom: 20px;
    font-weight: 600;
    cursor: pointer;
}
 
.forget {
    margin-top: 6px;
    color: #fff;
    letter-spacing: 1px;
}
 
.forget a {
    color: #fff;
    font-weight: 600;
    text-decoration: none;
}

   .buttonstyle {
      width:80px;
      height: 30px;
      text-align:center;
      line-height:100%;
      padding:0.3em;
      font:16px Arial,sans-serif bold;
      font-style:normal;
      text-decoration:none;
      margin:2px;
      vertical-align:text-bottom;
      zoom:1;
      outline:none;
      font-size-adjust:none;
      font-stretch:normal;
      border-radius:50px;
      box-shadow:0px 1px 2px rgba(0,0,0,0.2);
      text-shadow:0px 1px 1px rgba(0,0,0,0.3);
      color:black;
      border:0.2px solid grey;
      background-repeat:repeat;
      background-size:auto;
      background-origin:padding-box;
      background-clip:padding-box;
      background-color:grey;
      background: linear-gradient(to bottom, #eeeff9 0%,gray 100%);
      font-size: large;
}
.buttonstyle:hover {
    background: white;
}

.rightup{
    margin-left:40px;
}

</style>