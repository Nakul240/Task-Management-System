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
	<div><h1>Enter your details</h1></div>
		<form action="register" method="post">
			
			UserName :<input type="text" name="user_name" required="required">
			<br>
			Email :<input type="email" name="email" required="required">
			<br>
			Password :<input type="password" name="password" required="required">
			<br>
			Role :<input type="radio" id="manager" name="role" value="manager" required>
    		<label for="manager">Manager</label>
    
    		<input type="radio" id="employee" name="role" value="employee" required>
   			<label for="employee">Employee</label>			
   			<br>
			Designation :<input type="text" name="designation" required="required">
			<br>
			Salary :<input type="number" name="salary" required="required">
			<br>
			<input type="submit" value="SUBMIT">
		</form>
	
	</div>
</body>
</html>