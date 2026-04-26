package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.dao.EmployeeDAO;
import com.model.Employee;

public class ReportCriteriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String type = req.getParameter("type");
            EmployeeDAO dao = new EmployeeDAO();
            List<Employee> list = null;

            if ("letter".equals(type)) {
                String letter = req.getParameter("letter");
                list = dao.reportByLetter(letter);

            } else if ("salary".equals(type)) {
                double sal = Double.parseDouble(req.getParameter("salary"));
                list = dao.reportBySalary(sal);

            } else if ("service".equals(type)) {
                int years = Integer.parseInt(req.getParameter("years"));
                list = dao.reportByYearsOfService(years);
            }

            req.setAttribute("reportList", list);
            RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}