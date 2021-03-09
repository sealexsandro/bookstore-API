package com.sacompany.bookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> errorsList = new ArrayList<FieldMessage>();
	
	public ValidationError() {
		super();
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}

	public List<FieldMessage> getErrorsList() {
		return errorsList;
	}

	public void addErrorsList(String fieldName, String message) {
		this.errorsList.add(new FieldMessage(fieldName, message));
	}

	
	
}
