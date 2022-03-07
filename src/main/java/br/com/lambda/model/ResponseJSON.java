package br.com.lambda.model;

public class ResponseJSON {

	private boolean hasError ;
	
	private String errorDescription;

	public ResponseJSON(boolean hasError, String errorDescription) {
		super();
		this.hasError = hasError;
		this.errorDescription = errorDescription;
	}

}
