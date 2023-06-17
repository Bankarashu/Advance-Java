<%@page import="java.util.List"%>
<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Nav.jsp" />
<% StudentPOJO pojo = (StudentPOJO) request.getAttribute("student");
String msg = (String) request.getAttribute("msg");
List<StudentPOJO> studentPOJOs = (List<StudentPOJO>) request.getAttribute("student1");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="./update" method="post">
			<fieldset>
				<legend>Student Details</legend>

				<table>
					<tr>
						<td>Id</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td><input type="text" name="mobile"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"></td>
					</tr>

				</table>
			</fieldset>

			<input type="submit" value="UPDATE">

		</form>
		
		<% if(msg != null){ %>
		<h2><%= msg %></h2>
		<%} %>
		
		<% if(studentPOJOs != null){ %>
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Address</th>
			</tr>
			<% for(StudentPOJO student :studentPOJOs ){%>
			
			<tr>
				<td><%= student.getId() %></td>
				<td><%= student.getName() %></td>
				<td><%= student.getEmail()%></td>
				<td><%= student.getMobile() %></td>
				<td><%= student.getAddress() %></td>

			</tr>
			<%} %>

		</table>
		<%} %>
		
	</div>
</body>
</html>