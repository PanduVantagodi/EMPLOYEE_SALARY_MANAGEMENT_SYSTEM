<html>
<head>
<title>Update Employee</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="header">Employee Salary Management System</div>
<div class="nav">
    <a href="index.jsp">Home</a>
</div>

<div class="content">
<h2>Update Employee Salary</h2>

<form action="UpdateEmployeeServlet" method="post">
    Emp No:
    <input type="number" name="empno" required>

    New Salary:
    <input type="number" step="0.01" name="salary" required>

    <input type="submit" class="btn" value="Update Salary">
</form>

<br>

<!-- ✅ Back Button -->
<a href="index.jsp" class="btn">Back</a>

</div>

<div class="footer">© 2026 Employee Web Application</div>

</body>
</html>