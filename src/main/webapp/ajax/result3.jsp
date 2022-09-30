<%@ page import="keyword.KeywordDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: songimyeong
  Date: 2022/09/30
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    KeywordDAO dao = new KeywordDAO();
    String keyword = request.getParameter("search"); // 검색 키워드
    List<String> items = dao.list(keyword); // 검색한 리스트를 가져온다.
    for(String str:items){
        out.println(str+"<br>");
    }
%>
</body>
</html>
