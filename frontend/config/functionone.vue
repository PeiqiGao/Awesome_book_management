<template>
<div>
    <headertop></headertop>
    <div >
        <!-- 左侧功能区域 -->
        <div class="leftdiv">
            <div class="leftpicdiv">
                <button class="r1" @click="showinput()">功能</button>
            </div>
            <div class="leftpicdiv">
                <button class="r1" @click="showinfo()">信息</button>
            </div>
            <div class="leftpicdiv">
                <button class="r1" @click="showposition()">量测</button>
            </div>
        </div>
        <!-- 右侧图片区域 -->
        <div class="rightdiv1">
            <div v-show="picshow"> 
              <div v-bind:class="numpic" id="rightpicture">
                <div id="picture1" class="outdiv" >
                <img :src="'data:image/jpg;base64,' + picurl1" v-show="pic1show" @click="marktest && addmarker($event)">
                </div>
                <div id="picture2" class="outdiv">
                <img :src="'data:image/jpg;base64,' + picurl2" v-show="pic2show" @load="getheight()">
                </div>

              </div>

              <!-- <div class="container1" v-show="showleafX">
                  <div class="container2">
                    <div class="out">
                        <img :src="picurl1" height="600px" width="600px">
                    </div>
                    <img :src="picurl2" height="600px" width="600px">
                  </div>
              </div> -->
              <div class="container1" v-show="showleafX" @mousemove="whetherclickX && RollImageX($event)">
                <div id="afterX">
                  <img :src="'data:image/jpg;base64,' + picurl1">
                </div>
                <div id="scrollX" @mousedown="clickdownX($event)" @mouseup="clickupX($event)">
                </div>
                <div id="beforeX">
                  <img :src="'data:image/jpg;base64,' + picurl2">
                </div>
              </div>

              <div class="container1" v-show="showleafY" @mousemove="whetherclickY && RollImageY($event)">
                <div id="afterY">
                  <img :src="'data:image/jpg;base64,' + picurl1">
                </div>
                <div id="scrollY" @mousedown="clickdownY($event)" @mouseup="clickupY($event)">
                </div>
                <div id="beforeY">
                  <img :src="'data:image/jpg;base64,' + picurl2">
                </div>
              </div>

            
            </div>
        </div>
        <!-- input功能 -->
        <div class="rightdiv">
            <div class="rightdiv-input" v-show="inputshow">
                <span><p style="color:white">输入图像1:</p><input type="file" @change="upload1($event)" id="inputfile1"></span>
            <br>
            <span><p style="color:white">输入图像2:</p><input type="file" @change="upload2($event)" id="inputfile2"></span>
            <br>
            <span><p style="color:white">图像结果下载地址:</p><input type="text" id="texturl" name="texturl" style="color:black"></span>
            <br>
            <span>
            <button class="buttonstyle" @click="display()">显示</button>
            <button class="buttonstyle" @click="hide()">隐藏</button>
            <button class="buttonstyle" @click="reset()">重置</button>
            <button class="buttonstyle" @click="leafX()">X卷帘</button>
            <button class="buttonstyle" @click="leafY()">Y卷帘</button>
            </span>
            </div>
        </div>
        <!-- information -->
        <div class="rightdiv">
            <div class="rightdiv-info" v-show="infoshow">
                <p style="font-size:30px ; color:white ; text-align:center">图像信息</p> <hr>
                <div class="message">
              <div class="left">
              图像一：
              <div>
                大小：{{ TifSize1 }}<br>
                左上角点信息：
                <div class="upleft">
                  地理坐标：({{ tif1x }},{{ tif1y }})
                </div>
              </div>
              
              </div>
              <div class="right">
                图像二：
                <div>
                  大小：{{ TifSize2 }}<br>
                  左上角点信息：
                <div class="upleft">
                  地理坐标：({{ tif2x }},{{ tif2y }})
                </div>
                </div>
              </div>
            </div>
            </div>
        </div>
        <!-- position -->
        <div class="rightdiv">
            <div class="rightdiv-position" v-show="positionshow">
              <button class="buttonstyle" @click="whethermark()">{{ markbutton }}</button>
              <button class="buttonstyle" @click="resetmarker()">重标</button>
              <button class="buttonstyle" @click="getgrith()">周长</button>
              <button class="buttonstyle" @click="ComputeArea()">面积</button>
              <button class="buttonstyle" @click="test()">测试</button>
              
                <p style="font-size:20px ; color:white ;" v-show="mark[0]">标记1:<br>
                像素坐标：({{ positionx[0] }},{{ positiony[0] }})<br>
                经纬坐标：({{ geo_positionx[0] }},{{ geo_positiony[0] }})<br>
                <!-- 经纬坐标：({{ lonlat_positionx[0] }},{{ lonlat_positiony[0] }}) -->
                </p>
                <p style="font-size:20px ; color:white ;" v-show="mark[1]">标记2:<br>
                像素坐标：({{ positionx[1] }},{{ positiony[1] }})<br>
                经纬坐标：({{ geo_positionx[1] }},{{ geo_positiony[1] }})<br>
                <!-- 经纬坐标：({{ lonlat_positionx[1] }},{{ lonlat_positiony[1] }}) -->
                </p>
                <p style="font-size:20px ; color:white ;" v-show="mark[2]">标记3:<br>
                像素坐标：({{ positionx[2] }},{{ positiony[2] }})<br>
                经纬坐标：({{ geo_positionx[2] }},{{ geo_positiony[2] }})<br>
                <!-- 经纬坐标：({{ lonlat_positionx[2] }},{{ lonlat_positiony[2] }}) -->
                </p>
                <p style="font-size:20px ; color:white ;" v-show="mark[3]">标记4:<br>
                像素坐标：({{ positionx[3] }},{{ positiony[3] }})<br>
                经纬坐标：({{ geo_positionx[3] }},{{ geo_positiony[3] }})<br>
                <!-- 坐标：({{ lonlat_positionx[3] }},{{ lonlat_positiony[3] }}) -->
                </p>
                <p style="font-size:20px ; color:white ;" v-show="showgrith">
                  周长：{{ grith }}
                </p>
                <p style="font-size:20px ; color:white ;" v-show="showarea">
                  面积：{{ area }}
                </p>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import axios from 'axios';
