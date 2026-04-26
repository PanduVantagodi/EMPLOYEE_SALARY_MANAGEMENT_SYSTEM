package com.dao;

import java.sql.*;
import java.util.*;
import com.model.Employee;

public class EmployeeDAO {

    private Connection con;

    // ✅ DB Connection
    public EmployeeDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/EMPLOYEE_SALARY?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
            "root",
            "pandu@142"
        );
    }

    // ✅ Add Employee
    public void addEmployee(Employee e) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO Employee VALUES(?,?,?,?,?)");
        ps.setInt(1, e.getEmpno());
        ps.setString(2, e.getEmpName());
        ps.setDate(3, e.getDoj());
        ps.setString(4, e.getGender());
        ps.setDouble(5, e.getSalary());
        ps.executeUpdate();
        ps.close();
    }

    // ✅ Update Full Employee
    public void updateEmployee(Employee e) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE Employee SET EmpName=?, DOJ=?, Gender=?, Bsalary=? WHERE Empno=?");
        ps.setString(1, e.getEmpName());
        ps.setDate(2, e.getDoj());
        ps.setString(3, e.getGender());
        ps.setDouble(4, e.getSalary());
        ps.setInt(5, e.getEmpno());
        ps.executeUpdate();
        ps.close();
    }

    // ✅ Update Salary Only
    public void updateSalary(int empno, double salary) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE Employee SET Bsalary=? WHERE Empno=?");
        ps.setDouble(1, salary);
        ps.setInt(2, empno);
        ps.executeUpdate();
        ps.close();
    }

    // ✅ Delete Employee
    public void deleteEmployee(int empno) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM Employee WHERE Empno=?");
        ps.setInt(1, empno);
        ps.executeUpdate();
        ps.close();
    }

    // ✅ Display All Employees
    public List<Employee> getAllEmployees() throws Exception {
        List<Employee> list = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Employee");

        while (rs.next()) {
            list.add(new Employee(
                rs.getInt("Empno"),
                rs.getString("EmpName"),
                rs.getDate("DOJ"),
                rs.getString("Gender"),
                rs.getDouble("Bsalary")
            ));
        }

        rs.close();
        st.close();
        return list;
    }

    // ✅ Report: Starting Letter
    public List<Employee> reportByLetter(String letter) throws Exception {
        List<Employee> list = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Employee WHERE EmpName LIKE ?");
        ps.setString(1, letter + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Employee(
                rs.getInt("Empno"),
                rs.getString("EmpName"),
                rs.getDate("DOJ"),
                rs.getString("Gender"),
                rs.getDouble("Bsalary")
            ));
        }

        rs.close();
        ps.close();
        return list;
    }

    // ✅ Report: Salary Greater Than
    public List<Employee> reportBySalary(double salary) throws Exception {
        List<Employee> list = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Employee WHERE Bsalary > ?");
        ps.setDouble(1, salary);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Employee(
                rs.getInt("Empno"),
                rs.getString("EmpName"),
                rs.getDate("DOJ"),
                rs.getString("Gender"),
                rs.getDouble("Bsalary")
            ));
        }

        rs.close();
        ps.close();
        return list;
    }

    // ✅ Report: Years of Service
    public List<Employee> reportByYearsOfService(int years) throws Exception {
        List<Employee> list = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Employee WHERE TIMESTAMPDIFF(YEAR, DOJ, CURDATE()) >= ?");
        ps.setInt(1, years);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Employee(
                rs.getInt("Empno"),
                rs.getString("EmpName"),
                rs.getDate("DOJ"),
                rs.getString("Gender"),
                rs.getDouble("Bsalary")
            ));
        }

        rs.close();
        ps.close();
        return list;
    }
}