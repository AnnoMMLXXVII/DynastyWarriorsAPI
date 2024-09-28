package com.anno.warriors.dw8.database;

public class MissingValueException extends RuntimeException {

	private static final long serialVersionUID = 4426185898950361144L;

	private static final String DEFAULT_MESSAGE = "Unable to perform database action. ";

	public MissingValueException(String field) {
		super(DEFAULT_MESSAGE + "Missing value for the field: " + field);
	}

}
