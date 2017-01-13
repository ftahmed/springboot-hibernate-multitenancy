package com.asimio.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(
	exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class },
	scanBasePackages = { "com.asimio.demo.config.dvdrental", "com.asimio.demo.rest" }
)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}