package service;

import model.GSTRecord;
import exception.DatabaseException;
import interfaces.GSTRecordService;
import interfaces.GSTRecordService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GSTServiceImpl implements GSTRecordService {

    public void trackGST(Scanner sc, Connection con) throws DatabaseException {
        try {
            System.out.print("Enter Transaction Type (sale/purchase): ");
            String transactionType = sc.next();
            System.out.print("Enter Transaction Amount: ");
            double amount = sc.nextDouble();
            System.out.print("Enter GST Rate (%): ");
            double gstRate = sc.nextDouble();
            
            double gstAmount = amount * (gstRate / 100);
            
            String sql = "insert into gst (transactionDate, transactionType, amount, gstRate, gstAmount) values (CURDATE(), ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, transactionType);
            stmt.setDouble(2, amount);
            stmt.setDouble(3, gstRate);
            stmt.setDouble(4, gstAmount);
            
            stmt.executeUpdate();
            stmt.close();
            System.out.println("GST transaction recorded successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Error recording GST transaction.", e);
        }
    }
}
