package AttendenceApplication;
import redis.clients.jedis.Jedis;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

public class MultipleUserCheckIn extends Thread {
    private User user;
    private Jedis jedis;
    private MySQLCredentials credentials = new MySQLCredentials();

    public MultipleUserCheckIn(User user, Jedis jedis) {
        this.user = user;
        this.jedis = jedis;

    }

    @Override
    public synchronized void run() {
    	MySQLConnection connection = new MySQLConnection();
        String checkinTime = getCurrentTime();
        String hashKey = user.getUserId();
        HashMap<String, String> hmap = new HashMap< >();
        hmap.put("check-in",checkinTime);
        try {
            System.out.println(connection.insertIntoDatabase(Queries.checkInQuery(user.getUserId()),credentials));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jedis.hmset(hashKey,hmap);
        System.out.println("User " + user.getUserId() + " checked in at: " + getCurrentTime());
    }

    private String getCurrentTime() {
    	Date currentDate = new Date();
        return currentDate.toString();
    }
}

