<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="req02">跳转到req02，获得request常见方法</a>
<form method="post" action="req01">
    姓名：<input type="text" name="uname"><br>
    密码：<input type="password" name="pwd"><br>
    <button>登录</button>
</form>
</body>
</html>