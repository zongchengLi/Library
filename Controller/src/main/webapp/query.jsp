<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/3/26
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"
         language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="query.css"/>
    <title>图书信息</title>
</head>
<body>
<div id="nav">
    <a href="index.jsp"><img src="photo_back.png" alt="back Index"/></a>
    <span id="head">图书信息</span>
</div>
<div id="bgImg">
    <div id="bg">
        <c:if test="${books.size()<1}">

        </c:if>
        <c:if test="${books.size()>0}">
            <table>
                <tr>
                    <td>ISBN</td>
                    <td>图书名称</td>
                    <td>出版社</td>
                    <td>作者</td>
                    <td>价格</td>
                    <td>简介</td>
                </tr>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.ISBN}</td>
                        <td>${book.name}</td>
                        <td>${book.publisher}</td>
                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.about}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>
