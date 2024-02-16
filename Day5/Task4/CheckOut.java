import redis.clients.jedis.Jedis;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckOut {


    public static long calculateWorkHours(Date currentDate, Date checkinDate){
    	 	long elapsedMilliseconds = currentDate.getTime() - checkinDate.getTime();
                long elapsedSeconds = elapsedMilliseconds / 1000;
                long hours = elapsedSeconds / 3600;
                return hours;
    
    }
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);

        Date currentDate = new Date();
        String checkoutTime = currentDate.toString();

        String checkinTime = jedis.get("checkin_time");

        if (checkinTime == null) {
            System.out.println("Error: No check-in time found. Please check in first.");
        } else {
            System.out.println("Checked out at: " + checkoutTime);

            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            try {
                Date checkinDate = dateFormat.parse(checkinTime);
                long totalWorkHours = calculateWorkHours(currentDate, checkinDate);
                System.out.println("Worked for: " + totalWorkHours + " hours");
                jedis.del("checkin_time");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        jedis.close();
    }
}

