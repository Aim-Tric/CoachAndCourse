<%--
  Created by IntelliJ IDEA.
  User: Aim-Trick
  Date: 2018/11/13
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="col-md-5" role="form">
    <div class="form-group">
        <label for="name">课程名称:</label>
        <input type="text" class="form-control" id="name" name="name">
    </div>
    <div class="form-group">
        <label for="overview">课程简介:</label>
        <textarea name="overview" cols="30" rows="10" class="form-control" id="overview"
                  maxlength="400"></textarea>
    </div>

    <div class="form-group">
        <%--课程目录--%>
        <%--<label for="">课程目录</label>--%>

    </div>
    <div class="form-group">
        <label class="control-label">报名时间</label>
        <div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd"
             data-link-format="yyyy-mm-dd">
            <input class="form-control" size="16" type="text" value="" readonly>
            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label">开课时间</label>
        <div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd"
             data-link-format="yyyy-mm-dd">
            <input class="form-control" size="16" type="text" value="" readonly>
            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label">结束时间</label>
        <div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd"
             data-link-format="yyyy-mm-dd">
            <input class="form-control" size="16" type="text" value="" readonly>
            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        </div>
    </div>

    <div class="form-group">
        <label for="max-person">人数上限:</label>
        <input type="number" min="0" id="max-person" class="form-control" name="max-person">
    </div>

    <div class="form-group">
        <label for="type">课程分类:</label>
        <%--选框--%>
        <div class="btn-group" role="form">
            <div class="dropdown dropdown-select">
                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"
                        aria-expanded="true">
                    请选择类别
                    <span class="caret"></span>
                </button>
                <input type="hidden" name="type" value="" id="type" placeholder="你的浏览器版本太低">
                <ul class="dropdown-menu" role="menu" aria-labelledby="type">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">计算机</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">财经</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">心理学</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">外语</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">文学</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">设计</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="form-group">
        <%--课程图片--%>
        <label for="poster">上传课程海报</label>
        <input type="file" id="poster" name="poster">
    </div>
    <div class="form-group">
        <%--课程图片--%>
        <label for="source">上传课件</label>
        <input type="file" id="source" name="poster">
    </div>
    <div class="checkbox">
        <%--服务条款--%>
        <label>
            <input type="checkbox"> 我已阅读并接受<a href="#">使用条约</a>
        </label>
    </div>
    <button type="submit" class="btn btn-default" name="submit-btn" id="submit-btn">创建课程</button>
</form>
