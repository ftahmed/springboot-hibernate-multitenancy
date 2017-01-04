package com.asimio.demo.config.dvdrental;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataSourceDvdRentalMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	private static final long serialVersionUID = 1L;

	@Autowired
	private List<DataSource> dataSourcesDvdRental;

	private Map<String, DataSource> mapDataSourcesDvdRental;

	@PostConstruct
	public void load() {
		this.mapDataSourcesDvdRental= new HashMap<>();
		int i = 1;
		for (DataSource ds : this.dataSourcesDvdRental) {
			this.mapDataSourcesDvdRental.put(String.format("tenant_%s", i++), ds);
		}
	}

	@Override
	protected DataSource selectAnyDataSource() {
		return this.mapDataSourcesDvdRental.get("tenant_1");
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		return this.mapDataSourcesDvdRental.get(tenantIdentifier);
	}
}