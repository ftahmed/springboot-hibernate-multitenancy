package com.asimio.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asimio.demo.config.dvdrental.MultiTenantDvdRentalProperties;
import com.asimio.demo.config.dvdrental.MultiTenantDvdRentalProperties.DataSourceProperties;

@Configuration
public class DataSourcesConfiguration {

	@Bean(name = "dataSourcesDvdRental" )
	public Map<String, DataSource> dataSourcesDvdRental(MultiTenantDvdRentalProperties multiTenantDvdRentalProperties) {
		Map<String, DataSource> result = new HashMap<>();
		for (DataSourceProperties dsProperties : multiTenantDvdRentalProperties.getDataSources()) {
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