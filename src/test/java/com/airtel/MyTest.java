package com.airtel;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = {"classpath:spring/spring-core-config.xml"})
public class MyTest extends AbstractTestNGSpringContextTests {

    @Test
    public void healthCheckTest() throws Exception {
        System.out.println("Context up");

    }

}
