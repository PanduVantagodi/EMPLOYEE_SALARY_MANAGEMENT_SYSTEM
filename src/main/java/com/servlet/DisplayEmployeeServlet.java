package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.EmployeeDAO;

public class DisplayEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            EmployeeDAO dao = new EmployeeDAO();
            req.setAttribute("empList", dao.getAllEmployees());

            RequestDispatcher rd =
                    req.getRequestDispatcher("empdisplay.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}