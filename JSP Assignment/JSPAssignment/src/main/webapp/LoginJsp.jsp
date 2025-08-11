<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user= request.getParameter("username");
	String pass= request.getParameter("password");
	
	if("admin".equals(user) && "wipro".equals(pass)){
		
		response.sendRedirect("Success.jsp");
	}
	else{
		response.sendRedirect("Fail.jsp");
	}
%>