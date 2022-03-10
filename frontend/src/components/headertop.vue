<template>
    <div class="title">
        <router-link to="/function"><div class="s1"> 
    <img src="../../static/image/img08.png" class="picture" >
        </div></router-link>
        <div class="s2">
    <img src="../../static/image/img07.png" class="picture" >
    <img src="../../static/image/img07_r.png" class="picture">
    <div class="ptitle">图书管理系统</div>
    </div>
    <router-link to="/"><div class="exit"><button class="buttonstyle">退出</button></div></router-link>
    
    </div>
</template>

<script>

export default ({
    name:"headertop",
    
})
</script>

<style>
.user{
    float: left;
}

.title{
    color:aqua;
    font-size: 40px;
    display: inline-block;
    height: 100px;
    width: 100%;
    margin: 0%;
    position: relative;
}
.s1{
    display: inline-block;
    height: 100%;
}
.s2{
    display: inline-block;
    height: 100%;
    text-align: center;
    line-height: center;
    position:relative;
    /* position:absolute; */
}

.picture{
    height: 100%;
}
.ptitle{
    top:0%;
    display: -moz-box;/*兼容Firefox*/
      display: -webkit-box;/*兼容FSafari、Chrome*/

      -moz-box-align: center;/*兼容Firefox*/
      -webkit-box-align: center;/*兼容FSafari、Chrome */

      -moz-box-pack: center;/*兼容Firefox*/
      -webkit-box-pack: center;/*兼容FSafari、Chrome */
    width:100%;
    height:100%;
    
    position: absolute;
}
    .exit{
        position: absolute;
        right: 10px;
        top:0px;
    }


       .buttonstyle {
      width:100px;
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
}
.buttonstyle:hover {
    background: white;
}
</style>