<%@ page import="java.util.*,com.model.Employee" %>
<html>
<head>
<title>Display Employees</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="header">Employee Salary Management System</div>

<div class="content">
<h2>Employee List</h2>

<table border="1">
<tr>
<th>EmpNo</th>
<th>Name</th>
<th>DOJ</th>
<th>Gender</th>
<th>Salary</th>
</tr>

<%
List<Employee> list =
    (List<Employee>)request.getAttribute("empList");

for(Employee e : list){
%>
<tr>
<td><%=e.getEmpno()%></td>
<td><%=e.getEmpName()%></td>
<td><%=e.getDoj()%></td>
<td><%=e.getGender()%></td>
<td><%=e.getSalary()%></td>
</tr>
<% } %>

</table>

<br>

<!-- ✅ Back Button -->
<a href="index.jsp" class="btn">Back</a>

</div>

</body>
</html>