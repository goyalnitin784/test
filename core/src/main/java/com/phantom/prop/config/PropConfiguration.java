package com.phantom.prop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:spring/properties.xml"})
public class PropConfiguration {
    
}
