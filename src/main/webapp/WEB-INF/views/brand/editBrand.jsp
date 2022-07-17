<%@ page import="java.util.List" %>
<%@ page import="com.springmvc.testmvc.model.BrandModel" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 13/07/2022
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    BrandModel brandModel = (BrandModel) request.getAttribute("findByBrand");
%>
<form action="${pageContext.request.contextPath}/brand/edit/${id}" method="post">
    <lable>Name:</lable>
    <input type="text" name="nameBrand" value="<%=brandModel.getNameBrand()%>"><br>
    <input type="submit">
</form>
</body>
</html>
