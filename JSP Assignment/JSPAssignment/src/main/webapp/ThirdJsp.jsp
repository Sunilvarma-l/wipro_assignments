<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String name = request.getParameter("name");
    String password = request.getParameter("password");

    session.setAttribute("name", name);
    session.setAttribute("password", password);
%>
<html>
<body>
    <h2>Stored successfully!</h2>
    <a href="SecondJsp.jsp">Click here to view session data</a>
</body>
</html>