package com.phantom;

import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Test
@ContextConfiguration(locations = {"classpath:spring/spring-core-config.xml"})
public class PhantomTest extends AbstractTestNGSpringContextTests {

    private static final Logger logger = Logger.getLogger(PhantomTest.class);

    @Test
    public void sampleTest() throws Exception {

    }




    private static String readFile(String fileName) {

        StringBuilder sb = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(sb::append);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
