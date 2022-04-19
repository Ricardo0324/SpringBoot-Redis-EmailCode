package com.wyq.emailcode;

import com.wyq.emailcode.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class EmailcodeApplicationTests {

    //自动注入redisTemplate
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //获取redis数据库连接对象
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisConnection connection = connectionFactory.getConnection();

        User user=new User("李四",3);
        redisTemplate.opsForValue().set("lisi",user);

        // 往Redis服务端中设置一个String类型的key，值为zhangsan
        //redisTemplate.opsForValue().set("name","zhangsan");
        // 获取并打印这个key的值
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

}
