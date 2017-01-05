package com.asimio.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.asimio.demo.config.dvdrental.MultiTenantDvdRentalProperties;

@SpringBootApplication(
	exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class }, 
	scanBasePackages = { "com.asimio.demo.config", "com.asimio.demo.rest" }
)
@EntityScan(basePackages = { "com.asimio.dvdrentals.model" })
// @EnableJpaRepositories(basePackages = { "com.asimio.dvdrentals.dao" })
@EnableConfigurationProperties(MultiTenantDvdRentalProperties.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
