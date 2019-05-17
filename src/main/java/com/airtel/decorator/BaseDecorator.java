package com.airtel.decorator;

import com.airtel.request.CommonWordRequest;
import com.airtel.response.CommonWordResponse;

public interface BaseDecorator {

    void process(CommonWordRequest commonWordRequest, CommonWordResponse commonWordResponse);
}
