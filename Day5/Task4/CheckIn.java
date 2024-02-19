import redis.clients.jedis.Jedis;
import java.util.Date;

public class CheckIn {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);

        Date currentDate = new Date();
        String checkinTime = currentDate.toString();

        jedis.set("checkin_time", checkinTime);

        System.out.println("Checked in at: " + checkinTime);

        jedis.close();
    }
}

/// sudo service redis-server stop

