<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/4/2
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="login.css" />
    <title>管理员登录</title>
</head>
<body>
<div id="bgImg">
    <form id="loginForm" action="login" method="post">
        <h1>Login</h1>
        <div class="input">
            <span class="title">UserName:</span>
            <input id="name" type="text" name="name" maxlength="10" autocomplete="off" />
        </div>
        <div class="input">
            <span class="title" id="psdTitle">PassWord:</span>
            <input id="psd" type="password" name="psd" maxlength="10" autocomplete="off" />
        </div>
        <div id="divBtn">
            <input id="btn" type="submit" value="login" />
        </div>
        <%--<div id="reg">
            Don't have account?&nbsp;&nbsp;<a href="register.jsp">Sign up</a>
        </div>--%>
    </form>

</div>
</body>
</html>
