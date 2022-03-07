package br.com.lambda.model;

public class ResponseJSON {

	private boolean hasError ;
	
	private String description;

	public ResponseJSON(boolean hasError, String description) {
		super();
		this.hasError = hasError;
		this.description = description;
	}

	public boolean hasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
