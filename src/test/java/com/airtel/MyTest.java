package com.airtel;

import com.airtel.decorator.BaseDecorator;
import com.airtel.preprocessor.FileOrderModificationPreprocessor;
import com.airtel.request.CommonWordRequest;
import com.airtel.response.CommonWordResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = {"classpath:spring/spring-core-config.xml"})
public class MyTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("firstFileProcessor")
    BaseDecorator firstFileProcessor;

    @Autowired
    @Qualifier("fileLoadingDecorator")
    BaseDecorator fileLoadingDecorator;

    @Autowired
    @Qualifier("wordMatchingDecorator")
    BaseDecorator wordMatchingDecorator;

    @Autowired
    FileOrderModificationPreprocessor fileOrderModificationPreprocessor;

    @Test
    public void healthCheckTest() throws Exception {
        System.out.println("Context up");
    }

    @Test
    public void createRequest() throws Exception {
        String payload = "[\"/Users/nitin.goyal/Desktop/test.txt\",\"/Users/nitin.goyal/Desktop/test1.txt\",\"/Users/nitin.goyal/Desktop/test.txt\"]";
        CommonWordRequest commonWordRequest = new CommonWordRequest(payload);
        Reporter.log(commonWordRequest.toString(), true);
    }

    @Test
    public void testFirstFileProcessor() throws Exception {
        String payload = "[\"/Users/nitin.goyal/Desktop/test.txt\",\"/Users/nitin.goyal/Desktop/test1.txt\",\"/Users/nitin.goyal/Desktop/test.txt\"]";
        CommonWordRequest commonWordRequest = new CommonWordRequest(payload);
        CommonWordResponse commonWordResponse = new CommonWordResponse();
        firstFileProcessor.process(commonWordRequest,commonWordResponse);
        Reporter.log(commonWordResponse.getWordsMap().toString(), true);
    }

    @Test
    public void fileLoadingDecorator() throws Exception {
        String payload = "[\"/Users/nitin.goyal/Desktop/test.txt\",\"/Users/nitin.goyal/Desktop/test1.txt\",\"/Users/nitin.goyal/Desktop/test.txt\"]";
        CommonWordRequest commonWordRequest = new CommonWordRequest(payload);
        CommonWordResponse commonWordResponse = new CommonWordResponse();
        fileLoadingDecorator.process(commonWordRequest,commonWordResponse);
        Reporter.log(commonWordRequest.getCurrentProcessingFileMap().toString(), true);
    }

    @Test
    public void wordMatchingDecorator() throws Exception {
        String payload = "[\"/Users/nitin.goyal/Desktop/test.txt\",\"/Users/nitin.goyal/Desktop/test1.txt\",\"/Users/nitin.goyal/Desktop/test.txt\"]";
        CommonWordRequest commonWordRequest = new CommonWordRequest(payload);
        CommonWordResponse commonWordResponse = new CommonWordResponse();
        firstFileProcessor.process(commonWordRequest,commonWordResponse);
        fileLoadingDecorator.process(commonWordRequest,commonWordResponse);
        wordMatchingDecorator.process(commonWordRequest,commonWordResponse);
        Reporter.log(commonWordResponse.getWordsMap().toString(), true);
    }



}
