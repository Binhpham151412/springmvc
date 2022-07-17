<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 15/06/2022
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${ err != null}">
    <p style="color:red;">THeme thaast bai</p>
</c:if>
<form action="${pageContext.request.contextPath}/brand/add" method="post">
    <lable>Name:</lable>
    <input type="text" name="nameBrand"><br>
    <input type="submit">
</form>
</body>
</html>
