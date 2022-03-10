<template>
    <div>
        <headertop></headertop>
        <p class="test">ID:{{ id }}</p>
        <div>
        <button class="btnback" @click="back()">返回</button>
    </div>
    <div class="backtitle">
        我的书籍
    </div>
    <div class="tableback">
        <table id="table1" class="booktable" >
        </table>
    </div>
    </div>



    
</template>


<script>
import headertop from './headertop.vue'
import axios from 'axios'
import qs from 'qs'

export default ({
    name:"stuborrow",
    components:{headertop},
    data(){
        return{
            id:"",
            bookid:"",
            time:"",
        }
    },
    methods:
    {
        back(){
            this.$router.push({path:'/stufunction',
                                    query:{id:this.id}});
        },
        getpara(){
            this.id=this.$route.query.id;
        },
    },
    created(){
        this.getpara();
        var that = this
        axios({

                method:"post",
                contentType: 'application/json',
                data:qs.stringify({
                    'username':that.id
                }),
                url:"http://localhost:8080/borrowinfo",
            }).then(function(response){
                console.log(response)
                var list=response.data
                var length=list.length
                    var row1 = document.createElement('tr')
                    row1.id="first"
                    row1.setAttribute('class','addtr')
                    var idtd = document.createElement('td')
                    idtd.innerHTML = "书号"
                    idtd.className = "tdtitle"
                    var nametd = document.createElement('td')
                    nametd.innerHTML = "书名"
                    nametd.className = "tdtitle"
                    var timetd=document.createElement('td')
                    timetd.innerHTML = "借阅时间"
                    timetd.className = "tdtitle"
                    var borrowtd=document.createElement('td')
                    borrowtd.innerHTML = "归还"
                    borrowtd.className = "tdtitle"
                    row1.append(idtd)
                    row1.append(nametd)
                    row1.append(timetd)
                    row1.append(borrowtd)
                    document.getElementById('table1').appendChild(row1)
                for(var i=0;i<length;i++)
                {
                    var row = document.createElement('tr')
                    var idtd = document.createElement('td')
                    idtd.innerHTML = list[i].bookid
                    idtd.id = "idtd"+i
                    var nametd = document.createElement('td')
                    nametd.innerHTML = list[i].bookname
                    var timetd=document.createElement('td')
                    timetd.innerHTML = list[i].borrowtime
                    timetd.id = "timetd"+i
                    var borrowtd=document.createElement('button')

                    borrowtd.innerHTML = "归还"
                    borrowtd.id = i
                    borrowtd.onclick = function(){
                        var index = this.id
                        that.bookid = document.getElementById('idtd'+index).innerHTML
                        that.time = document.getElementById('timetd'+index).innerHTML
                        // alert(that.bookid)
                        axios({
                            method:"post",
                            contentType: 'application/json',
                            data:qs.stringify({
                                    'bookid':that.bookid,
                                    'username':that.id,
                                    'borrowtime':that.time
                            }),
                            url:"http://localhost:8080/bookback",
                    }).then(function(response){
                        if(response.data==1)
                        {alert("归还成功！")
                        location.reload();

                        }
                        else 
                        {
                            alert("归还失败！")
                        }
                    })
                    }
                    row.append(idtd)
                    row.append(nametd)
                    row.append(timetd)
                    row.append(borrowtd)
                    document.getElementById('table1').appendChild(row)
                }
            })
    }
})
</script>

<style scoped>
.backtitle{
    color: white;
    font-size:40px;
    margin-top: 60px;
    width: 100%;
    text-align: center;
}

.tableback{
    background:white;
    margin: 40px auto 0 auto;
    width: 600px;
}

.booktable{
    background: white;
    margin: 40px auto 0 auto;
    table-layout: fixed;
    width: 100%;
    text-align: center;

}

.booktable tr:nth-child(odd)
{
    background: gainsboro;
}

.booktable tr:nth-child(1)
{
    background: darkgray;
}
.booktable tr{
    text-align: center;
}

.tdtitle{
    text-align: center;
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

.test{
    color: white;
}
</style>
