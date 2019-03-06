package com.phantom.prop.config;

import javax.sql.DataSource;

/**Configuration Model for the Property Framework
 * @author nitin.goyal
 */

public class PropertyConfig {
    private DataSource dataSource;
    private String propertyTable;
    private String overridePropertyTable;
    private String environment;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getPropertyTable() {
        return propertyTable;
    }

    public void setPropertyTable(String propertyTable) {
        this.propertyTable = propertyTable;
    }

    public String getOverridePropertyTable() {
        return overridePropertyTable;
    }

    public void setOverridePropertyTable(String overridePropertyTable) {
        this.overridePropertyTable = overridePropertyTable;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
