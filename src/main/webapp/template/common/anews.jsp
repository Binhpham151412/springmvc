<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/28/21
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>VinaENTER EDU - Đã học là làm được</title>
    <meta name="description" content="VinaENTER EDU đào tạo lập trình viên chuyên nghiệp - Đã học là làm được">
    <meta name="keywords" content="dao tao chuyên sâu lap trinh php, java">

    <c:url value="/template" var="contextPath" scope="application"></c:url>

    <link href="${contextPath}/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrapper">
    <tiles:insertAttribute name="header"></tiles:insertAttribute>

    <!-- end content -->
    <div id="content">
        <tiles:insertAttribute name="leftbar"></tiles:insertAttribute>
        <tiles:insertAttribute name="body"></tiles:insertAttribute>
    </div>
    <!-- end content -->
    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>
</html>