package br.com.lambda;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import br.com.lambda.exception.ExceptionHandler;
import br.com.lambda.model.ResponseJSON;

public class DecryptLambda implements RequestHandler<Object, Object> {

	private static String keyId = "arn:aws:kms:us-east-1:334818988380:key/fe74ee51-0a1a-44f6-96c5-bc2b1dbd7a54";

	@Override
	public Object handleRequest(Object input, Context context) {

		Gson gson = new Gson();

		if (input != null) {
			Map<String, String> map = (Map) input;
			if (map.containsKey("iso_message")) {
				System.out.println(map.get("iso_message"));

				try {
					return gson.toJson(new ResponseJSON(false, decrypt(map.get("iso_message"))));
				} catch (Exception e) {
					String json = gson.toJson(new ResponseJSON(true, ExceptionHandler.handleException(ExceptionHandler.ERROR_WHEN_DECODING).concat(e.getLocalizedMessage())));
					System.out.println(json);
					return json;
				}
			} else {
				return gson.toJson(new ResponseJSON(true, ExceptionHandler.handleException(ExceptionHandler.KEY_NOT_FOUND)));
			}
		} else {
			return gson.toJson(new ResponseJSON(true, ExceptionHandler.handleException(ExceptionHandler.NULL_OBJECT)));
		}
	}

	private String decrypt(String message) throws Exception {

		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAU35GEKFONBKVSHP4",
				"D4RBsWKZZ0+3ocOKQH1Mno0PZdpS4RI8QwQ/OD2f");

		AWSKMS kmsClient = AWSKMSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.build();

		byte[] encryptedMsg = Base64.getDecoder().decode(message);

		System.out.println("encryptedMsg: " + encryptedMsg.toString());

		System.out.println("kmsClient: " + kmsClient);

		DecryptRequest req = new DecryptRequest().withCiphertextBlob(ByteBuffer.wrap(encryptedMsg)).withKeyId(keyId)
				.withEncryptionAlgorithm("RSAES_OAEP_SHA_256");

		System.out.println("DecryptRequest created");

		ByteBuffer decodedMessage = kmsClient.decrypt(req).getPlaintext();
		
		String strMessage = new String(decodedMessage.array(), StandardCharsets.UTF_8);

		System.out.println("ISO Message is "+strMessage);

		System.out.println("Send ISO Message to next system...");
		
		String success = "ISO Message was successfuly sent!";
		
		System.out.println(success);
		
		return success;

	}
}
