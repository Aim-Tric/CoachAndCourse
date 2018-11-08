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


<div class="container">
    <div class="row">
        <div class="hidden-lg col-md-4 col-lg-1">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <ul class="nav nav-pills nav-stacked">
                        <li class="active"><a href="#">饭前小食</a></li>
                        <li><a class="divider"></a></li>
                        <li><a href="#">美味午餐</a></li>
                        <li><a class="divider"></a></li>
                        <li><a href="#">团圆晚餐</a></li>
                        <li><a class="divider"></a></li>
                        <li><a href="#">饭后甜点</a></li>
                    </ul>

                </div>

            </div>


        </div>
        <div class="col-md-8 col-lg-9">
            <div class="carousel slide" id="carousel-13519">
                <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target="#carousel-13519">
                    </li>
                    <li data-slide-to="1" data-target="#carousel-13519">
                    </li>
                    <li data-slide-to="2" data-target="#carousel-13519">
                    </li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <img alt="" src="img/1.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                自制风味酱料秘籍
                            </h4>
                            <p>
                                酱料是一种神奇的存在，它们可蘸食、可调味，甚至有的可以当作小菜，来看看自己怎么做才好吃吧！
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="img/2.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                百吃不厌的南瓜菜单

                            </h4>
                            <p>
                                在你的印象中，南瓜是怎样的一种食材？怎么烹饪？其实，南瓜既可以当粮食又可以拿来当菜吃，而且价格便宜，真正的物兼价美。做成菜肴更是让人眼前一亮，百吃不厌呢～


                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="img/3.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                自行车
                            </h4>
                            <p>
                                以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。
                            </p>
                        </div>
                    </div>
                </div>
                <a data-slide="prev" href="#carousel-13519" class="left carousel-control"></a>
                <a data-slide="next" href="#carousel-13519" class="right carousel-control"></a>
            </div>
        </div>
        <div class="col-md-2 col-lg-3 hidden-xs hidden-sm hidden-md">
            <div class="panel panel-default">

                <div class="panel-body">
                    <form class="form-horizontal" id="login_form" method="post">
                        <h3 class="form-title">登录</h3>
                        <div id='alert-pw' class='alert alert-warning hidden'>
                            <a href='#' class='close' data-dismiss='alert'>&times;</a>
                            <strong>警告！</strong>账户或密码错误
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">

                                <i class="fa fa-user fa-lg"></i>
                                <input class="form-control required" type="text" placeholder="用户名" id="username"
                                       name="username" autofocus="autofocus" maxlength="20"/>
                            </div>
                            <div class="form-group">

                                <i class="fa fa-lock fa-lg"></i>
                                <input class="form-control required" type="password" placeholder="密码" id="password"
                                       name="password" maxlength="16"/>
                            </div>
                            <div class="form-group">
                                <label class="checkbox-custom checkbox-default">
                                    <input type="checkbox" id="remenberme" name="rememberme" value="1"/>
                                    <label for="remenberme">记住我</label>
                                </label>
                            </div>
                            <div class="form-group col-md-offset-3 login-panel-button-group">
                                <button type="submit" class="btn btn-success" id="do-login" name="do-login">登录</button>
                                <button type="submit" class="btn btn-default" id="do-register" name="do-register">注册
                                </button>
                            </div>

                        </div>
                    </form>

                </div>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 md-toggle-row-fl">
            <div class="bg-grey-op-5">
                <div class="hero-unit">

                    <h1>
                        没烤箱也能做蛋糕
                    </h1>
                    <p>
                        想做蛋糕又犯愁没有烤箱？其实只要有电饭煲就能做哦，而且蒸的蛋糕好吃不上火哦～
                    </p>
                    <p>
                        <a class="btn btn-primary btn-large" href="#">参看更多 »</a>
                    </p>
                    <span class="badge">#352</span>
                    <span class="label label-primary">料理教学</span>
                    <span class="label label-info">小姐姐</span>
                    <span class="label label-primary">懒人教学</span>
                    <span class="label label-success">#你不知道的日常用品技巧#</span>

                </div>
            </div>

        </div>
        <div class="md-toggle-row">
            <div class="col-xs-12 col-md-6 col-lg-6 ">
                <div class="col-xs-6 col-md-12 ">
                    <div class="well">
                        <h2>
                            换着花样吃米饭
                        </h2>
                        <p>
                            觉得吃白米饭太无聊？那就换着花样吃米饭呀！这样做，真的想不好吃都难！
                        </p>
                        <p>
                            <a class="btn btn-default" href="#">查看更多 »</a>
                        </p>
                        <span class="badge">#361</span>

                        <span class="label label-default">米饭</span>
                        <span class="label label-success">#吃法#</span>
                    </div>


                </div>
                <div class="col-xs-6 col-md-12 ">
                    <div class="well">
                        <h2>
                            粗粮细做更健康
                        </h2>
                        <p>
                            精致的碳水化合物虽然味道美，可从健康方面考虑，还是偶尔吃一些粗粮调节一下吧～
                        </p>
                        <p>
                            <a class="btn btn-default" href="#">查看更多 »</a>
                        </p>
                        <span class="badge">#324</span>
                        <span class="label label-default">粗粮</span>
                        <span class="label label-success">#健康#</span>
                    </div>

                </div>
            </div>
        </div>

    </div>


    <!-- 第一行 -->

    <div class="row">
        <ul class="thumbnails">
            <li class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                <div class="thumbnail">
                    <img alt="300x200" src="img/thumbnail1.jpg"/>
                    <div class="caption">
                        <h3>
                            蜘蛛饼干
                        </h3>
                        <p>
                            <span>万圣节是西方的传统节日，这两年国内也开始流行过万圣节，在万圣节来临的前夜孩子们会装扮成各种可爱的鬼怪去敲门讨糖果吃。前两年小朋友还会有好朋友们一起去讨糖果，随着年龄的增长不再愿意去参与讨糖活动</span>
                        </p>
                        <p>
                            <a class="btn btn-primary" href="#">浏览</a> <a class="btn btn-default" href="#">分享</a>
                        </p>
                    </div>
                </div>
            </li>
            <li class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                <div class="thumbnail">
                    <img alt="300x200" src="img/thumbnail2.jpg"/>
                    <div class="caption">
                        <h3>
                            咸口南瓜饼
                        </h3>
                        <p>
                            <span>朋友们往常吃的都是豆沙版本的南瓜饼对吗？其实做成咸口的风味也不错呢。备好了食材我发现家里的低筋粉没有了，于是就用金龙鱼面包用小麦粉来代替。</span><span>本来做中式的面食最好是低高筋混合起来。不过这样子也好。</span>
                        </p>
                        <p>
                            <a class="btn btn-primary" href="#">浏览</a> <a class="btn btn-default" href="#">分享</a>
                        </p>

                    </div>
                </div>
            </li>
            <li class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                <div class="thumbnail">
                    <img alt="300x200" src="img/thumbnail3.jpg"/>
                    <div class="caption">
                        <h3>
                            云顶曲奇
                        </h3>
                        <p>
                            <span>这是一款经久不衰的网红曲奇，独特的形状，酥松的口感，让人欲罢不能！可以替朋友们试一下用高筋面粉来做了中式面食口感会如何?</span>
                        </p>
                        <p>
                            <a class="btn btn-primary" href="#">浏览</a> <a class="btn btn-default" href="#">分享</a>
                        </p>
                    </div>
                </div>
            </li>
            <li class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                <div class="thumbnail">
                    <img alt="300x200" src="img/thumbnail4.jpg"/>
                    <div class="caption">
                        <h3>
                            蔓越莓玛德琳
                        </h3>
                        <p>
                            <span>原本是打算做磅蛋糕，苦于模具不知道被我扔去哪， 就用了新到的玛德琳模具代替，成品还很好吃，而且烘烤的时间也 缩短了 不用切开，方便食用。</span>
                        </p>
                        <p>
                            <a class="btn btn-primary" href="#">浏览</a> <a class="btn btn-default" href="#">分享</a>
                        </p>
                    </div>
                </div>
            </li>

        </ul>
    </div>

    <div class="row">
        <ul class="thumbnails">
            <li class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                <div class="thumbnail">
                    <img alt="300x200" src="img/thumbnail1.jpg"/>
                    <div class="caption">
                        <h3>
                            蜘蛛饼干
                        </h3>
                        <p>
                            <span>万圣节是西方的传统节日，这两年国内也开始流行过万圣节，在万圣节来临的前夜孩子们会装扮成各种可爱的鬼怪去敲门讨糖果吃。前两年小朋友还会有好朋友们一起去讨糖果，随着年龄的增长不再愿意去参与讨糖活动</span>
                        </p>
                        <p>
                            <a class="btn btn-primary" href="#">浏览</a> <a class="btn btn-default" href="#">分享</a>
                        </p>
                    </div>
                </div>
            </li>
            <li class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                <div class="thumbnail">
                    <img alt="300x200" src="img/thumbnail2.jpg"/>
                    <div class="caption">
                        <h3>
                            咸口南瓜饼
                        </h3>
                        <p>
                            <span>朋友们往常吃的都是豆沙版本的南瓜饼对吗？其实做成咸口的风味也不错呢。备好了食材我发现家里的低筋粉没有了，于是就用金龙鱼面包用小麦粉来代替。</span><span>本来做中式的面食最好是低高筋混合起来。不过这样子也好。</span>
                        </p>
                        <p>
                            <a class="btn btn-primary" href="#">浏览</a> <a class="btn btn-default" href="#">分享</a>
                        </p>

                    </div>
                </div>
            </li>
            <li class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                <div class="thumbnail">
                    <img alt="300x200" src="img/thumbnail3.jpg"/>
                    <div class="caption">
                        <h3>
                            云顶曲奇
                        </h3>
                        <p>
                            <span>这是一款经久不衰的网红曲奇，独特的形状，酥松的口感，让人欲罢不能！可以替朋友们试一下用高筋面粉来做了中式面食口感会如何?</span>
                        </p>
                        <p>
                            <a class="btn btn-primary" href="#">浏览</a> <a class="btn btn-default" href="#">分享</a>
                        </p>
                    </div>
                </div>
            </li>
            <li class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                <div class="thumbnail">
                    <img alt="300x200" src="img/thumbnail4.jpg"/>
                    <div class="caption">
                        <h3>
                            蔓越莓玛德琳
                        </h3>
                        <p>
                            <span>原本是打算做磅蛋糕，苦于模具不知道被我扔去哪， 就用了新到的玛德琳模具代替，成品还很好吃，而且烘烤的时间也 缩短了 不用切开，方便食用。</span>
                        </p>
                        <p>
                            <a class="btn btn-primary" href="#">浏览</a> <a class="btn btn-default" href="#">分享</a>
                        </p>
                    </div>
                </div>
            </li>

        </ul>
    </div>


    <!-- 翻页器 -->
    <div class="row visible-lg">
        <div class="center-block">
            <ul class="pagination ">
                <li>
                    <a href="#">上一页</a>
                </li>
                <li>
                    <a href="#">1</a>
                </li>
                <li>
                    <a href="#">2</a>
                </li>
                <li>
                    <a href="#">3</a>
                </li>
                <li>
                    <a href="#">4</a>
                </li>
                <li>
                    <a href="#">5</a>
                </li>
                <li>
                    <a href="#">下一页</a>
                </li>
            </ul>
        </div>
    </div>


