package com.asimio.demo.config.dvdrental;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.asimio.dvdrental.model.Actor;

@Configuration
@EnableConfigurationProperties(JpaProperties.class)
public class MultiTenantJpaConfiguration {

	@Autowired
	private JpaProperties jpaProperties;

	@Autowired
	private MultiTenantConnectionProvider multiTenantConnectionProvider;

	@Autowired
	private CurrentTenantIdentifierResolver currentTenantIdentifierResolver;

	@Bean
	public List<LocalContainerEntityManagerFactoryBean> entityManagersFactory(Map<String, DataSource> dataSourcesDvdRental) {
		List<LocalContainerEntityManagerFactoryBean> result = new ArrayList<>();
		for (Map.Entry<String, DataSource> entry : dataSourcesDvdRental.entrySet()) {
			Map<String, Object> hibernateProps = new LinkedHashMap<>();
			hibernateProps.putAll(this.jpaProperties.getHibernateProperties(entry.getValue()));
			hibernateProps.put(Environment.MULTI_TENANT, MultiTenancyStrategy.DATABASE);
			hibernateProps.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, this.multiTenantConnectionProvider);
			hibernateProps.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, this.currentTenantIdentifierResolver);

			LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
			entityManager.setDataSource(entry.getValue());
			entityManager.setPackagesToScan(new String[] { Actor.class.getPackage().getName() });
			entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
			entityManager.setJpaPropertyMap(hibernateProps);
			result.add(entityManager);
		}
		return result;
	}
}