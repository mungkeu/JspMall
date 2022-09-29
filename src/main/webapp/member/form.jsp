<%--
  Created by IntelliJ IDEA.
  User: songimyeong
  Date: 2022/09/24
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/JspMall/member_servlet/join.do" method="post">
    아이디 <input name="userid"><br>
    비번 <input type="password" name="passwd"><br>
    이름 <input name="name"><br>
    주소 <input name="address" size="50"><br>
    전호번호 <input name="tel"><br>
    <input type="submit" value="확인">
</form>
</body>
</html>
