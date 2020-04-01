<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/3/27
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>修改后图书信息提交</title>
</head>
<body>
<jsp:useBean id="book" class="cheng.database.Book" scope="request" />
<jsp:setProperty name="book" property="ISBN" param="ISBN" />
<jsp:setProperty name="book" property="name" param="name" />
<jsp:setProperty name="book" property="publisher" param="publisher" />
<jsp:setProperty name="book" property="author" param="author" />
<jsp:setProperty name="book" property="price" param="price" />
<jsp:setProperty name="book" property="about" param="about" />
<jsp:forward page="/update" />
</body>
</html>
