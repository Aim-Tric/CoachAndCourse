<%--
  Created by IntelliJ IDEA.
  User: Aim-Trick
  Date: 2018/11/10
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!-- 编辑网站的 Bootstrap 核心 CSS 文件 -->
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- 用户自定义 -->
    <link rel="stylesheet" href="css/foodstyle.css">
    <script src="js/functions.js"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="logo-text" href="#">
                    <img id="logo" src="img/logo.png" alt="">
                    <a class="navbar-brand" href="#">Fresh&Delisious</a>

                </a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">鲜甜水果</a></li>
                    <li><a href="#">生鲜蔬菜</a></li>
                    <li class="active dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            恋上美食 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">小零食</a></li>
                            <li><a href="#"></a></li>
                            <li><a href="#">饭后甜点</a></li>
                            <li class="divider"></li>
                            <li><a href="#">进口干粮</a></li>
                            <li class="divider"></li>
                            <li><a href="#">另类零食</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


</header>

