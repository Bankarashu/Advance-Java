<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.sendRedirect("https://www.google.com/"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!List<Integer> list = new ArrayList();%>

	<%
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
	%>

	<h1>
		<%=list%>
	</h1>

</body>
</html>