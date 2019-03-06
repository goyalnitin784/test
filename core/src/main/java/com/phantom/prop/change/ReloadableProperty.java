package com.phantom.prop.change;

/**
 * Implementors are those who support propeties to be reloaded 
 * 
 * @author nitin.goyal
 *
 */
public interface ReloadableProperty {

	public String getPropertyFileName();
	public String getPropertyFilePath();
	public void reload();
}
