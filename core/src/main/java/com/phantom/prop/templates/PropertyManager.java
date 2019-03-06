package com.phantom.prop.templates;

import java.util.List;

/**
 * Properties to rest of the world are exposed by this simple interface that returns
 * property for a key
 *
 * @author nitin.goyal
 */
public interface PropertyManager extends PropertyManagerSimple {
    String getNonNullProperty(String key);

    Integer getPropertyAsInt(String key);

    Long getPropertyAsLong(String key);

    Double getPropertyAsDouble(String key);

    Boolean getPropertyAsBoolean(String key);

    Byte getPropertyAsByte(String key);

    String[] getPropertyAsStringArray(String key);

    Boolean[] getPropertyAsBooleanArray(String key);

    Integer[] getPropertyAsIntArray(String key);

    String getProperty(String key, String defaultValue);

    List<String> getPropertyAsList(String key);
}
