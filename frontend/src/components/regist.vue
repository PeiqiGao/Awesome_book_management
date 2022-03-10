<template>
<div>
    <headertop></headertop>
<!-- <img src="../../static/image/img08.png" width="5%" height="5%" z-index=-1> -->
<section>

    <div class="container">
                <div class="form">
                    <h2>注册</h2>
                    <form>
                        <div class="inputBox">
                            <input type="text" id="username" placeholder="id" value="">
                        </div>
                        <div class="inputBox">
                            <input type="password" id="userpassword" value="" placeholder="密码">
                        </div>
                        <div class="inputBox">
                            <input type="password" id="reuserpassword" value="" placeholder="确认密码">
                        </div>
                        性别:<input type="radio" id=mb @click="checkmale()" value="male" name="gender"><span style="color:white">男</span>
                        <input type="radio" id=fb @click="checkfemale()" value="female" name="gender"><span style="color:white">女</span>
                        <br>

                        类型:<input type="radio" id=stub @click="checkstu()" value="stu" name="type"><span style="color:white">学生</span>
                        <input type="radio" id=mngb @click="checkmng()" value="mng" name="type"><span style="color:white">管理员</span>
                        
                    </form>
                    <div class="inputBox">
                            <input type="submit" value="注册" @click="regist()">
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
    name:"regist",
    components:{headertop},
    data(){
        return{
            userid:{
                id:123,
                password:"",
                repassword:"",
                type:"",
                gender:"",
                stu:false
            },
            right:false,
            test:"",
            check:false,
            sb:100,
        }
    },
    methods:{
        checkstu(){
            this.type="学生",
            this.check = true
        },
        checkmng(){
            this.type="管理员"
            this.check = true
        },
        checkmale(){
            this.gender="男"
        },
        checkfemale(){
            this.gender="女"
        },
        regist(){
            var that = this
            this.userid.id=document.getElementById('username').value
            this.userid.password=document.getElementById('userpassword').value
            var re = document.getElementById('reuserpassword').value
            if(this.userid.id == "")
            {
                alert("请输入id！")
            }
            else if(this.userid.password == "")
            {
                alert("请输入密码！")
            }
            else if(this.check==false)
            {
                alert("请选择身份！")
            }
            else{
            if(re != this.userid.password)
            {
                alert("两次密码输入不正确！")
            }
            else
            {
                if(this.state == "stu")
                    this.userid.stu=true
                else if(this.state == "mng")
                    this.userid.stu=false
                axios({

                method:"post",
                contentType: 'application/json',
                data:qs.stringify({
                    'username':that.userid.id,
                    'password':that.userid.password,  
                    'gender':that.gender,
                    'type':that.type
                }),
                url:"http://localhost:8080/userregist",
            }).then(function(response){
                console.log(response)
                if(response.data == "1")
            {
                alert("注册成功！")
                that.$router.push(
                {
                    path:'/',
                }
            )
            }
            else {
                alert("注册失败！")
            }
            })
                
            }
            }
        }        
    }
})
</script>

<style>
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
    color:white;
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

</style>