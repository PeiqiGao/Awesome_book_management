# 图书论文管理系统

### 1.简介

#### 1.1基本情况

本系统为基于vue+springboot实现的图书论文管理系统。分为学生和管理员两种用户，管理员可以对图书和论文进行增删改查，学生可以借阅和归还图书并且搜索相关的论文。

前端采用vue+axios实现了和用户的交互页面，通过axios实现了前后端的交互（传输数据）。

后端采用了java+springboot+mybatis+JDBC，数据库为postgreSQL。

#### 1.2版本

postgresql：9.2.4
springboot：2.6.4
mybatis：1.1.1
JDK：1.8.0
vue3

### 2.开始

1.进入backend，执行test中的newapplicationtests.java

2.进入frontend，执行以下命令：

```
npm install
npm run dev
```

然后会生成本地地址，默认为localhost:9000

此时通过浏览器打开localhost:9000即可看到首页。

（如果提示未发现npm指令，需要首先安装node环境，地址为https://nodejs.org/en/）

### 3.联系

前端部分：peiqigao18@gmail.com 高沛琦

后端部分：kuangyi_123@yeah.net 赵匡益
