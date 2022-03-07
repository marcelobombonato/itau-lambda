package br.com.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.DecryptResult;
import com.google.gson.Gson;

import br.com.lambda.exception.ExceptionHandler;
import br.com.lambda.model.ResponseJSON;

public class DecryptLambdaTest {

	DecryptLambda lambda;
	
	@Mock
	AWSKMS kmsClient ;
	
	@Before
    public void init() {
		lambda = new DecryptLambda();
    }
	
	@Test
	public void testThatInputIsNull() {

		String json = (String) lambda.handleRequest(null, null);
		
		Gson gson = new Gson();  
		
		ResponseJSON response = gson.fromJson(json, ResponseJSON.class);
		
		assertEquals(true, response.hasError());
		assertEquals(ExceptionHandler.handleException(ExceptionHandler.NULL_OBJECT), response.getDescription());
		
	}
	
	@Test
	public void testThatInputKeyIsNotFound() {
		Map<String, String> map = new HashMap<>();
		
		String json = (String) lambda.handleRequest(map, null);
		
		Gson gson = new Gson();  
		
		ResponseJSON response = gson.fromJson(json, ResponseJSON.class);
		
		assertEquals(true, response.hasError());
		assertEquals(ExceptionHandler.handleException(ExceptionHandler.KEY_NOT_FOUND), response.getDescription());
		
	}
	
	@Test
	@Ignore
	public void testThatDecodingServiceThrowsException() {
		
		Map<String, String> map = new HashMap<>();
		
		map.put("iso_message", Base64.getEncoder().encodeToString("teste".getBytes()));
		
		
		DecryptResult decryptResult = new DecryptResult();
		decryptResult.setPlaintext(ByteBuffer.wrap("success".getBytes()));
		
		when(kmsClient.decrypt(mock(DecryptRequest.class))).thenReturn(decryptResult);
		
		String json = (String) lambda.handleRequest(map, null);
		
		Gson gson = new Gson();  
		
		ResponseJSON response = gson.fromJson(json, ResponseJSON.class);
		
		assertEquals(true, response.hasError());
		assertEquals(ExceptionHandler.handleException(ExceptionHandler.NULL_OBJECT), response.getDescription());
		
	}
}
