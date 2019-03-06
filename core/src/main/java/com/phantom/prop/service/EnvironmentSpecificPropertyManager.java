package com.phantom.prop.service;


import com.phantom.logging.PhantomLogger;
import com.phantom.util.PhantomUtil;

/**
 * This subclass of reloadable property manager is expected to return values
 * only when it exists in the same environment where it is expected to be.
 * 
 * For example we can wire this proper manager in RFS ahead in property chain
 * This was we can override RFS specific properties like payment amount.
 * This property manger will be inactive in other environments.
 * 
 * @author nitin.goyal
 *
 */
public class EnvironmentSpecificPropertyManager extends
		ReloadableApplicationPropertyManager {

	private final boolean active;
    PhantomLogger logger = PhantomLogger.getLoggerObject(this.getClass());

	
	public EnvironmentSpecificPropertyManager(
			String propertyFileName,
			String currentEnvironment,
			String expectedEnvironment) {
		
		super(propertyFileName);
		
		if(!PhantomUtil.isNullOrEmpty(currentEnvironment) && !PhantomUtil.isNullOrEmpty(expectedEnvironment))
		{
			active = currentEnvironment.equalsIgnoreCase(expectedEnvironment);
		}
		else
			active = false;
		
		logger.info("Environment specific property manager is " + active +" for environment -" + currentEnvironment);
	}


	@Override
	public String getProperty(String key) {
		return active?super.getProperty(key):null;
	}
	
}
