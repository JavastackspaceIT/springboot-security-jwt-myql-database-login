package com.javastackspaceit.dto;

public class ErrorMessage {

	private int statusCode;
	private String message;

	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorMessage [statusCode=" + statusCode + ", message=" + message + "]";
	}

}
