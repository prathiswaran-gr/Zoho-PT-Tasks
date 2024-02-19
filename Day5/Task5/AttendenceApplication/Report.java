package AttendenceApplication;
import java.io.IOException;
import java.sql.SQLException;

public class Report {
    public static void main(String[] args) throws IOException, SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        MySQLCredentials credentials = new MySQLCredentials();
        System.out.println(mySQLConnection.getReportFromDatabase(Queries.getReportFromAttendenceRelation(),credentials,4));
    }
}
