package com.store.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.store*" })
@EntityScan("com.store*")
@EnableJpaRepositories("com.store*")
public class StoreSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreSqlApplication.class, args);
	}

}
