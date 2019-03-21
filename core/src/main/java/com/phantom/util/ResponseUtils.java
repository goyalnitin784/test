package com.phantom.util;

import com.google.gson.Gson;
import com.phantom.dto.BaseResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtils {

    public String getResponseByFlag(boolean flag) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        if (flag) {
            baseResponseDTO.addMessage("SUCCESS");
            baseResponseDTO.setCode("200");
        } else {
            baseResponseDTO.addMessage("FAILURE");
            baseResponseDTO.setCode("500");
        }
        return new Gson().toJson(baseResponseDTO);
    }
}
