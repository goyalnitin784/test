package com.airtel.response;

import java.util.Map;

public class CommonWordResponse {

    int responseCode = 200;
    String response;
    Map<String, String> wordsMap;


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Map<String, String> getWordsMap() {
        return wordsMap;
    }

    public void setWordsMap(Map<String, String> wordsMap) {
        this.wordsMap = wordsMap;
    }

}
