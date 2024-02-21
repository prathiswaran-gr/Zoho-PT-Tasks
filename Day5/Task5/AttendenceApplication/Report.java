package AttendenceApplication;
import java.io.IOException;
import java.sql.SQLException;

public class Report {
    public static void generateReport() throws SQLException, IOException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        MySQLCredentials credentials = new MySQLCredentials();
        System.out.println(mySQLConnection.getReportFromDatabase(Queries.getReportFromAttendenceRelation(),credentials,4));
    }
}
