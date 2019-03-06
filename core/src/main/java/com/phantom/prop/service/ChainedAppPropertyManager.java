package com.phantom.prop.service;

import com.phantom.prop.templates.PropertyManagerSimple;

import java.util.List;

public class ChainedAppPropertyManager implements PropertyManagerSimple{

	List<PropertyManagerSimple> propertyManagers;

	
	public ChainedAppPropertyManager(
			List<PropertyManagerSimple> propertyManagers) {
		this.propertyManagers = propertyManagers;
	}


	@Override
	public String getProperty(String key) {
		
		for(PropertyManagerSimple propertyManager : propertyManagers)
		{
			String propertyValue = propertyManager.getProperty(key);
			if(propertyValue !=null)
				return propertyValue;
		}
		
		return null;
	}
	
	
	
}
