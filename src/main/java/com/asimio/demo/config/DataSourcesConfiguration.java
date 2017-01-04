package com.asimio.demo.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asimio.demo.config.dvdrental.MultitenancyDvdRentalProperties;

@Configuration
public class DataSourcesConfiguration {

	@Autowired
	private MultitenancyDvdRentalProperties multitenancyDvdRentalProperties;

	@Bean(name = "dataSourcesDvdRental" )
	@ConfigurationProperties(prefix = "multitenancy.dvdrental")
	public List<DataSource> dataSourcesDvdRental() {
		List<DataSource> result = new ArrayList<>();
		for (DataSourceProperties dsProperties : this.multitenancyDvdRentalProperties.getDataSources()) {
			DataSourceBuilder factory = DataSourceBuilder
				.create()
				.url(dsProperties.getUrl())
				.username(dsProperties.getUsername())
				.password(dsProperties.getPassword())
				.driverClassName(dsProperties.getDriverClassName());
			result.add(factory.build());
		}
		return result;
	}
}