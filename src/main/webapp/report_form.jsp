<%
String type = request.getParameter("type");
if(type == null) type="";
%>

<html>
<head>
<title>Report Input</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="header">Employee Salary Management System</div>

<div class="content">
    <h2>Enter Report Criteria</h2>

    <form action="ReportCriteriaServlet" method="post">
        <input type="hidden" name="type" value="<%=type%>">

        <% if(type.equals("letter")){ %>
            Enter Starting Letter:
            <input type="text" name="letter" required>
        <% } else if(type.equals("salary")){ %>
            Enter Salary:
            <input type="number" name="salary" required>
        <% } else if(type.equals("service")){ %>
            Enter Years of Service:
            <input type="number" name="years" required>
        <% } %>

        <input type="submit" class="btn" value="Generate Report">
    </form>

    <div class="menu">
        <a href="reports.jsp">Back</a>
    </div>
</div>

<div class="footer">© 2026 Employee Web Application</div>

</body>
</html>