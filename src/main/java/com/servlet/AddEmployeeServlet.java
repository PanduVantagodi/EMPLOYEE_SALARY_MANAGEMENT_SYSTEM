package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
import com.dao.EmployeeDAO;
import com.model.Employee;

public class AddEmployeeServlet extends HttpServlet{
protected void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {

    try{
        Employee e = new Employee(
            Integer.parseInt(req.getParameter("empno")),
            req.getParameter("empname"),
            Date.valueOf(req.getParameter("doj")),
            req.getParameter("gender"),
            Double.parseDouble(req.getParameter("salary"))
        );

        new EmployeeDAO().addEmployee(e);
        res.sendRedirect("index.jsp");

    }catch(Exception ex){ ex.printStackTrace(); }
}
}