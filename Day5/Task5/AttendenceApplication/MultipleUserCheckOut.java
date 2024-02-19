package AttendenceApplication;
import redis.clients.jedis.Jedis;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

public class MultipleUserCheckOut extends Thread {
    private User user;
    private Jedis jedis;

    private MySQLCredentials credentials = new MySQLCredentials();

    public MultipleUserCheckOut(User user, Jedis jedis) {
        this.user = user;
        this.jedis = jedis;
    }

    @Override
    public synchronized void run() {

        try{
            MySQLConnection connection = new MySQLConnection();
            String checkoutTime = getCurrentTime();
            String hashKey = user.getUserId();
            HashMap<String, String> hmap = new HashMap<>();
            hmap.put("check-out",checkoutTime);
            String checkinTime = jedis.hget(hashKey,"check-in");



            if (checkinTime == null) {
                System.err.println("No check-in time found for User " + this.user.getUserId() + ". Please check in first.");
            }
            else {

                System.out.println("User " + user.getUserId() + " checked out at: " + checkoutTime);

//            long elapsedMilliseconds = getTimeDifference(checkinTime, checkoutTime);
//            long elapsedSeconds = elapsedMilliseconds / 1000;
//            long hours = elapsedSeconds / 3600;
                try {
                    System.out.println( connection.insertIntoDatabase(Queries.checkOutQuery(user.getUserId()),credentials));
                   jedis.hmset(hashKey,hmap);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

//            System.out.println("User " + user.getUserId() + " worked for: " + hours + " hours");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getCurrentTime() {
    	Date currentDate = new Date();
        return currentDate.toString();
    }

    private long getTimeDifference(String startTime, String endTime) {
        java.time.LocalDateTime startDateTime = java.time.LocalDateTime.parse(startTime);
        java.time.LocalDateTime endDateTime = java.time.LocalDateTime.parse(endTime);
        return java.time.Duration.between(startDateTime, endDateTime).toMillis();
    }
}

