package com.airtel.decorator;

import com.airtel.logging.MyLogger;
import com.airtel.request.CommonWordRequest;
import com.airtel.response.CommonWordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.util.HashMap;

public class FirstFileProcessor implements BaseDecorator {
    @Autowired
    @Qualifier("fileLoadingDecorator")
    BaseDecorator fileLoadingDecorator;

    MyLogger logger = MyLogger.getLoggerObject(this.getClass());


    @Override
    public void process(CommonWordRequest commonWordRequest, CommonWordResponse commonWordResponse) {

        logger.info("Going to do First file processing for request : " + commonWordRequest.toString());
        if(commonWordRequest.getFileList().size()>0){
            File file = commonWordRequest.getFileList().get(0);
            commonWordRequest.setCurrentProcessingFile(file);
            fileLoadingDecorator.process(commonWordRequest, commonWordResponse);
            commonWordResponse.setWordsMap(commonWordRequest.getCurrentProcessingFileMap());
            commonWordRequest.setCurrentProcessingFileMap(new HashMap<>(1));
            commonWordRequest.getFileList().remove(file);
            logger.info("First file processing done for request : " + commonWordRequest.toString() + " with word count : " + commonWordResponse.getWordsMap().size());
        }
    }
}
