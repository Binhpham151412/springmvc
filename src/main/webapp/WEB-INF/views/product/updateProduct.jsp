<%@ page import="com.springmvc.testmvc.model.ProductModel" %>
<%@ page import="com.springmvc.testmvc.model.BrandModel" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 15/07/2022
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>CHỈNH SỬA SẢN PHẨM <%=request.getAttribute("nameOld")%></h2>
<%
    ProductModel productModel = (ProductModel) request.getAttribute("findOneProduct");
%>
<form action="${pageContext.request.contextPath}/product/update?id=<%=productModel.getId()%>"method="post" enctype="multipart/form-data">
    <lable>name:</lable>
    <input type="text" value="<%=productModel.getNameProduct()%>" name="newName"><br>
    <lable>createDate:</lable>
    <input type="date" value="<%=productModel.getCreateDate()%>" name="newCreateDate"><br>
    <lable>brand:</lable>
    <select name="newBrand">
        <% for (BrandModel item : (ArrayList<BrandModel>) request.getAttribute("listBrand"))
        {
            if (item.getId() ==  productModel.getBrandModel().getId()){
        %>
        <option value="<%=item.getId()%>" selected><%=item.getNameBrand()%></option>
        <%
        }else {
        %>
        <option value="<%=item.getId()%>"><%=item.getNameBrand()%></option>
        <%
                }
            }
        %>
    </select>
    <input type="file" name="image" multiple = multiple>
    <br>
    <input type="submit">
</form>
</body>
</html>
