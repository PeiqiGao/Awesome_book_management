<template>
    <div>
        <headertop></headertop>
        <p class="test">ID:{{ id }}</p>
        <div>
        <button class="btnback" @click="back()">返回</button>
    </div>
        <!-- <div>
        <router-link to="/mngfunction"><button class="btnback">返回</button></router-link>
        </div> -->
        <section>

    <div class="container">
                <div class="form">
                    <h2>更改信息</h2>
                    <form>
                        <div class="inputBox">
                            论文名称:<input type="text" id="papername" :value="paperchange.papername" placeholder="论文名称">
                        </div> 
                        <div class="inputBox">
                            作者名称:<input type="text" id="author" :value="paperchange.paperauthor" placeholder="作者姓名">
                        </div> 
                        <div class="inputBox">
                            论文期刊:<input type="text" id="papermag" :value="paperchange.papermag" placeholder="论文期刊">
                        </div>
                        <div class="inputBox">
                            论文页数:<input type="text" id="paperpage" :value="paperchange.paperpage" placeholder="论文页数">
                        </div>  
                    </form>
                    <div class="inputBox">
                            <input type="submit" id="submit" value="更改" @click="change()">
                        </div> 

                </div>
            </div>
</section>
    </div>
</template>

<script>
import headertop from './headertop.vue'
import axios from 'axios'
import qs from 'qs'

export default ({
    name:"mngchange",
    components:{headertop},
    data(){
        return{
            id:"",
            paperchange:{
                paperid:"",
                papername:"",
                paperauthor:"",
                papermag:"",
                paperpage:"",
            }
        }
    },
    methods:
    {
        getpara(){
            this.id=this.$route.query.id;
            this.paperchange.paperid=this.$route.query.paperid;
            this.paperchange.papername=this.$route.query.papername;
            this.paperchange.paperauthor=this.$route.query.paperauthor;
            this.paperchange.papermag=this.$route.query.papermag;
            this.paperchange.paperpage=this.$route.query.paperpage;
        },
        back(){
            this.$router.push({path:'/mngpaperchange',
                                    query:{id:this.id}});
        },
        change(){
            this.paperchange.papername=document.getElementById('papername').value;
            this.paperchange.author=document.getElementById('author').value;
            this.paperchange.papermag=document.getElementById('papermag').value;
            this.paperchange.paperpage=document.getElementById('paperpage').value;
            var that=this;
            axios({
                method:"post",
                contentType: 'application/json',
                data:qs.stringify({
                    'papername':that.paperchange.papername,
                    'author':that.paperchange.author,
                    'papermag':that.paperchange.papermag,
                    'paperpage':that.paperchange.paperpage,
                }),
                url:"http://localhost:8080/paperchange",
            }).then(function(response){
                console.log(response)
                that.right=response.data
                if(that.right==1)
                {
                    alert("更改成功！")
                }
                else if(that.right==0)
                {
                    alert("更改失败！")
                }

            })
        
        }
    },
    created(){
        this.getpara();
    },
})
</script>
<style scoped>
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
    height:500px;
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
    color:white
}
 
/* 输入框样式 */
 
.form .inputBox input {
    width: 60%;
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

.test{
    color: white;
}

.btnback{
    width:80px;
    height: 40px;
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
    position: absolute;
    right: 10px;
    
}

/* .addcontext{
    background: white;
    height: 100px;
    margin:60px 60px 0 60px;
    border-radius: 20px;

} */
</style>