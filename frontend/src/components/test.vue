<template>
<div>
  <input type="file" @change="upload($event)" id="inputfile">
  <div class="testdiv">
  <img :src="'data:image/jpg;base64,' + picurl" id="image" draggable="false" class="testimg" @mousedown="ifcut && clickdown($event)" @mousemove="ifcut && ifclick && clickmove($event)" @mouseup="ifcut && clickup($event)"> 
  <div id="rect" class="rect" v-show="rectshow">
  </div>
  </div>
  <p style="color:white">
    x1:{{ x1 }}<br>
    x2:{{ x2 }}<br>
    y1:{{ y1 }}<br>
    y2:{{ y2 }}<br>
    x0:{{ x0 }}<br>
    y0:{{ y0 }}
  </p>
  <button @click="changecut()">裁剪</button>
  <button @click="testfunction()">测试</button>
</div>
</template>

<script>
import axios from 'axios';

export default ({
  name:"test",
  data(){
    return{
      picurl:"",
      file1:"",
      x1:"",
      x2:"",
      y1:"",
      y2:"",
      x0:"",
      y0:"",
      rectshow:false,
      ifcut:false,
      ifclick:false
    }
  },
  methods:{
    upload(event){
      this.file1=event.target.files[0];
      this.getfile();
    },
    getfile(){
      var that=this;
      let FormData1=new FormData();
      FormData1.append('file',this.file1);
      axios({
        method: "post",
        data:FormData1,
        url: "http://127.0.0.1:5000/getPic1",
        // responseType: "arraybuffer", 
      }).then(function (response) {
        that.picurl=response.data;
      });

    },
    testfunction(){
      var that=this;
      var testdata = new FormData();
      axios({
        method:"POST",
        data:testdata,
        url: "http://127.0.0.1:5000/cutpic1",
      }).then(function(response){
        that.picurl=response.data;
      })
    },

    clickdown(e){
      window.event.cancelBubble = true;
          window.event.returnValue = false;
      this.x1=e.offsetX;
      this.y1=e.offsetY;
      this.ifclick=true;
      this.rectshow=true;
      document.getElementById('rect').style.left=this.x1+"px";
      document.getElementById('rect').style.top=this.y1+18+"px";
    },

    clickmove(e)
    {
      this.x0=e.offsetX;
      this.y0=e.offsetY;
      document.getElementById('rect').style.width=this.x0-this.x1+"px";
      document.getElementById('rect').style.height=this.y0-this.y1+"px";
    },
    
    clickup(e){
      this.x2=e.offsetX;
      this.y2=e.offsetY;
      this.ifclick=false;
      this.makesure();
      this.rectshow=false;

    },
    
    makesure(){
      var r = confirm("确定截图吗？")
      if(r == true)
      {
        this.testfunction();
      }
      else
      {
        this.x1="";
        this.x2="";
        this.y1="";
        this.y2="";
        this.x0="";
        this.y0="";
      }
    },
    changecut(){
      if(this.ifcut==true)
      this.ifcut=false;
      else 
      {
        this.ifcut=true;
      }
    }
  }
})
</script>

<style scoped>
</style>
