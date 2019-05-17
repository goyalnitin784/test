package com.airtel.decorator;

import com.airtel.logging.MyLogger;
import com.airtel.request.CommonWordRequest;
import com.airtel.response.CommonWordResponse;

import java.util.HashMap;
import java.util.Map;

public class WordMatchingDecorator implements BaseDecorator {

    MyLogger logger = MyLogger.getLoggerObject(this.getClass());

    public void process(CommonWordRequest commonWordRequest, CommonWordResponse commonWordResponse) {
        Map<String, String> currentProcessingFileMap = commonWordRequest.getCurrentProcessingFileMap();
        Map<String, String> wordsMap = commonWordResponse.getWordsMap();
        Map<String, String> wordsMapFinal = new HashMap<>(wordsMap.size());
        logger.info("Final word count for request : " + commonWordRequest.toString() + " before processing is : " + wordsMap.size());
        for (String key : currentProcessingFileMap.keySet()) {
            if (wordsMap.containsKey(key)) {
                wordsMapFinal.put(key, wordsMap.get(key));
            }
        }
        logger.info("Final word count for request : " + commonWordRequest.toString() + " after processing is : " + wordsMapFinal.size());
        commonWordResponse.setWordsMap(wordsMapFinal);
    }

}