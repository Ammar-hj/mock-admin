package com.platform.mocklearn.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.platform.mocklearn.model.request.HttpInterfaceReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Autowired
    private LettuceConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String, HttpInterfaceReq> httpInterfaceRedisTemplate() {
        RedisTemplate<String, HttpInterfaceReq> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setDefaultSerializer(new FastJsonRedisSerializer<>(String.class));
        redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(HttpInterfaceReq.class));
        return redisTemplate;
    }
}
