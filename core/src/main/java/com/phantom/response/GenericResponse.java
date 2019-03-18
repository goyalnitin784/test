package com.phantom.response;

import com.google.gson.JsonObject;
import com.phantom.dto.BaseJsonDTO;
import com.phantom.dto.BaseResponseDTO;

public class GenericResponse extends BaseJsonDTO {
    private BaseResponseDTO baseResponseDTO;
    private JsonObject response;

    public BaseResponseDTO getBaseResponseDTO() {
        return baseResponseDTO;
    }

    public void setBaseResponseDTO(BaseResponseDTO baseResponseDTO) {
        this.baseResponseDTO = baseResponseDTO;
    }

    public JsonObject getResponse() {
        return response;
    }

    public void setResponse(JsonObject response) {
        this.response = response;
    }
}
