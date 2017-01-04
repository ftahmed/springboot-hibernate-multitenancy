package com.asimio.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asimio.demo.config.dvdrental.MultitenancyDvdRentalProperties;
import com.asimio.demo.config.dvdrental.MultitenancyDvdRentalProperties.DataSourceProperties;

@Configuration
public class DataSourcesConfiguration {

	@Autowired
	private MultitenancyDvdRentalProperties multitenancyDvdRentalProperties;

	@Bean(name = "dataSourcesDvdRental" )
	@ConfigurationProperties(prefix = "multitenancy.dvdrental")
	public Map<String, DataSource> dataSourcesDvdRental() {
		Map<String, DataSource> result = new HashMap<>();
		for (DataSourceProperties dsProperties : this.multitenancyDvdRentalProperties.getDataSources()) {
			DataSourceBuilder factory = DataSourceBuilder
				.create()
				.url(dsProperties.getUrl())
				.username(dsProperties.getUsername())
				.password(dsProperties.getPassword())
				.driverClassName(dsProperties.getDriverClassName());
			result.put(dsProperties.getTenantId(), factory.build());
		}
		return result;
	}
}