import headertop from './headertop.vue';
import PicZoom from 'vue-piczoom';
import LeaderLine from 'leader-line';

export default ({
    name:"functionone",
    components:{headertop,PicZoom},
    data(){
        return{
            positionshow:false,
            inputshow:false,
            infoshow:false,
            picurl1:"",
            picurl2:"",
            file1:"",
            file2:"",
            TifSize1:"",
            TifSize2:"",
            picshow:true,
            tif1x:"",
            tif1y:"",
            tif2x:"",
            tif2y:"",
            positionx:["","","",""],
            geo_positionx:["","","",""],
            lonlat_positionx:["","","",""],
            positiony:["","","",""],
            geo_positiony:["","","",""],
            lonlat_positiony:["","","",""],
            NumOfPic:0,
            pic1_GT:["","","","","",""],
            pic2_GT:["","","","","",""],
            showleafX:false,
            showleafY:false,
            pic1show:false,
            pic2show:false,
            NumOfMarker:0,
            mark:[false,false,false,false],
            marktest:false,
            grith:0,
            area:0,
            showgrith:false,
            showarea:false,
            markbutton:"标记",
            lineContainer1: null,
            lineContainer2: null,
            lineContainer3: null,
            lineContainer4: null,
            markname:"",
            whetherclickX:false,
            whetherclickY:false,
            picheight:"",
            path:[["",""],["",""],["",""],["",""]],
        }
    },

    destroyed(){
      this.lineContainer1.remove();
      this.lineContainer2.remove();
      this.lineContainer3.remove();
      this.lineContainer4.remove();
    },

    computed:{

      numpic(){
        if(this.NumOfPic==1)
        return 'numpic1';
        else if(this.NumOfPic==2)
        return 'numpic2';
        else return '';
      },
      
    },


    methods:{
      ComputeArea(){
  if(this.NumOfMarker==4)
  {this.path[0][1]=this.geo_positiony[0];
  this.path[0][0]=this.geo_positionx[0];
  this.path[1][1]=this.geo_positiony[1];
  this.path[1][0]=this.geo_positionx[1];
  this.path[2][1]=this.geo_positiony[2];
  this.path[2][0]=this.geo_positionx[2];
  this.path[3][1]=this.geo_positiony[3];
  this.path[3][0]=this.geo_positiony[3];
  this.area=this.computeSignedArea(this.path);
  this.showarea=true;
  }
  else{alert("请标记四个点！")};

},


      computeSignedArea(path) {
    let radius= 6371009
    let len = path.length;
    if (len < 3) return 0; 
    let total = 0;
    let  prev = path[len - 1];
    let prevTanLat = Math.tan(((Math.PI / 2 - prev[0]/180*Math.PI) / 2));
    let prevLng = (prev[1])/180*Math.PI;
    for (let i in path) {
        let tanLat = Math.tan((Math.PI / 2 -
            (path[i][1])/180*Math.PI) / 2);
        let lng = (path[i][1])/180*Math.PI;
        total += this.polarTriangleArea(tanLat, lng, prevTanLat, prevLng);
        prevTanLat = tanLat;
        prevLng = lng;
    }
    return Math.abs(total * (radius * radius));
    },

    polarTriangleArea(tan1,lng1,tan2,lng2) {
      let deltaLng = lng1 - lng2;
      let t = tan1 * tan2;
      return 2 * Math.atan2(t * Math.sin(deltaLng), 1 + t * Math.cos(deltaLng));
    },


      getRad(d){
        var PI = Math.PI;
        return d*PI/180.0;
      },

      Distance(lat1,lng1,lat2,lng2)
      {
        var EARTH_RADIUS = 6378137.0;
        var radLat1 = this.getRad(lat1);
        var radLat2 = this.getRad(lat2);
        var a = radLat1 - radLat2;
        var b = this.getRad(lng1) - this.getRad(lng2);
        var s = 2*Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s*EARTH_RADIUS;
        s = Math.round(s*10000)/10000.0;
        return s;
      },

      getgrith()
      {
        var a = this.Distance(this.geo_positiony[0],this.geo_positionx[0],this.geo_positiony[1],this.geo_positionx[1]);
        var b = this.Distance(this.geo_positiony[1],this.geo_positionx[1],this.geo_positiony[2],this.geo_positionx[2]);
        var c = this.Distance(this.geo_positiony[2],this.geo_positionx[2],this.geo_positiony[3],this.geo_positionx[3]);
        var d = this.Distance(this.geo_positiony[3],this.geo_positionx[3],this.geo_positiony[0],this.geo_positionx[0]);
        this.grith=a+b+c+d;
        this.showgrith=true;
      },



      getheight(){
        this.getheight=document.getElementById('rightpicture').style.height;
      },

      clickupX(e){
        this.whetherclickX=false;
      },

      clickdownX(e){
        this.whetherclickX=true;
      },

      clickupY(e){
        this.whetherclickY=false;
      },

      clickdownY(e){
        this.whetherclickY=true;
      },

      RollImageX(e){
      var x=e.pageX;
      document.getElementById('beforeX').style.width=x-60+"px";
      document.getElementById('scrollX').style.left=x-60+"px";
      },

      RollImageY(e){
      var y=e.pageY;
      document.getElementById('beforeY').style.height=(y-104-600)+"px";
      document.getElementById('scrollY').style.top=(y-104-600)+"px";
      },


      image2geoX(GT0,GT1,GT2,x,y){
          var px = GT0 + x * GT1 + y * GT2;
          // py = GT[3] + x * GT[4] + y * GT[5]
          return px
      },

      image2geoY(GT3,GT4,GT5,x,y){
          // px = GT[0] + x * GT[1] + y * GT[2]
          var py = GT3 + x * GT4 + y * GT5
          return py
      },



      getline(){
        let dom1=document.getElementById('marker1');
        let dom2=document.getElementById('marker2');
        let dom3=document.getElementById('marker3');
        let dom4=document.getElementById('marker4');
        let styleOption = {
        color: 'blue', // 指引线颜色
        endPlug: '', // 指引线结束点的样式 hand,disc
        size: 2, // 线条尺寸
        startSocket: 'bottom', //在指引线开始的地方从元素左侧开始
        endSocket: 'top', //在指引线开始的地方从元素右侧结束
        // hide: true, // 绘制时隐藏，默认为false，在初始化时可能会出现闪烁的线条
        startPlugColor: '#ff3792', // 渐变色开始色
        endPlugColor: '#fff386', // 渐变色结束色
        gradient: true, // 使用渐变色
        outLineColor: 'blue',
        path: 'straight', // straight,arc,fluid,magnet,grid
        dash: {
          // 虚线样式
          animation: true // 让线条滚动起来
        },
        hide: true
      };
      this.lineContainer1 = new LeaderLine(dom1, dom2, styleOption)
      this.lineContainer2 = new LeaderLine(dom2, dom3, styleOption)
      this.lineContainer3 = new LeaderLine(dom3, dom4, styleOption)
      this.lineContainer4 = new LeaderLine(dom4, dom1, styleOption)
      let showEffectName = 'draw'
      // 动画参数
      let animOptions = {
        duration: 1000, //持续时长
        timing: 'ease-in' // 动画函数
      }
      this.lineContainer1.show(showEffectName, animOptions)
      this.lineContainer2.show(showEffectName, animOptions)
      this.lineContainer3.show(showEffectName, animOptions)
      this.lineContainer4.show(showEffectName, animOptions)
      this.lineContainer1.position()
      this.lineContainer2.position()
      this.lineContainer3.position()
      this.lineContainer4.position()
      },



      getdistance(x1,y1,x2,y2){
        var distance = Math.sqrt(Math.pow(Math.abs(x2 - x1),2)+Math.pow(Math.abs(y2 - y1),2))
        return distance;
      },

//计算面积


// ComputeGrith(){
//   if(this.NumOfMarker==4)
//   {
//   this.grith=this.getdistance(this.positionx[0],this.positiony[0],this.positionx[1],this.positiony[1])
//             +this.getdistance(this.positionx[1],this.positiony[1],this.positionx[2],this.positiony[2])
//             +this.getdistance(this.positionx[2],this.positiony[2],this.positionx[3],this.positiony[3])
//             +this.getdistance(this.positionx[3],this.positiony[3],this.positionx[0],this.positiony[0]);
//             this.showgrith=true;
//   }
//   else 
//   {
//     alert("请标记四个点！");
//   }
// },


whethermark(){
  if(this.marktest==true)
  {
    this.marktest=false;
    this.markbutton="标记";
    document.getElementById('picture1').style.cursor="default";
  }
  else {
    this.marktest=true;
    this.markbutton="取消";
    this.positionshow=false;
    document.getElementById('picture1').style.cursor="pointer";
  }
},  

showmark(){
        if(this.NumOfMarker==1)
        {
          this.$set(this.mark,0,true);
          this.$set(this.mark,1,false);
          this.$set(this.mark,2,false);
          this.$set(this.mark,3,false);
        }

        else if(this.NumOfMarker==2)
        {
          this.$set(this.mark,0,true);
          this.$set(this.mark,1,true);
          this.$set(this.mark,2,false);
          this.$set(this.mark,3,false);
        }

        else if(this.NumOfMarker==3)
        {
          this.$set(this.mark,0,true);
          this.$set(this.mark,1,true);
          this.$set(this.mark,2,true);
          this.$set(this.mark,3,false);
        }
        else if(this.NumOfMarker==4)
        {
          this.$set(this.mark,0,true);
          this.$set(this.mark,1,true);
          this.$set(this.mark,2,true);
          this.$set(this.mark,3,true);
        }
        else if(this.NumOfMarker==0)
        {
          this.$set(this.mark,0,false);
          this.$set(this.mark,1,false);
          this.$set(this.mark,2,false);
          this.$set(this.mark,3,false);
        }
    },

      // 展示卷帘
        leafX(){
          if(this.showleafY==true)
          this.showleafY=false;
          if(this.showleafX==true)
          this.showleafX=false;
          else this.showleafX=true;
          
        },

        leafY(){
          if(this.showleafX==true)
          this.showleafX=false;
          if(this.showleafY==true)
          this.showleafY=false;
          else this.showleafY=true;
        },

      //创建标记
      createMarker(x,y){
        var div = document.createElement('div');
        div.className='marker';div.style.left = x+'px'; div.style.top = y + 'px';
        if(this.NumOfMarker==0)
        {div.id='marker1';}
        else if(this.NumOfMarker==1)
        {div.id='marker2';}
        else if(this.NumOfMarker==2)
        {div.id='marker3';}
        else if(this.NumOfMarker==3)
        {div.id='marker4';}
        document.getElementById('picture1').appendChild(div);
        this.NumOfMarker=this.NumOfMarker + 1;
      },



        addmarker(e){
          if(this.NumOfMarker >= 4)
          {
            alert("最多添加四个点！");
            return;
          }
          e = e || window.event;
          var x = e.offsetX;
          var y = e.offsetY;
          var index=this.NumOfMarker;
          this.positionx[index]=x;
          this.positiony[index]=y;
          this.geo_positionx[index]=this.image2geoX(this.pic1_GT[0],this.pic1_GT[1],this.pic1_GT[2],x,y);
          this.geo_positiony[index]=this.image2geoY(this.pic1_GT[3],this.pic1_GT[4],this.pic1_GT[5],x,y);
          this.createMarker(x,y);
          this.showmark();
          if(this.NumOfMarker == 4)
          {
            this.getline();
          }
        },

        //重置标记
        resetmarker(){
          var obj1=document.getElementById('marker1');
          obj1.parentNode.removeChild(obj1);
          var obj2=document.getElementById('marker2');
          obj2.parentNode.removeChild(obj2);
          var obj3=document.getElementById('marker3');
          obj3.parentNode.removeChild(obj3);
          var obj4=document.getElementById('marker4');
          obj4.parentNode.removeChild(obj4);
          this.NumOfMarker=0;
          this.mark=[false,false,false,false];
          this.positionx=["","","",""];
          this.positiony=["","","",""];
          this.showgrith=false;
          this.showarea=false;
          this.lineContainer1.remove();
          this.lineContainer2.remove();
          this.lineContainer3.remove();
          this.lineContainer4.remove();
        },

        showposition(){
            if(this.positionshow==true)
                this.positionshow=false
            else
                this.positionshow=true;
            this.infoshow = false;
            this.inputshow = false;
        },

        showinput(){
            if(this.inputshow==true)
                this.inputshow=false
            else
                this.inputshow=true;
            this.infoshow = false;
            this.positionshow = false;
        },

        showinfo(){
            if(this.infoshow==true)
                this.infoshow=false
            else
                this.infoshow=true;
            this.inputshow=false;
            this.positionshow=false;
        },

        display(){
        this.picshow=true
      },

      hide(){
        this.picshow=false
      },

      reset(){
        this.picurl1="",
        this.picurl2="",
        this.file1="",
        this.file2="",
        this.TifSize1="",
        this.TifSize2="",
        this.tif1x="",
        this.tif1y="",
        this.tif2x="",
        this.tif2y="",
        this.NumOfPic=0,
        this.pic1show=false,
        this.pic2show=false,
        document.getElementById("inputfile1").value="",
        document.getElementById("inputfile2").value="",
        this.resetmarker();
        // this.lineContainer1.hide();
        this.lineContainer1=null;
        this.lineContainer2=null;
        this.lineContainer3=null;
        this.lineContainer4=null;

      },

        upload1(event){
          if(this.picurl1!="")
          {
            this.picurl1="";
            this.NumOfPic=this.NumOfPic-1;
            
          };
  

        this.file1=event.target.files[0];
        this.pic1show=true;
        this.getfile1();
      },
      upload2(event){
        if(this.picurl2!="")
          {
            this.picurl2="";
            this.NumOfPic=this.NumOfPic-1;
            
          };
        this.file2=event.target.files[0];
        this.pic2show=true;
        this.getfile2();
      },

      getfile1(){
        var that=this;
        let formData1= new FormData();
        formData1.append('file',this.file1);

      axios({
        method: "post",
        data:formData1,
        url: "http://127.0.0.1:5000/getPic1",
        // responseType: "arraybuffer", 
      }).then(function (response) {
        that.NumOfPic=that.NumOfPic+1;
        that.picurl1 = response.data;
      });


      var that=this;
      let fd1 = new FormData();
      fd1.append('file',this.file1)

      axios({
        method:"post",
        data:fd1,
        url:'http://127.0.0.1:5000/getInfo1'
      }).then(function(response){
          that.TifSize1=response.data.size;
          that.tif1x=response.data.GT[0];
          that.tif1y=response.data.GT[3];
          that.pic1_GT[0]=response.data.GT[0];
          that.pic1_GT[1]=response.data.GT[1];
          that.pic1_GT[2]=response.data.GT[2];
          that.pic1_GT[3]=response.data.GT[3];
          that.pic1_GT[4]=response.data.GT[4];
          that.pic1_GT[5]=response.data.GT[5];
      });
    },

    getfile2(){
      var that=this;
      let formData2= new FormData();
      formData2.append('file',this.file2);

      axios({
        method: "post",
        data:formData2,
        url: "http://127.0.0.1:5000/getPic2",
        // responseType: "arraybuffer", 
      }).then(function (response) {
        that.NumOfPic=that.NumOfPic+1;
        that.picurl2 = response.data;
      });

      var that=this;
      let fd2 = new FormData();
      fd2.append('file',this.file2)
      axios({
        method:"post",
        data:fd2,
        url:'http://127.0.0.1:5000/getInfo2'
      }).then(function(response){
          that.TifSize2=response.data.size;
          that.tif2x=response.data.GT[0];
          that.tif2y=response.data.GT[3];
          that.pic2_GT[0]=response.data.GT[0];
          that.pic2_GT[1]=response.data.GT[1];
          that.pic2_GT[2]=response.data.GT[2];
          that.pic2_GT[3]=response.data.GT[3];
          that.pic2_GT[4]=response.data.GT[4];
          that.pic2_GT[5]=response.data.GT[5];
      });
    },
    // ArrayBuffer转为base64字符串
    arrayBufferToBase64(buffer) {
      //第一步，将ArrayBuffer转为二进制字符串
      var binary = "";
      var bytes = new Uint8Array(buffer);
      var len = bytes.byteLength;
      for (var i = 0; i < len; i++) {
        binary += String.fromCharCode(bytes[i]);
      }
      //将二进制字符串转为base64字符串
      return window.btoa(binary);
    },


    

    }

    
})
</script>

