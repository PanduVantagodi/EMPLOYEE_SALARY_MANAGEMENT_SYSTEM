<%@ page import="java.util.*,com.model.Employee" %>
<html>
<head>
<title>Report Result</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="header">Employee Salary Management System</div>

<div class="content">
    <h2>Report Result</h2>

    <table border="1" width="100%" cellpadding="10">
        <tr>
            <th>Emp No</th>
            <th>Name</th>
            <th>DOJ</th>
            <th>Gender</th>
            <th>Salary</th>
        </tr>

        <%
        List<Employee> list = (List<Employee>)request.getAttribute("reportList");
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

    <div class="menu">
        <a href="reports.jsp">Back to Reports</a>
        <a href="index.jsp">Home</a>
    </div>
</div>

<div class="footer">© 2026 Employee Web Application</div>

</body>
</html>