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
			<h1>Enter your details</h1>
		</div>
		<form action="login" method="post">

			Email :<input type="email" name="email" required="required">
			<br>
			 Password :<input type="password" name="password"
				required="required"> <br> <input type="submit"
				value="LOGIN">
		</form>

		<br>
		<h1>------------------OR---------------------</h1>
		<br>
		<h2>
			<a href="register.jsp">Register</a>
		</h2>
		
	</div>

</body>
</html>
