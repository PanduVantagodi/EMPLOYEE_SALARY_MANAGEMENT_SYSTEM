<html>
<head>
<title>Delete Employee</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="header">Employee Salary Management System</div>
<div class="nav">
    <a href="index.jsp">Home</a>
</div>

<div class="content">
<h2>Delete Employee</h2>

<form action="DeleteEmployeeServlet" method="post">
    Emp No:
    <input type="number" name="empno" required>

    <input type="submit" class="btn" value="Delete Employee">
</form>

<br>

<!-- ✅ Back Button -->
<a href="index.jsp" class="btn">Back</a>

</div>

<div class="footer">© 2026 Employee Web Application</div>

</body>
</html>