package com.parking.enums;

public enum ErrorCode {
	INVALID_INPUT("Invalid Input", -1), 
	PARKING_NOT_INITIALIZED("Parking is not initialized", -2), 
	PARKING_FULL("Sorry, parking lot is full ", -3), 
	DATA_NOT_FOUND("Not found", -4),
	SUCCESS("Success", 1);
	

	ErrorCode(String message, int code) {
		this.message = message;
		this.code = code;
	}

	private String message;
	private int code;

	public String getmessage() {
		return message;
	}

	public int getcode() {
		return code;
	}

}
