<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"
        language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="index.css" />
    <title>Index</title>
</head>
<body>
<div id="bgImg">
    <div id="title">
        <h1>图书管理系统</h1>
    </div>
    <div id="inputDiv">
        <p>
            <a href="login.jsp">管理员登录</a>
        </p>
        <p>
            <a href="./admin/save.jsp">添加图书</a>
        </p>
        <p>
            <a href="query">查看所有图书</a>
        </p>
    </div>
    <div id="count">
        <span style="margin-right: 36px">
            当前在线人数：${applicationScope.onlineNumbers}
        </span>
        <span>
            历史访问人数：${applicationScope.historyNumbers}
        </span>
    </div>
</div>
</body>
</html>
