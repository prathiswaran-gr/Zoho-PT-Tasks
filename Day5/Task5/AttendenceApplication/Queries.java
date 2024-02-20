package AttendenceApplication;

public class Queries {
    static String checkInQuery(){
        return "INSERT INTO Attendences (emp_id, emp_status, datetime_stamp) VALUES(?, 'check_in', now());";
    }
    static String checkOutQuery(){
        return "INSERT INTO Attendences (emp_id, emp_status, datetime_stamp) VALUES(?, 'check_out', now());";
    }
    static String getReportFromAttendenceRelation(){
        return "SELECT emp_id AS Employee_id, user_name AS Employee_name, emp_status AS Status, datetime_stamp AS Datetime FROM Attendences a JOIN Users u ON a.emp_id = u.user_id;";
    }

}
