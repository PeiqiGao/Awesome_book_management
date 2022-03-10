<template>
    <div>
        <headertop></headertop>
        <p class="test">ID:{{ id }}</p>
        <div>
        <button class="btnback" @click="back()">返回</button>
    </div>
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
    name:"mngchange",
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
            choosechange:{
                bookid:"",
                name:"",
                author:"",
                price:"",
                available:"",
                possession:"",
                publishinghouse:"",
                bookshelf:"",
                
            }
        }
    },
    methods:
    {
        change(){
            alert("改变！")
        },
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
                }),
                url:"http://localhost:8080/search",
            }).then(function(response){
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
                    possessiontd.className = "tdtitle"
                    var pricetd = document.createElement('td')
                    pricetd.innerHTML = "价格"
                    pricetd.className = "tdtitle"
                    var publishinghousetd=document.createElement('td')
                    publishinghousetd.innerHTML = "出版社"
                    publishinghousetd.className = "tdtitle"
                    var bookshelftd=document.createElement('td')
                    bookshelftd.innerHTML = "书架"
                    bookshelftd.className = "tdtitle"
                    var changetd=document.createElement('td')
                    changetd.innerHTML = "更改"
                    changetd.className = "tdtitle"
                    row1.append(idtd)
                    row1.append(nametd)
                    row1.append(authortd)
                    row1.append(possessiontd)
                    row1.append(availabetd)
                    row1.append(pricetd)
                    row1.append(publishinghousetd)
                    row1.append(bookshelftd)
                    row1.append(changetd)
                    document.getElementById('table1').append(row1)
                for(var i=0;i<length;i++)
                {
                    var row = document.createElement('tr')
                    var idtd = document.createElement('td')
                    idtd.innerHTML = list[i].bookid
                    idtd.id = "idtd"+i
                    var nametd = document.createElement('td')
                    nametd.innerHTML = list[i].name
                    nametd.id = "nametd"+i
                    var authortd = document.createElement('td')
                    authortd.innerHTML = list[i].author
                    authortd.id = "authortd"+i
                    var availabetd = document.createElement('td')
                    availabetd.innerHTML = list[i].available
                    availabetd.id="availabletd"+i
                    var possessiontd = document.createElement('td')
                    possessiontd.innerHTML = list[i].possession
                    possessiontd.id="possessiontd"+i
                    var pricetd = document.createElement('td')
                    pricetd.innerHTML = list[i].price
                    pricetd.id="pricetd"+i
                    var publishinghousetd=document.createElement('td')
                    publishinghousetd.innerHTML = list[i].publishinghouse
                    publishinghousetd.id="publishinghousetd"+i
                    var bookshelftd=document.createElement('td')
                    bookshelftd.innerHTML = list[i].type
                    bookshelftd.id="bookshelftd"+i
                    var changetd = document.createElement('button')
                    changetd.innerHTML = "更改"
                    changetd.id=i
                    changetd.onclick = function(){
                        var index = this.id
                        that.choosechange.bookid=document.getElementById('idtd'+index).innerHTML
                        that.choosechange.name=document.getElementById('nametd'+index).innerHTML
                        that.choosechange.author=document.getElementById('authortd'+index).innerHTML
                        that.choosechange.available=document.getElementById('availabletd'+index).innerHTML
                        that.choosechange.possession=document.getElementById('possessiontd'+index).innerHTML
                        that.choosechange.price=document.getElementById('pricetd'+index).innerHTML
                        that.choosechange.publishinghouse=document.getElementById('publishinghousetd'+index).innerHTML
                        that.choosechange.bookshelf=document.getElementById('bookshelftd'+index).innerHTML
                        that.$router.push({path:'/mngchangebook',
                                    query:{
                                        id:that.id,
                                        bookid:that.choosechange.bookid,
                                        name:that.choosechange.name,
                                        author:that.choosechange.author,
                                        available:that.choosechange.available,
                                        possession:that.choosechange.possession,
                                        price:that.choosechange.price,
                                        publishinghouse:that.choosechange.publishinghouse,
                                        bookshelf:that.choosechange.bookshelf
                                    }});
                    }
                    row.append(idtd)
                    row.append(nametd)
                    row.append(authortd)
                    row.append(possessiontd)
                    row.append(availabetd)
                    row.append(pricetd)
                    row.append(publishinghousetd)
                    row.append(bookshelftd)
                    row.append(changetd)
                    document.getElementById('table1').append(row)
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