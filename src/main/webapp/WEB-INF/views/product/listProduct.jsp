<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.springmvc.testmvc.model.ProductModel" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 14/07/2022
  Time: 8:30 PM
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
        <th colspan="6">LIST PRODUCT</th>
    </tr>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>brand_name</th>
        <th>createDate</th>
        <th>update</th>
        <th>delete</th>
    </tr>

    <%
        List<ProductModel> list = (List<ProductModel>) request.getAttribute("listProduct");
        if (list!=null){
            for (ProductModel item : list) {
    %>
    <tr>
        <td><%=item.getId()%></td>
        <td><%=item.getNameProduct()%></td>
        <td><%=item.getBrandModel().getNameBrand()%></td>
        <td><%=item.getCreateDate()%></td>
        <td><a href="<%=request.getContextPath()%>/product/update?id=<%=item.getId()%>">Update</a></td>
        <td><a href="<%=request.getContextPath()%>/product/delete?id=<%=item.getId()%>">Delete</a></td>
    </tr>
    <%
            }
        }
    %>
</table>
<a href="<%=request.getContextPath()%>/brand/list">List Brand</a>
<br>
<a href="<%=request.getContextPath()%>/brand/add">Add Brand</a>
<br>
<a href="<%=request.getContextPath()%>/product/add">Add Product</a>
</body>
</html>
