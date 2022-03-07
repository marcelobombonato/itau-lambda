package br.com.lambda.exception;

public class ExceptionHandler {

	public static final String KEY_NOT_FOUND = "keyNotFound";

	public static final String NULL_OBJECT = "nullObject";

	public static final String ERROR_WHEN_DECODING = "errorWhenDecoding";

	public static String handleException(String type) {

		StringBuilder stb = new StringBuilder();

		switch (type) {
		case KEY_NOT_FOUND:
			stb.append("The key 'iso_message' was not found in JSON");
			break;
		case NULL_OBJECT:
			stb.append("Object received was null or unparsable");
			break;
		case ERROR_WHEN_DECODING:
			stb.append("Error when decoding message content. ");
			break;
		default:
			stb.append("An error has occurred, contact Administrator");
			break;
		}
		String message = stb.toString();
		System.out.println(message);
		
		return message;
	}
}
