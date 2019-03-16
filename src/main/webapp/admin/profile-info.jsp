<%@ page import="persistent.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Aim-Trick
  Date: 2019/3/1
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("CNC");
//    拿用户id查数据库，修改后才能拿到最新的信息
//    这个页面需要做的就是先发送查询个人信息的请求，展示在展现层，
//    点击修改替换成表单，修改完成发送信息和修改请求，更新数据库
%>
<div class="layui-card">
    <div class="layui-card-header"><h2>个人信息</h2></div>
    <div class="layui-card-body">
        <table>
            <tr>
                <td><h3 class="info-label">头像</h3></td>
                <td><img src="../common/img/thumbnail1.jpg" width="200" height="200" style="border-radius: 50%" alt=""></td>
            </tr>
            <tr>
                <td><h3 class="info-label">昵称</h3></td>
                <td><%=user.getNickname()%></td>
            </tr>
            <tr>
                <td><h3 class="info-label">性别</h3></td>
                <td><%=user.getSex()%></td>
            </tr>
            <tr>
                <td><h3 class="info-label">邮箱地址</h3></td>
                <td><%=user.getEmail()%></td>
            </tr>
            <tr>
                <td><h3 class="info-label">个性签名</h3></td>
                <td><%=user.getSignature() == null ? "此人很懒，什么都没留下" : user.getSignature()%></td>
            </tr>
        </table>
        <button type="button" id="update-info">修改信息</button>
    </div>
</div>

<script>
    $(function () {
        $("#update-info").on('click', function () {
            $(this).text() === "修改信息" ? update() : submitUpdate();
        });

        function update() {
            let $tr = $("tr");
            for(let i = 0; i<$tr.length; i++) {
                let input = $($tr[i]).children().last();
                if(i === 0) {
                    input.replaceWith("<input type='file' />")
                } else {
                    input.replaceWith("<input type='text' value='" + input.text() + "'/>")
                }
            }
            $("#update-info").text("提交修改");
        }

        function submitUpdate() {
            let string = ['avatar', 'nickname', 'sex', 'email', 'signature'];
            let $tr = $("tr");
            let formData = new FormData();
            for(let i = 0; i<$tr.length; i++) {
                let input = $($tr[i]).children().last();
                if (i === 0) {
                    formData.append(string[i], input[0].files[0]);
                } else {
                    formData.append(string[i], input.val());
                }
            }
            console.log(formData.get("sex"));
            $.ajax({
                url: "/application/servlet/userUpload",
                type: 'POST',
                cache: false,
                data: formData,
                processData: false,
                contentType: false,
            }).done(function(result) {
                console.log(result)
            }).fail(function(result) {
                console.log(result)
            });
            $("#update-info").text("修改信息");
        }

    })
</script>
