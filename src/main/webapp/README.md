

# 关于本网站

# 目录

[TOC]



## 一、简介

我们日后使用J2EE平台开发，其前端页面使用`.jsp`后缀，`.jsp`与`.html`兼容，不同的是他需要`<%%>`标签来标注这是一个`.jsp`页面，然后就可以在html的<%%>里写java代码了。

这里分了一个[index.html](./index.html)和[index.jsp](./index.jsp)，可以看到他们的区别只有前头有无 `<%@page ... %>` 标签，如下：

```jsp
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
```

## 二、部署与浏览

如果只是想看一下效果，那么可以吧` <%@page ... %>` 标签去除，改后缀名为`.html`就能直接在浏览器浏览。

——报告教官，我不想每次都改成html，我想直接看jsp文件，怎么搞

首先你要部署tomcat服务器，然后通过tomcat来浏览那个目录的jsp

> ### 部署tomcat，启动并浏览jsp
>
> - step1. [部署tomcat服务器](https://jingyan.baidu.com/article/cb5d6105f199a9005d2fe05c.html)
>
> - step2. [启动tomcat服务器并浏览jsp文件](https://zhidao.baidu.com/question/182441267.html)

## 三、前端工程师要做什么事情

如：按登录按钮后不跳转在本页面完成登录（用jq的ajax完成)

按照ui工程师提出的要求构造整个html的框架，与完成css的编写，并且将按钮等信息提交到后台。

其中提交信息的方法在[js/functions.js](./js/functions.js)有写明，

## 四、目前使用的环境树

代码托管：https://github.com/Aim-Tric/CoachAndCourse

运行服务器：Tomcat-9.0

通用IDE：Jetbrains公司的 ItelliJ Idea Ultimate 版本

库类：jsp+(预定 SpringMVC)+mybatis+mysql

## 五、不懂的东西怎么问

如果你还没确定加入本项目，先问bk(张家宝)吧，

> ### bk的联系方式
>
> - 电话：18675484484，
>
> - 微信同电话，
>
> - QQ及邮箱：1209418977@qq.com

只要确定加入了本项目，我们会建立一个专们面向项目的微信群，遇到的难题、不懂的操作方法，都在群里讨论，会的人都会帮忙解决，里面有老师，

