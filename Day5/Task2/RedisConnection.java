import redis.clients.jedis.Jedis;

public class RedisConnection {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("key", "value");
        String value = jedis.get("key");
        System.out.println(value);
        jedis.close();
    }
}
