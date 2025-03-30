package interfaces;

import model.Employee;
import exception.DatabaseException;
import exception.InvalidInputException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public interface EmployeeService {
    void addEmployee(Scanner sc, Connection con) throws DatabaseException, InvalidInputException;
    void deleteEmployee(Scanner sc, Connection con) throws DatabaseException, SQLException;
}
