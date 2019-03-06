package com.phantom.cache.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:spring/cache.xml"})

public class CacheConfiguration {

}
