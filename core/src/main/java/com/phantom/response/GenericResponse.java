package com.phantom.response;

import com.phantom.dto.BaseJsonDTO;
import com.phantom.dto.BaseResponseDTO;

public class GenericResponse extends BaseJsonDTO {
    private BaseResponseDTO baseResponseDTO;
    private String response;

    public BaseResponseDTO getBaseResponseDTO() {
        return baseResponseDTO;
    }

    public void setBaseResponseDTO(BaseResponseDTO baseResponseDTO) {
        this.baseResponseDTO = baseResponseDTO;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
