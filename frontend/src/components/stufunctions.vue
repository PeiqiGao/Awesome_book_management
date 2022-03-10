<template>

<div>
    <headertop></headertop>
<div>
    <p class="test">ID:{{ id }}</p>
    <div class="buttonstyle1">
    <a @click="goborrow()">借阅图书</a>
    </div>
    <div class="buttonstyle1">
    <a @click="goback()">归还图书</a>
    </div>
    <div class="buttonstyle1">
    <a @click="gopaper()">查询论文</a>
    </div>
</div>
</div>
</template>

<script>
import headertop from './headertop.vue'

export default ({
    name:"stufunctions",
    components:{headertop},
    data(){
        return{
            id:"",
        }
    },
    methods:{
        getpara(){
            this.id=this.$route.query.id;
        },
        goborrow(){
            this.$router.push({path:'/stuborrow',
                                    query:{id:this.id}});
        },
        goback(){
            this.$router.push({path:'/stuback',
                                    query:{id:this.id}});
        },
        gopaper(){
            this.$router.push({path:'/stupapersearch',
                                    query:{
                                        id:this.id
                                    }})
        }
    },
    created(){
        this.getpara();
    }
})
</script>

<style scoped>
    /* *{margin: 0%;} */
    /* *{
        box-sizing: border-box;
        margin:0px;
        padding:0px;
        font-family: '微软雅黑', sans-serif;
    } */
.test{
    color: white;
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
    .buttonstyle1{
        margin-top:10%;
        text-align: center;
    }

    a {
            
            
            position: relative;
            padding: 20px 40px;
            margin: 0 45px;
            color: #21ebff;
            text-decoration: none;
            font-size: 20px;
            text-transform: uppercase;
            transition: 0.5s;
            overflow: hidden;
            -webkit-box-reflect: below 1px linear-gradient(transparent, #0003);
        }
 
        a:hover {
            background: #21ebff;
            color: #111;
            box-shadow: 0 0 50px #21ebff;
            transition-delay: 0.5s;
        }

        a::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 10px;
            height: 10px;
            border-top: 2px solid #21ebff;
            border-left: 2px solid #21ebff;
            transition: 0.5s;
            transition-delay: 0.5s;
        }
 
        a:hover::before {
            width: 98%;
            height: 97%;
            transition-delay: 0s;
        }
 
        a::after {
            content: '';
            position: absolute;
            right: 0;
            bottom: 0;
            width: 10px;
            height: 10px;
            border-bottom: 2px solid #21ebff;
            border-right: 2px solid #21ebff;
            transition: 0.5s;
            transition-delay: 0.5s;
        }
 
        a:hover::after {
            width: 98%;
            height: 97%;
            transition-delay: 0s;
        }
</style>