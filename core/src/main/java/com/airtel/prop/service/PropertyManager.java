package com.airtel.prop.service;

import com.airtel.exception.CustomException;
import com.airtel.logging.MyLogger;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Properties;

public class PropertyManager {

    protected Properties properties;
    protected String propertyFileName;

    MyLogger logger = MyLogger.getLoggerObject(this.getClass());


    public PropertyManager(String propertyFileName) {
        logger.info("Property manager getting initialized. Property files - " + propertyFileName);
        this.propertyFileName = propertyFileName;
        loadProperties();
    }

    public String getProperty(String key) {
        return properties != null ? properties.getProperty(key) : null;
    }

    protected void loadProperties() {
        InputStream fileInputStream = null;
        try {
            Properties propertiesTemp = new Properties();
            fileInputStream = ClassLoader.getSystemResourceAsStream(propertyFileName);
            propertiesTemp.load(new ByteArrayInputStream(readFileContent(propertyFileName).getBytes()));
            properties = propertiesTemp;
        } catch (FileNotFoundException e) {
            logger.error("Property file could not be found : ", e);
        } catch (IOException e) {
            logger.error("Error in reading property file : ", e);
        } catch (Exception e) {
            logger.error("Unknown Error in reading property file : ", e);
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                logger.error("Error in reading property file : ", e);
            }
        }
    }

    public Integer getPropertyAsInt(String key) {
        Integer retValue;
        try {
            retValue = Integer.parseInt(properties.getProperty(key));
        } catch (NumberFormatException nfExp) {
            logger.error("integer property not found - " + key);
            return 0;
        }
        return retValue;
    }

    public Long getPropertyAsLong(String key) {
        Long retValue;
        try {
            retValue = Long.parseLong(properties.getProperty(key));
        } catch (NumberFormatException nfExp) {
            return 0L;
        }
        return retValue;
    }


    public Double getPropertyAsDouble(String key) {
        Double retValue;
        try {
            String property = properties.getProperty(key);
            if (property == null) {
                return 0D;
            }
            retValue = Double.parseDouble(property);
        } catch (NumberFormatException nfExp) {
            logger.error("double property not found - " + key);
            return 0D;
        }
        return retValue;
    }

    public Boolean getPropertyAsBoolean(String key) {
        String objProperty = properties.getProperty(key);
        if (objProperty != null)
            return new Boolean(objProperty);
        else
            return false;
    }

    public Byte getPropertyAsByte(String key) {
        Byte retValue;
        try {
            retValue = Byte.parseByte(properties.getProperty(key));
        } catch (NumberFormatException nfExp) {
            logger.error("double property not found - " + key);
            return null;
        }
        return retValue;
    }

    public static String readFileContent(String fileName) {
        InputStream in = getInputStream(fileName);
        String ret = readStreamContent(in);

        try {
            in.close();
        } catch (Exception var4) {
            ;
        }

        return ret;
    }

    private static InputStream getInputStream(String fileName) {
        try {
            return new FileInputStream((new ClassPathResource(fileName)).getFile().getAbsoluteFile());
        } catch (FileNotFoundException var6) {
            try {
                InputStream in = (new ClassPathResource(fileName)).getInputStream();
                if (in == null) {
                    throw new IOException();
                } else {
                    return in;
                }
            } catch (IOException var5) {
                try {
                    return new FileInputStream(fileName);
                } catch (FileNotFoundException var4) {
                    throw new CustomException("File not found :: " + fileName, var6);
                }
            }
        } catch (IOException var7) {
            throw new CustomException("Exception while reading file :: " + fileName, var7);
        }
    }


    private static String readStreamContent(InputStream in) {
        try {
            return IOUtils.toString(in, "UTF-8");
        } catch (IOException var2) {
            var2.printStackTrace();
            return "";
        }
    }

}
