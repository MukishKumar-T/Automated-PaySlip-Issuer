package App;

import dbconnection.DatabaseConnection;
import exception.DatabaseException;
import exception.InvalidInputException;
import exception.PaySlipGenerationException;
import interfaces.EmployeeService;
import interfaces.PaySlipService;
import model.GSTRecord;
import interfaces.GSTRecordService;
import service.EmployeeServiceImpl;
import service.PaySlipServiceImpl;
import service.GSTServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DatabaseException, SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            System.out.println("Connected to the database.");

            EmployeeService employeeService = new EmployeeServiceImpl();
            PaySlipService paySlipService = new PaySlipServiceImpl();
            GSTRecordService gstService = new GSTServiceImpl();

            Scanner scanner = new Scanner(System.in);
            int choice;

            while (true) {
                System.out.println("\nEmployee Pay Slip and GST Tracking System");
                System.out.println("1. Add Employee");
                System.out.println("2. Remove Employee");
                System.out.println("3. Generate Pay Slip");
                System.out.println("4. Track GST Transactions");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                try {
                    switch (choice) {
                        case 1:
                            employeeService.addEmployee(scanner, con);
                            break;
                        case 2:
                        	employeeService.deleteEmployee(scanner, con);
                        	break;
                        case 3:
                            paySlipService.generatePaySlip(scanner, con);
                            break;
                        case 4:
                            gstService.trackGST(scanner, con);
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }
                } catch (DatabaseException | InvalidInputException | PaySlipGenerationException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
