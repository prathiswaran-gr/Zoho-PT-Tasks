package AttendenceApplication;

import java.sql.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;


public class MySQLConnection {
    private Connection connection;
     private PreparedStatement statement;
     private ResultSet resultSet;
     private FileOutputStream fileOut;
     private  HSSFWorkbook workbook;



    public String insertIntoDatabase(String query, MySQLCredentials credentials, String userId) throws SQLException {
        try {
            connection = DriverManager.getConnection(credentials.getUrl(), credentials.getUsername(), credentials.getPassword());
            statement = connection.prepareStatement(query);
            statement.setString(1,userId);
            statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            connection.close();
            statement.close();
        }
        return "Rows affected!!";
    }

    public String getReportFromDatabase(String query, MySQLCredentials credentials, int maximumNumberOfColumns) throws SQLException, IOException {
        try {
            String fileName = "report.xlsx";
            int rowIndex = 0;
            workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("zoho-checkin-checkout");
            HSSFRow rowhead = sheet.createRow((short)rowIndex++);
            rowhead.createCell(0).setCellValue("id");
            rowhead.createCell(1).setCellValue("name");
            rowhead.createCell(2).setCellValue("status");
            rowhead.createCell(3).setCellValue("timestamp");
            connection = DriverManager.getConnection(credentials.getUrl(), credentials.getUsername(), credentials.getPassword());
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                HSSFRow row = sheet.createRow((short)rowIndex++); // To create new rows
                for (int colIndex = 1; colIndex <= maximumNumberOfColumns; colIndex++) {
                    row.createCell(colIndex-1).setCellValue(resultSet.getString(colIndex));
                }
            }
            fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
            statement.close();
            resultSet.close();
            fileOut.close();
            workbook.close();
        }
        return "Excel file has been generated successfully.";
    }

}
