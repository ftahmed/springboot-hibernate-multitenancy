package com.asimio.demo.config.dvdrental;

import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class DvdRentalDataSourceMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Map<String, DataSource> dataSourcesDvdRental;

	@Override
	protected DataSource selectAnyDataSource() {
		return this.dataSourcesDvdRental.values().iterator().next();
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		return this.dataSourcesDvdRental.get(tenantIdentifier);
	}
}