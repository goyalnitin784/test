package com.phantom.prop.service;

import com.phantom.prop.change.ReloadableProperty;

import java.io.File;

/**
 * An implementation of property manager that is reloadable as well
 * Reads properties from a configured property file
 * 
 * Note:Instances of this class are configured through conventional spring config files
 * 
 * @author nitin.goyal
 *
 */
public class ReloadableApplicationPropertyManager extends PropertyManagerSimpleImpl 
			implements ReloadableProperty {
	

	public ReloadableApplicationPropertyManager(String propertyFileName ){
		super(propertyFileName);
	}
	
	@Override
	public void reload() {
		logger.info("Application properties reload requested");
		loadProperties();
	}

	@Override
	public String getPropertyFileName() {
		return	new File(propertyFileName).getName();
	}

	@Override
	public String getPropertyFilePath() {
		return propertyFileName;
	}
}
