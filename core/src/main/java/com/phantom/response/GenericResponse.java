package com.phantom.response;

import com.phantom.dto.BaseJsonDTO;
import com.phantom.dto.BaseResponseDTO;

public class GenericResponse extends BaseJsonDTO {
    private BaseResponseDTO baseResponseDTO;
    private Response response;

    public BaseResponseDTO getBaseResponseDTO() {
        return baseResponseDTO;
    }

    public void setBaseResponseDTO(BaseResponseDTO baseResponseDTO) {
        this.baseResponseDTO = baseResponseDTO;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
