package com.iamsajan.springbootredispostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootRedisPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisPostgresApplication.class, args);
	}

}
