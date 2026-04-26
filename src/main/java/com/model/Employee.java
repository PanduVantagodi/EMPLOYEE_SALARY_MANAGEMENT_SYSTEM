package com.model;

import java.sql.Date;

public class Employee {
    int empno;
    String empName;
    Date doj;
    String gender;
    double salary;

    public Employee(){}

    public Employee(int empno, String empName, Date doj, String gender, double salary){
        this.empno = empno;
        this.empName = empName;
        this.doj = doj;
        this.gender = gender;
        this.salary = salary;
    }

    public int getEmpno(){ return empno; }
    public String getEmpName(){ return empName; }
    public Date getDoj(){ return doj; }
    public String getGender(){ return gender; }
    public double getSalary(){ return salary; }
}