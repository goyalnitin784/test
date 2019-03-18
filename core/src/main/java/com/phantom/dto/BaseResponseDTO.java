package com.phantom.dto;

import java.util.ArrayList;
import java.util.List;

public class BaseResponseDTO extends BaseDTO {

	private static final long serialVersionUID = 4388553378959618570L;

	private String code;
	private List<String> messages;
	private String httpCode;
	
	public BaseResponseDTO() {
	}

	public BaseResponseDTO(String code, List<String> messages, String httpCode) {
		this.code = code;
		this.messages = messages;
		this.httpCode = httpCode;
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

	public String getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}

}
