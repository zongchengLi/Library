<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/4/1
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>

<html>
<head>
    <meta http-equiv="refresh" content="10;url=index.jsp">
    <link rel="stylesheet" href="feedback.css">
    <title>
        <%=request.getAttribute("title")%>
    </title>
</head>
<body>

<div id="bgImg">
    <div id="bg">
        <div>
            <span id="span1"><%=request.getAttribute("msg")%></span>
        </div>
        <span id="span2"><span class="clock">10</span>秒后，将返回主页...</span>
    </div>

</div>
<script>
    var t = 10;
    var time = document.getElementsByClassName("clock")[0];

    function fun() {
        t--;
        time.innerHTML = t;
        if (t <= 0) {
            clearInterval(inter);
        }
    }

    var inter = setInterval("fun()", 1000);
</script>
</body>
</html>
