package com.airtel.service;

import com.airtel.decorator.BaseDecorator;
import com.airtel.decorator.MasterDecorator;
import com.airtel.preprocessor.FileOrderModificationPreprocessor;
import com.airtel.request.CommonWordRequest;
import com.airtel.response.CommonWordResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommonWordService {

    @Autowired
    FileOrderModificationPreprocessor fileOrderModificationPreprocessor;

    @Autowired
    @Qualifier("masterDecorator")
    BaseDecorator masterDecorator;


    public CommonWordResponse generateResponse(CommonWordRequest commonWordRequest) {
        CommonWordResponse commonWordResponse = new CommonWordResponse();
        fileOrderModificationPreprocessor.preprocess(commonWordRequest);
        masterDecorator.process(commonWordRequest, commonWordResponse);
        if (commonWordResponse.getWordsMap().size() > 0) {
            commonWordResponse.setResponse(new Gson().toJson(new ArrayList<>(commonWordResponse.getWordsMap().values())));
        }
        return commonWordResponse;
    }

}
