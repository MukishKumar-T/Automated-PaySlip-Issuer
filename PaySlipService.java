package interfaces;

import exception.DatabaseException;
import exception.PaySlipGenerationException;

import java.sql.Connection;
import java.util.Scanner;

public interface PaySlipService {
    void generatePaySlip(Scanner sc, Connection con) throws DatabaseException, PaySlipGenerationException;
}
