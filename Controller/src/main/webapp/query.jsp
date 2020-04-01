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
    <link rel="stylesheet" href="query.css" />
    <title>图书信息</title>
</head>
<body>
<div id="nav">
    <a id="aImg" href="index.jsp"><img src="photo_back.png" alt="back Index" /></a>
    <span id="head">图书信息</span>
</div>
<div id="bgImg">
    <div id="bg">
        <c:if test="${requestScope.books==null}">
            当前没有图书信息！
        </c:if>
        <c:if test="${requestScope.books!=null}">
            <table>
                <tr>
                    <td>ISBN</td>
                    <td>图书名称</td>
                    <td>出版社</td>
                    <td>作者</td>
                    <td style="width: 32px">价格</td>
                    <td>简介</td>
                    <td style="width: 32px">操作</td>
                </tr>
                <c:forEach items="${requestScope.books}" var="book">
                    <tr>
                        <td>${book.ISBN}</td>
                        <td>${book.name}</td>
                        <td>${book.publisher}</td>
                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.about}</td>
                        <td>
                            <a class="operate" href="edit?ISBN=${book.ISBN}">修改</a>
                            <br />
                            <a class="operate" href="delete?ISBN=${book.ISBN}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>
