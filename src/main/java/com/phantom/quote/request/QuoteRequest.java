package com.phantom.quote.request;

import com.phantom.request.MapBasedRequest;

import javax.servlet.http.HttpServletRequest;


public class QuoteRequest extends MapBasedRequest {
    private static final long serialVersionUID = -6642957764091515832L;



    public QuoteRequest(HttpServletRequest request) {
        super(request);
        postConstruct();
    }

    private void postConstruct() {

    }


}

