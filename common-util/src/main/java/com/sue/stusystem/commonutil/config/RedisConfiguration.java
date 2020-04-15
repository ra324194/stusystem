package com.sue.stusystem.commonutil.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:application.properties")
public class RedisConfiguration {
    @Value("${redis.host:192.168.56.10}")
    String host;
    @Value("${redis.port:6379}")
    int port;
    @Value("${redis.timeout:10000}")
    int timeout;


    @Bean
    public JedisPool JedisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setBlockWhenExhausted(true);
        jedisPoolConfig.setMaxIdle(200);
        jedisPoolConfig.setMinIdle(0);
        jedisPoolConfig.setMaxTotal(1024);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout);
        return jedisPool;


    }




}