</div>

<footer>
    <div class="card-header">
        <!--  # 块形文字内容  -->
        <div class="card-contents">
            <div class="card-contents-inner">
                <p>This Site is a sample site,All of this is previous it belongs to none of a company or ognazation
                    all of contents from outer site is foke.</p>
            </div>
            <div class="card-contents-inner">
                <p>Gdaib Paly College | Librarians Community Libvary Mail Syste m |Write to the Director Userful
                    Links | Site Map | Old Version</p>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>

        <!-- # 分割线 -->
        <div class="card-line">
            <hr>
            <div class="line-fnd-mobile">鲜极味水果© 移动端</div>
            <div class="clear"></div>
        </div>

        <!-- # 二维码 -->
        <div class="div-qrcode">
            <div class="div-qrcode-inner">
                <img src="img/Android.png" alt="anndroid">
                <p>Andoird</p>
            </div>
            <div class="div-qrcode-inner">
                <img src="img/iOS.png" alt="ios">
                <p>iOS</p>
            </div>
            <div class="lineImg"></div>
            <div class="clear"></div>
        </div>


    </div>
    <div class="card-footer">
        <h4 class="copyright-text">Copyright 2018, 610 Team, All Right Reserved.</h4>
        <div class="card-label">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">News</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </div>
        <div class="clear"></div>

    </div>
</footer>
</body>

</html>