<style>

#beforeX{
  position: absolute;
  top:0px;
  left:0px;
  width: 300px;
  height: 600px;
  max-width: 600px;
  overflow: hidden;
}

#beforeY{
  position: absolute;
  top:0px;
  left:0px;
  width: 600px;
  height: 300px;
  max-height: 600px;
  overflow: hidden;
}

#beforeX img{
  width: 600px;
  height: 600px;
  overflow: hidden;
  /* display: block; */
}

#beforeY img{
  width: 600px;
  height: 600px;
  overflow: hidden;
  /* display: block; */
}

#afterX{
  position: absolute;
  top:0px;
  left:0px;
  width: 600px;
  height: 600px;
}

#afterY{
  position: absolute;
  top:0px;
  left:0px;
  width: 600px;
  height: 600px;
}

#afterX img{
  width: 600px;
  height: 600px;
}

#afterY img{
  width: 600px;
  height: 600px;
}

#scrollX{
  position:absolute;
  top: 0px;
  left:300px;
  width: 2px;
  height: 600px;
  cursor:col-resize;
  background:red;
}

#scrollY{
  position:absolute;
  top: 300px;
  left:0px;
  width: 600px;
  height: 2px;
  cursor:row-resize;
  background:red;
}

input{
  color:white;
  font-size: 15px;
}

