package com.phantom.dto;

import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

public class BaseResponseDTO extends BaseDTO {

	private static final long serialVersionUID = 4388553378959618570L;

	private String code;
	private List<String> messages;
	JsonElement response;

	public BaseResponseDTO() {
	}

	public BaseResponseDTO(String code, List<String> messages) {
		this.code = code;
		this.messages = messages;
	}
	
	public void addMessage(String message) {
		if (this.messages == null) {
			this.messages = new ArrayList<>();
		}
		this.messages.add(message);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public JsonElement getResponse() {
		return response;
	}

	public void setResponse(JsonElement response) {
		this.response = response;
	}
}
