package AttendenceApplication;

public class Queries {
    static String checkInQuery(String id){
        return "INSERT INTO Attendences (emp_id, emp_status, datetime_stamp) VALUES('"+id+"', 'check_in', now());";
    }
    static String checkOutQuery(String id){
        return "INSERT INTO Attendences (emp_id, emp_status, datetime_stamp) VALUES('"+id+"', 'check_out', now());";
    }
    static String getReportFromAttendenceRelation(){
        return "SELECT * FROM Attendences";
    }

}
