<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/3/26
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="save.css"/>
    <title>添加图书</title>
</head>
<body>
<div id="back">
    <a href="index.jsp"><img src="photo_back.png" alt="back Index"/></a>
</div>
<div id="bgImg">
    <form id="saveForm" action="proSave.jsp" method="post" accept-charset="UTF-8">
        <h1>图书信息</h1>
        <div class="table">
            <span>I S B N ：</span>
            <input name="ISBN" class="input" type="text" maxlength="18"/>
        </div>
        <div class="table">
            <span>图书名称：</span>
            <input name="name" class="input" type="text"/>
        </div>
        <div class="table">
            <span>出版社：</span>
            <input name="publisher" class="input" type="text"/>
        </div>
        <div class="table">
            <span>作者：</span>
            <input name="author" class="input" type="text"/>
        </div>
        <div class="table">
            <span>价格：</span>
            <input name="price" class="input" type="number" step="0.01"/>
        </div>
        <div class="table">
            <span>简介：</span>
            <input name="about" class="input" type="text"/>
        </div>
        <div class="table">
            <input id="btn" type="submit" value="提交"/>
            <p id="tips">
                <%
                    String msg = (String) request.getAttribute("msg");
                    if (msg == null) {
                        msg = "";
                    }
                %>
                <%=msg%>
            </p>
        </div>
    </form>
</div>

</body>
</html>
