<%@ page import="com.springmvc.testmvc.model.BrandModel" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/07/2022
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th colspan="4">Brand</th>
    </tr>

    <tr style="color: red">
        <td>id</td>
        <td>name</td>
        <td>edit brand</td>
        <td>delete brand</td>
    </tr>



    <c:choose>
        <c:when test="${not empty listBrand}">
            <c:forEach var="brand" items="${listBrand}">
                <tr>
                    <td>${brand.id}</td>
                    <td>${brand.nameBrand}</td>
                    <td><a href="<%=request.getContextPath()%>/brand/edit/${brand.id}">Edit</a></td>
                    <td><a href="<%=request.getContextPath()%>/brand/delete/${brand.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
                <th>ko co gia tri</th>
        </c:otherwise>
    </c:choose>
</table>
<a href="<%=request.getContextPath()%>/brand/list">List Brand</a>
<br>
<a href="<%=request.getContextPath()%>/brand/add">Add Brand</a>
<br>
<a href="<%=request.getContextPath()%>/product/list">List Product</a>
</body>
</html>
