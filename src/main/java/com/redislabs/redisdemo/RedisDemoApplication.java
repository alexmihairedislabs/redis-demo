package com.redislabs.redisdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class RedisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}

	@Bean
	public LettuceConnectionFactory redisConnectionFactory(
			@Value("${redis.host}") String redisHost,
			@Value("${redis.port}") int redisPort,
			@Value("${redis.password}") String redisPassword
	) {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
				redisHost,
				redisPort
		);
		redisStandaloneConfiguration.setPassword(redisPassword);

		return new LettuceConnectionFactory(redisStandaloneConfiguration);
	}
}
