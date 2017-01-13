package com.asimio.demo.config.dvdrental;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class TenantDvdRentalIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

	private static String DEFAULT_TENANT_ID = "tenant_1";

	@Override
	public String resolveCurrentTenantIdentifier() {
		String currentTenantId = DvdRentalTenantContext.getTenantId();
		return (currentTenantId != null) ? currentTenantId : DEFAULT_TENANT_ID;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}
}