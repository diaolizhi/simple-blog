# 项目介绍

Simple-Blog 是一个简单的博客项目，基于 Spring Boot 2.0，使用了 Bootstrap 4、Thymeleaf、MyBatis、editor.md 和 pagehelper 等。

# 主要功能

- 文章分类
- 查找关键字
- 评论文章
- 留言
- 发表、修改、删除文章
- 删除评论、留言

# 演示地址

http://www.diaolizhi.com

# 运行截图

- 首页

![](https://wx4.sinaimg.cn/mw690/0065Ozb6ly1fuodh6b93zj311y0hfta5.jpg)

- 文章页面

![](https://wx1.sinaimg.cn/mw690/0065Ozb6ly1fuodh6f5h0j311y0hfabm.jpg)

- 编辑文章

![](https://wx1.sinaimg.cn/mw690/0065Ozb6ly1fuodh6glihj311x0hcwh4.jpg)

- 手机端 - 首页

![](https://wx1.sinaimg.cn/mw690/0065Ozb6gy1fuoef7og6gj30k00yd411.jpg)

- 手机端 - 文章页面

![](https://wx4.sinaimg.cn/mw690/0065Ozb6gy1fuoef85px0j30k00y9whb.jpg)

# 使用方法

1. 创建数据表

   ```sql
   CREATE TABLE IF NOT EXISTS article(
   id INT PRIMARY KEY AUTO_INCREMENT,
   title VARCHAR(100) NOT NULL,
   author VARCHAR(20) NOT NULL,
   category int,
   created_time DATETIME NOT NULL,
   modified_time DATETIME NOT NULL,
   is_hide INT DEFAULT 1,
   views INT DEFAULT 0,
   body TEXT NOT NULL
   )
   
   CREATE TABLE IF NOT EXISTS category(
   id INT PRIMARY KEY AUTO_INCREMENT,
   category_name VARCHAR(20) UNIQUE NOT NULL,
   article_num INT NOT NULL
   )
   
   CREATE TABLE IF NOT EXISTS comments (
   id INT PRIMARY KEY AUTO_INCREMENT,
   article_id INT NOT NULL,
   speaker VARCHAR(100) NOT NULL,
   comment_content VARCHAR(3000) NOT NULL,
   comment_time DATETIME NOT NULL
   )
   
   CREATE TABLE IF NOT EXISTS message (
   id INT PRIMARY KEY AUTO_INCREMENT,
   speaker VARCHAR(100) NOT NULL,
   message_content VARCHAR(3000) NOT NULL,
   message_time DATETIME NOT NULL
   )
   ```

2. 在 application.properties 中修改数据库信息

3. 将项目打成 jar 包

4. 使用 java -jar 命令运行

