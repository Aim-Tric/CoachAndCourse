<%--
  Created by IntelliJ IDEA.
  User: BK
  Date: 11/23/2018
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header.jsp" %>

<div class="container">
    <video controls class="col-md-12" id="#video"></video>
</div>
<script src="/common/js/utils/video.js"></script>
<script>
    var url = '/v/new.mp4';  // url
    var mimeCodec = 'video/mp4; codecs="avc1.640028, mp4a.40.2"'; // 编码格式
    display(url, mimeCodec);

</script>
<%@include file="../common/footer.jsp" %>