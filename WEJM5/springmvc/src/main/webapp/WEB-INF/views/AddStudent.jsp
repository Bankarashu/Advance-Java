<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Nav.jsp" />
<% StudentPOJO pojo = (StudentPOJO)request.getAttribute("student");

String msg = (String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<div align="center">
		<form action="./add" method="post">
			<fieldset>
				<legend >Student Details</legend>

				<table>
					<tr>
						<td>Name</td>
						<td> <input type="text" name="name"> </td>
					</tr>
					<tr>
						<td>Email</td>
						<td> <input type="text" name="email"> </td>
					</tr>
		 			<tr>
						<td>Mobile</td>
						<td> <input type="text" name="mobile"> </td>
					</tr>
					<tr>
						<td>Address</td>
						<td> <input type="text" name="address"> </td>
					</tr>

				</table>
			</fieldset>
			
			<input type="submit" value="ADD">

		</form>
		
	<% 
	if(msg != null){%>
	<h4><%= msg %></h4>
	
	<%} %>
	</div>
</body>
</html>