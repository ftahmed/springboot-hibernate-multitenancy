package com.asimio.demo.config.dvdrental;

import java.util.List;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "multitenancy.dvdrental")
public class MultitenancyDvdRentalProperties {

	@NestedConfigurationProperty
	private List<DataSourceProperties> dataSources;

	public List<DataSourceProperties> getDataSources() {
		return this.dataSources;
	}

	public void setDataSources(List<DataSourceProperties> dataSources) {
		this.dataSources = dataSources;
	}
}