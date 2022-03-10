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
    <div class="container1">
    <form action="" class="parent">
        <select id="select" class="myselect">
            <option value="bookname">书名</option>
            <option value="author">作者</option>
            <option value="bookid">书号</option>
            <option value="bookshelf">书架</option>
            <option value="all">全部</option>
        </select>
        <input type="text" value="" class="search" placeholder="查询图书" id='search'>
        <button type="button" class="btn" @click="search()">查询</button>
    </form>
    </div>
    <div class="tableback" id="big">
        <table id="table1" class="booktable" >
            
        </table>
    </div>
    <!-- <p style="color:white">{{ choose }}</p>
    <p style="color:white">{{ content }}</p> -->
    </div>
</template>

<script>
import headertop from './headertop.vue'
import axios from 'axios'
import qs from 'qs'

export default ({
    name:"mngdelete",
    components:{headertop},
    data()
    {
        return{
            id:"",
            choose:"",
            content:"",
            list:"",
            length:"",
            sb:"",
            choosedelete:{
                name:"",
                author:"",
                price:"",
                publishinghouse:"",
                shelf:"",
            }
        }
    },
    methods:
    {
        getpara(){
            this.id=this.$route.query.id;
        },
        back(){
            this.$router.push({path:'/mngfunction',
                                    query:{id:this.id}});
        },
        search(){
            var outtable = document.getElementById('table1')
            outtable.innerHTML=("")
            var that = this;
            var myselect = document.getElementById('select');
            var index=myselect.selectedIndex;
            this.choose = myselect.options[index].value;
            this.content = document.getElementById('search').value;
            axios({
                method:"post",
                contentType: 'application/json',
                data:qs.stringify({
                    'select':that.choose,
                    'name':that.content,  
                    'shelfid':that.content,  
                }),
                url:"http://localhost:8080/search",
            }).then(function(response)
            {
                console.log(response)
                var list=response.data
                var length=list.length
                    var row1 = document.createElement('tr')
                    row1.id="first"
                    var idtd = document.createElement('td')
                    idtd.innerHTML = "书号"
                    idtd.className = "tdtitle"
                    var nametd = document.createElement('td')
                    nametd.innerHTML = "书名"
                    nametd.className = "tdtitle"
                    var authortd = document.createElement('td')
                    authortd.innerHTML = "作者"
                    authortd.class = "tdtitle"
                    var availabetd = document.createElement('td')
                    availabetd.innerHTML = "余量"
                    availabetd.className = "tdtitle"
                    var possessiontd = document.createElement('td')
                    possessiontd.className = "tdtitle"
                    possessiontd.innerHTML = "拥有量"
                    var pricetd = document.createElement('td')
                    pricetd.innerHTML = "价格"
                    pricetd.className = "tdtitle"
                    var publishinghousetd=document.createElement('td')
                    publishinghousetd.innerHTML = "出版社"
                    publishinghousetd.className = "tdtitle"
                    var bookshelftd=document.createElement('td')
                    bookshelftd.innerHTML = "书架"
                    bookshelftd.className = "tdtitle"
                    var deletetd=document.createElement('td')
                    deletetd.innerHTML = "删除"
                    deletetd.className = "tdtitle"
                    row1.append(idtd)
                    row1.append(nametd)
                    row1.append(authortd)
                    row1.append(possessiontd)
                    row1.append(availabetd)
                    row1.append(pricetd)
                    row1.append(publishinghousetd)
                    row1.append(bookshelftd)
                    row1.appendChild(deletetd)
                    document.getElementById('table1').append(row1)
                for(var i=0;i<length;i++)
                {
                    var row = document.createElement('tr')
                    row.id="row"+i
                    var idtd = document.createElement('td')
                    idtd.id="idtd"+i
                    idtd.innerHTML = list[i].bookid
                    var nametd = document.createElement('td')
                    nametd.id='nametd'+i
                    nametd.innerHTML = list[i].name
                    var authortd = document.createElement('td')
                    authortd.id='authortd'+i
                    authortd.innerHTML = list[i].author
                    var availabetd = document.createElement('td')
                    availabetd.innerHTML = list[i].available
                    var possessiontd = document.createElement('td')
                    possessiontd.innerHTML = list[i].possession
                    var pricetd = document.createElement('td')
                    pricetd.id='pricetd'+i
                    pricetd.innerHTML = list[i].price
                    var publishinghousetd=document.createElement('td')
                    publishinghousetd.id='publishinghousetd'+i
                    publishinghousetd.innerHTML = list[i].publishinghouse
                    var bookshelftd=document.createElement('td')
                    bookshelftd.innerHTML = list[i].type
                    bookshelftd.id='bookshelf'+i
                    var deletetd=document.createElement('td')
                    var deletebutton = document.createElement('button')
                    deletebutton.innerHTML = "删除"
                    deletebutton.id=i
                    deletebutton.onclick=function(){
                        var index = this.id
                        that.choosedelete.name=document.getElementById('nametd'+index).innerHTML
                        that.choosedelete.author=document.getElementById('authortd'+index).innerHTML
                        that.choosedelete.price=document.getElementById('pricetd'+index).innerHTML
                        that.choosedelete.publishinghouse=document.getElementById('publishinghousetd'+index).innerHTML
                        that.choosedelete.shelf = document.getElementById('bookshelf'+index).innerHTML
                        axios({
                            method:"post",
                            contentType: 'application/json',
                            data:qs.stringify({
                                    'name':that.choosedelete.name,
                                    'author':that.choosedelete.author,
                                    'price':that.choosedelete.price,
                                    'publishinghouse':that.choosedelete.publishinghouse,
                                    'type':that.choosedelete.shelf
                            }),
                            url:"http://localhost:8080/bookdelete",
                    }).then(function(response){
                        if(response.data==1)
                        {alert("删除成功！")
                            location.reload()
                        }
                        else 
                        {
                            alert("删除失败！")
                        }
                    })
                    }
                    deletetd.append(deletebutton)
                    row.append(idtd)
                    row.append(nametd)
                    row.append(authortd)
                    row.append(possessiontd)
                    row.append(availabetd)
                    row.append(pricetd)
                    row.append(publishinghousetd)
                    row.append(bookshelftd)
                    row.append(deletetd)
                    document.getElementById('table1').append(row)
                }
            })
    },
    },
    created(){
        this.getpara();
    },
})
</script>

<style scoped>
.test{
    color: white;
}

* {
    margin: 0;
    padding: 0;
}
.container1 {
    height: 70px;
    width: 600px;
    margin: 100px auto 0 auto;
}
.parent {
    position: relative;
}
.search {
    width: 500px;
    height: 40px;
    border-radius: 18px;
    outline: none;
    border: 1px solid #ccc;
    padding-left: 20px;
    /* position: absolute; */
}
.btn{
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

.btn:hover{
    background: white;
}
.tableback{
    background:white;
    margin: 100px auto 0 auto;
    width: 600px;
}

.booktable{
    background: white;
    margin: 100px auto 0 auto;
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

.myselect{
    width: 60px;
    height: 40px;
    font-size: 20px;
}
</style>