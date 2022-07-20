<%@ page import="com.springmvc.testmvc.model.BrandModel" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 15/07/2022
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/product/add" method="post" enctype="multipart/form-data">
    <lable>name:</lable>
    <input type="text" name="name"><br>
    <lable>createDate:</lable>
    <input type="date" name="date"><br>
    <lable>brand:</lable>
    <select name="brand_id">
        <% for (BrandModel item : (ArrayList<BrandModel>) request.getAttribute("listBrand"))
        {
        %>
        <option value="<%=item.getId()%>"><%=item.getNameBrand()%>
        </option>
        <%
            }
        %>
    </select>
    <br>
    <input type="file" name="image" multiple = multiple >
    <br>
    <input type="submit">
</form>
</body>
</html>
