<template>
<div>
  <div class="pic" @mousedown="clickdown($event)" @mouseup="clickup($event)" id="div1">
    <img src="../static/image/dome2.jpg" class="test">
  </div>
  <div style="color:white">
    x1:{{ x1 }},y1:{{ y1 }}<br>
    x2:{{ x2 }},y2:{{ y2 }}
  </div>
</div>
</template>

<script>

export default ({
  name:"test",
  data(){
    return{
      x1:"",
      y1:"",
      x2:"",
      y2:"",
    }
  },
  methods:{
    clickdown(e){
      this.x1=e.pageX;
      this.y1=e.pageY;
    },
    clickup(e){
      this.x2=e.offsetX;
      this.y2=e.offsetY;


    }
  }
})
</script>

<style >

.pic{
  height: 600px;
  width: 600px;
}
.pic img{
    height: 600px;
  width: 600px;
  position:absolute;
  /* clip: rect(100px,10px,10px,10px); */
}

.noclick{
  pointer-events: none;
}
</style>