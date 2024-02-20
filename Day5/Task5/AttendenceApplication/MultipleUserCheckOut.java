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

                try {
                    System.out.println( connection.insertIntoDatabase(Queries.checkOutQuery(),credentials,user.getUserId()));
                    jedis.hmset(hashKey,hmap);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            jedis.close();
        }
    }

    private String getCurrentTime() {
    	Date currentDate = new Date();
        return currentDate.toString();
    }

}

