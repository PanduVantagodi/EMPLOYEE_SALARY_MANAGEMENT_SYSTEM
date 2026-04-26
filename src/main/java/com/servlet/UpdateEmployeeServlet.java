package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.dao.EmployeeDAO;

public class UpdateEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            int empno = Integer.parseInt(req.getParameter("empno"));
            double salary = Double.parseDouble(req.getParameter("salary"));

            EmployeeDAO dao = new EmployeeDAO();
            dao.updateSalary(empno, salary);

            res.sendRedirect("index.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}