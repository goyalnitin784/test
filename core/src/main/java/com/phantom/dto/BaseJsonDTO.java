package com.phantom.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.phantom.util.ConversionUtils;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseJsonDTO extends BaseDTO {

	protected Map<String, Object> anyProperties = new HashMap<>();
	
	@Override
	public String toString() {
		return ConversionUtils.marshalJsonNew(this);
	}
	
	@JsonAnyGetter
    public Map<String, Object> getAnyProperties() {
		if (this.anyProperties.isEmpty()) {
			return null;
		}
        return this.anyProperties;
    }

    @JsonAnySetter
    public void setAnyProperties(String name, Object value) {
        this.anyProperties.put(name, value);
    }
}