.r1{
  width: 50px;
  height: 50px;
  background-color: aqua;

  border-radius: 50%;

  border: 4px solid black; 

  margin: 1px;
}

.r1:hover{
  background-color: aquamarine;
}

img[src=""]{
  opacity: 0;
}


.numpic1{
/* text-align: center; */
/* vertical-align: middle;
display: table-cell; */
}

.numpic1 .outdiv{
  max-width: 50%;
  position:relative;
  left:25%;
  margin:0px;

}

.numpic1 img{
  max-width: 100%;
}
.numpic2{
  display: inline;
}


.numpic2 .outdiv{
  
  /* position: relative; */
  display: inline-block;
  width: 600px;
  height: 600px;
  margin: 0px;
}

.numpic2 img{
  max-width: 100%;
}

.leftpic{
    width:50px;
    height: 50px;
}
.leftpicdiv{
    width:50px;
    height: 50px;

}

.topdiv{
    display: inline-block;
}

.leftdiv{
    display: inline-block;
    position: fixed;
}
.rightdiv{
    display: inline-block;
    position: absolute;
    left:60px;
}

.rightdiv1{
    display: inline-block;
    position: absolute;
    left:60px;

}

.rightdiv-input{
    background: rgba(25, 55, 190, 0.534);
    width:300px;
    height:300px;
    border: 2px solid #00f7ff;
    -webkit-box-shadow: 0 0 20px rgb(0, 225, 255) inset;    
    position:fixed;		
    overflow: scroll;  
}

.rightdiv-info{
    background: rgba(25, 55, 190, 0.534);
    width:300px;
    height:300px;
    border: 2px solid #00f7ff;
    -webkit-box-shadow: 0 0 20px rgb(0, 225, 255) inset; 
    position: fixed;   
    overflow: scroll;		  
}

.rightdiv-position{
    background: rgba(25, 55, 190, 0.534);
    width:300px;
    height:300px;
    border: 2px solid #00f7ff;
    -webkit-box-shadow: 0 0 20px rgb(0, 225, 255) inset; 
    position: fixed;  
    pointer-events:auto; 	
    overflow: scroll;
    z-index: 10;
}

.rightdiv-position button{
    pointer-events:all; 	
}


.container1{
    position: relative;
    /* display: inline-block; */
    width: 600px;
    height: 600px;
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

.upleft{
  margin-left: 5px;
}

.message{
    color:white;
}

.message .left{
  display: inline-block;
  float: left;
  width:50%;
}

.message .right{
  display: inline-block;


}

#picture1{

}

#markeres{

}

.marker{
  position: absolute;
  width: 5px;
  height: 5px;
  background: red;
  z-index: 10;
}
</style>