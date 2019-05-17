package com.airtel.decorator;

import com.airtel.logging.MyLogger;
import com.airtel.request.CommonWordRequest;
import com.airtel.response.CommonWordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.util.List;

public class MasterDecorator implements BaseDecorator {

    @Autowired
    @Qualifier("firstFileProcessor")
    BaseDecorator firstFileProcessor;

    @Autowired
    @Qualifier("fileLoadingDecorator")
    BaseDecorator fileLoadingDecorator;

    @Autowired
    @Qualifier("wordMatchingDecorator")
    BaseDecorator wordMatchingDecorator;

    MyLogger logger = MyLogger.getLoggerObject(this.getClass());

    public void process(CommonWordRequest commonWordRequest, CommonWordResponse commonWordResponse) {

        firstFileProcessor.process(commonWordRequest, commonWordResponse);

        List<File> fileList = commonWordRequest.getFileList();
        for (File file : fileList) {
            commonWordRequest.setCurrentProcessingFile(file);
            logger.info("starting processing for file with path : " + file);
            fileLoadingDecorator.process(commonWordRequest, commonWordResponse);
            wordMatchingDecorator.process(commonWordRequest, commonWordResponse);
            logger.info("processing done for file with path : " + file);
        }
    }

}