<html>
<head>
<title>Add Employee</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="header">Employee Salary Management System</div>

<div class="content">
<h2>Add Employee</h2>

<form action="AddEmployeeServlet" method="post">
    Emp No:
    <input type="number" name="empno" required>

    Name:
    <input type="text" name="empname" required>

    DOJ:
    <input type="date" name="doj" required>

    Gender:
    <select name="gender">
        <option>Male</option>
        <option>Female</option>
    </select>

    Salary:
    <input type="number" step="0.01" name="salary" required>

    <input type="submit" class="btn" value="Add Employee">
</form>

<br>

<!-- ✅ Back Button -->
<a href="index.jsp" class="btn">Back</a>

</div>

<div class="footer">© 2026 Employee Web Application</div>

</body>
</html>