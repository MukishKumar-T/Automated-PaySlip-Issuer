package interfaces;

import model.GSTRecord;
import exception.DatabaseException;

import java.sql.Connection;
import java.util.Scanner;

public interface GSTRecordService {
    void trackGST(Scanner sc, Connection con) throws DatabaseException;
}
