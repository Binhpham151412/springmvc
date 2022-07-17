<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/28/21
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- begin header -->
<div id="header">
    <div class="header-left fl">
        <a href="index.php" title=""><img src="${contextPath}/images/logo_edu.png" alt="" height="128px" /></a>
    </div>
    <div class="header-right fr">
        <a href="index.php" title=""><img src="${contextPath}/images/banner.jpg" alt="" /></a>
    </div>
    <div class="clr"></div>
</div>
<!-- end header -->

<!-- begin menu -->
<div id="menu">
    <ul>
        <li id="trnag-chu" class=""><a href="${pageContext.request.contextPath}/index" title="">Trang chủ</a></li>
        <li id="them-bai-viet" class=""><a href="${pageContext.request.contextPath}/new/add" title="">Thêm bài viết</a></li>
        <%--        <li class=""><a href="${pageContext.request.contextPath}/contact" title="">Liên hệ</a></li>--%>
    </ul>
    <div class="clr"></div>
</div>
<!-- end menu -->
