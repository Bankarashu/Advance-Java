<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
}

.nav {
	background: black;
	height: 50px;
	text-align: right;
}

.nav ul {
	display: flex;
	list-style: none;
	color: white;
	justify-content: space-evenly;
}

.nav ul li {
	width: 100px;
	padding: 15px;
}

.nav ul li a {
	text-decoration: none;
	color: white;
}
</style>
</head>
<body>
	<div class="nav">
		<ul>
			<li><a href="./home">Home</a></li>
			<li><a href="./add">AddStudent</a></li>
			<li><a href="./update">UpdateStudent</a></li>
			<li><a href="./search">SearchStudent</a></li>
			<li><a href="./delete">DeleteStudent</a></li>
			<li><a href="./logout">Logout</a></li>

		</ul>
	</div>
</body>
</html>