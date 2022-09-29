<%@ page import="java.util.Map" %>
<%@ page import="member.MemberDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: songimyeong
  Date: 2022/09/23
  Time: 4:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
      function view(userid){
          document.form1.userid.value=userid;
          document.form1.submit();
      }
    </script>
</head>
<body>
<a href="/JspMall/member/form.jsp">추가</a>
<table border="1">
    <tr>
        <th>이름</th>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>가입일자</th>
        <th>주소</th>
        <th>전화</th>
    </tr>
    <%
        Map map = (Map)request.getAttribute("map");
        List<MemberDTO> items=(List)map.get("list");
        for(MemberDTO dto : items){
    %>
        <tr>
            <td><a href="#" onclick="view('<%=dto.getUserid()%>')"><%=dto.getName()%></a></td>
            <td><%=dto.getUserid()%></td>
            <td><%=dto.getPasswd()%></td>
            <td><%=dto.getReg_date()%></td>
            <td><%=dto.getAddress()%></td>
            <td><%=dto.getTel()%></td>
        </tr>
    <%
        }
    %>
</table>
<form name="form1" method="post" action="/JspMall/member_servlet/view.do">
    <input type="hidden" name="userid">
</form>
</body>
</html>
