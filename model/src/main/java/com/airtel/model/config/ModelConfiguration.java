package com.airtel.model.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:spring/database.xml"})
public class ModelConfiguration {

}
