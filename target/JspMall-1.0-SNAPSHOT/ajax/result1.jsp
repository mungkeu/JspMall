<%--
  Created by IntelliJ IDEA.
  User: songimyeong
  Date: 2022/09/29
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
int num=Integer.parseInt(request.getParameter("num"));
for(int i=1; i<=9; i++){
    out.println(num+"x"+i+"="+num*i+"<br>");
}
%>
</body>
</html>
