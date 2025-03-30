package service;

import exception.DatabaseException;
import exception.PaySlipGenerationException;
import interfaces.PaySlipService;
import utility.SalaryUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PaySlipServiceImpl implements PaySlipService {

    @Override
    public void generatePaySlip(Scanner sc, Connection con) throws DatabaseException, PaySlipGenerationException {
        try {
            System.out.print("Enter Employee ID: ");
            int employeeId = sc.nextInt();
            System.out.print("Enter Month: ");
            String month = sc.next();
            System.out.print("Enter Year: ");
            int year = sc.nextInt();

            String sql = "select basicsalary from employees where employeeId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double basicSalary = rs.getDouble("basicSalary");
                double grossSalary = SalaryUtils.calculateGrossSalary(basicSalary, con);
                double deductions = SalaryUtils.calculateDeductions(basicSalary);
                double netSalary = grossSalary - deductions;

                String ssql = "insert into payslips (employeeId, month, year, grossSalary, netSalary, deductions) values (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt1 = con.prepareStatement(ssql);
                stmt1.setInt(1, employeeId);
                stmt1.setString(2, month);
                stmt1.setInt(3, year);
                stmt1.setDouble(4, grossSalary);
                stmt1.setDouble(5, netSalary);
                stmt1.setDouble(6, deductions);

                stmt1.executeUpdate();
                stmt1.close();
                System.out.println("Pay slip generated successfully.");
            } else {
                throw new PaySlipGenerationException("Employee not found for ID: " + employeeId);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new DatabaseException("Error generating pay slip.", e);
        }
    }
}
