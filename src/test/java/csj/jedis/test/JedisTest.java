package csj.jedis.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp(){
        jedis=new Jedis("127.0.0.1",6379);
        jedis.select(0);
    }

    @Test
    void testString(){
        String result=jedis.set("name","zs");
        System.out.println("result="+result);

        String name = jedis.get("name");
        System.out.println("name = "+name);
    }

    @Test
    void testHash() {
        //插入hash数据
        jedis.hset("user:1","name","Jack");
        jedis.hset("user:1","age","21");

        Map<String,String> map=jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @AfterEach
    void tearDown(){
        if(jedis!=null)
            jedis.close();
    }

}
