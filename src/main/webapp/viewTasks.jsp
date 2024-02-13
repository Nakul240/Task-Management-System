<%@page import="com.ff.tms.entity.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>

	<h2>Task Table</h2>

	<table>
		<thead>
			<tr>
				<th>Task ID</th>
				<th>Description</th>
				<th>Employee</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Task> tasks = (List<Task>) request.getAttribute("tasks");
			for (Task task : tasks) {
				int id = task.getId();
				String description = task.getDescription();
				String employee = task.getEmployee().getName();
				String status = task.getStatus();
			%>
			<tr>
				<td><%=id %></td>
				<td><%=description%></td>
				<td><%=employee %></td>
				<td><%=status %></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>

</body>
</html>