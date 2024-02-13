<%@page import="com.ff.tms.entity.Employee"%>
<%@page import="java.util.List"%>
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
			<h1>Enter Task details</h1>
		</div>
		<form action="savetask" method="post">

			Description :<input type="text" name="description" required="required">
			<br>
			Assign Employee :<select id="selectOption" name="getEmployee">
							<option disabled selected value="">Select an Employee</option>
							<%List<Employee> employees = (List<Employee>)request.getAttribute("list");
								for(Employee emp : employees){
									
									String name = emp.getName();
									int id = emp.getId();
							%>
									<option value="<%= id %>"><%= name %></option>
							<%
								}
							%>
 							 </select>
 			<br>			 
 		 	Status : <input type="radio" id="assigned" name="status" value="assigned" required>
    		<label for="assigned">Assigned</label>
    
    		<input type="radio" id="completed" name="status" value="completed" required>
   			<label for="completed">Completed</label>			
   			<br>
   			<input type="submit" value="Save">
		</form>

		<br>
		
		<%@include file="display.jsp" %>
	</div>

</body>

</html>