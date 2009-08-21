package org.openmrs.module.interceptorexample;

import org.junit.Test;
import org.openmrs.GlobalProperty;
import org.openmrs.api.context.Context;
import org.openmrs.test.BaseModuleContextSensitiveTest;

/**
 * A unit test for the global interceptor
 */
public class InterceptorTest extends BaseModuleContextSensitiveTest {
	
	@Test
	public void shouldLogInterceptor() {
		
		GlobalProperty gp = new GlobalProperty("test", "test");
		Context.getAdministrationService().saveGlobalProperty(gp);
		
	}
}
