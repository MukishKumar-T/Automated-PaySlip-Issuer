package service;

import model.Employee;
import exception.DatabaseException;
import exception.InvalidInputException;
import interfaces.EmployeeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void addEmployee(Scanner sc, Connection con) throws DatabaseException, InvalidInputException {
        try {
            System.out.print("Enter Employee Name: ");
            String name = sc.next();
            if (name.isEmpty()) {
                throw new InvalidInputException("Employee name cannot be empty.");
            }

            System.out.print("Enter Designation: ");
            String designation = sc.next();
            System.out.print("Enter Basic Salary: ");
            double basicSalary = sc.nextDouble();

            String sql = "insert into employees (employeeName, designation, basicSalary) values (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, designation);
            stmt.setDouble(3, basicSalary);

            stmt.executeUpdate();
            stmt.close();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Error adding employee to the database.", e);
        }
    }

    @Override
    public void deleteEmployee(Scanner sc, Connection con) throws DatabaseException, SQLException {
        try{
        	System.out.print("Enter Employee Id: ");
        	int eid = sc.nextInt();
        	String sql = "delete from employees where employeeId = ?";
        	PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, eid);
            int r = stmt.executeUpdate();
            if(r > 0) {
            	System.out.println("Deletion Successful!");
            }
        }
        catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
    }
}
