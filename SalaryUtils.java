package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryUtils {

    public static double calculateGrossSalary(double basicSalary, Connection con) throws SQLException {
        String fetchComponentsSql = "SELECT amount FROM salarycomponents";
        PreparedStatement stmt = con.prepareStatement(fetchComponentsSql);
        ResultSet rs = stmt.executeQuery();
        double totalAllowances = 0.0;
        
        while (rs.next()) {
            totalAllowances += rs.getDouble("amount");
        }
        
        return basicSalary + totalAllowances;
    }

    public static double calculateDeductions(double basicSalary) {
        return basicSalary * 0.1;  
    }
}
