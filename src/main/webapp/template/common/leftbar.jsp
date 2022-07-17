<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/28/21
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-left fl">
    <h3>Danh mục tin</h3>
    <ul>
        <c:choose>
            <c:when test="${not empty listCat}">
                <c:forEach items="${listCat}" var="cat">
                    <li><a href="${pageContext.request.contextPath}/cat/${cat.id}" title="">${cat.name}</a></li>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <li>
                    <p>Không có danh mục nào</p>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>