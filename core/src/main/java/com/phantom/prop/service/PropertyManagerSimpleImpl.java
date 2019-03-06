package com.phantom.prop.service;

import com.phantom.logging.PhantomLogger;
import com.phantom.prop.templates.PropertyManagerSimple;
import com.phantom.util.IO;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManagerSimpleImpl implements PropertyManagerSimple {

	protected Properties properties;
	protected String propertyFileName;
	
    PhantomLogger logger = PhantomLogger.getLoggerObject(this.getClass());

	
	
	public PropertyManagerSimpleImpl(String propertyFileName ){
		logger.info("Property manager getting initialized. Property files - " + propertyFileName);
		this.propertyFileName = propertyFileName;
		loadProperties();
	}

	@Override
	public String getProperty(String key) {
		return properties != null ? properties.getProperty(key) : null;
	}
	
	protected void loadProperties()
	{
	    InputStream fileInputStream = null;
        try {
        	Properties propertiesTemp = new Properties();
        	fileInputStream = ClassLoader.getSystemResourceAsStream(propertyFileName);
            propertiesTemp.load(new ByteArrayInputStream(IO.readFileContent(propertyFileName).getBytes()));
            properties = propertiesTemp;
        } catch (FileNotFoundException e) {
            logger.error("Property file could not be found : ", e);
        } catch (IOException e) {
        	logger.error("Error in reading property file : ", e);
		} catch (Exception e) {
        	logger.error("Unknown Error in reading property file : ", e);
		}
        finally{
		    try {
		    	if(fileInputStream!=null)
		    		fileInputStream.close();
            } catch (IOException e) {
                logger.error("Error in reading property file : ", e);
            }
		}
	}


}
