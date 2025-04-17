package com.it.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String TEST_KEY = "test:demoKey";

    @BeforeEach
    void cleanup() {
        // 测试前清除历史数据
        redisTemplate.delete(TEST_KEY);
    }

    @Test
    void testSetAndGetValue() {
        // 设置键值
        redisTemplate.opsForValue().set(TEST_KEY, "Hello Redis");
        // 获取并验证
        String value = (String) redisTemplate.opsForValue().get(TEST_KEY);
        assertEquals("Hello Redis", value, "键值存储与读取结果不一致");
    }

    @Test
    void testExpireTime() throws InterruptedException {
        // 设置带过期时间的键值（30秒）
        redisTemplate.opsForValue().set(TEST_KEY, "Expiring Data", 30, TimeUnit.SECONDS);
        // 立即验证存在性
        assertTrue(redisTemplate.hasKey(TEST_KEY));
        // 验证剩余时间在合理范围内（此处需根据业务调整断言逻辑）
        Long expire = redisTemplate.getExpire(TEST_KEY);
        assertTrue(expire > 25 && expire <= 30);
    }
}