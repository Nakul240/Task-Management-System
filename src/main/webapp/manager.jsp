<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.box {
	width: 800px;
	height: 400px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: center;
}

form {
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: center;
}
</style>
</head>
<body>

	<div class="box">
		<div>
			<h1>WELCOME TO MANAGER DASHBOARD</h1>
		</div>
		<a href="taskcreation">CREATE TASK</a>
		<br>
		<a href="viewtask">VIEW TASKS</a>
	</div>

</body>
</html>