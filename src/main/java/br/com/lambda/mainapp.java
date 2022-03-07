package br.com.lambda;

import java.util.HashMap;
import java.util.Map;

public class mainapp {

	public static void main(String[] args) {
		DecryptLambda lb = new DecryptLambda();
		
		Map<String, String> map = new HashMap<>();
		
		map.put("iso_message", "Z84NfKHeQu4TUl78kizbjNknMkAmQrVIwsZ5YNKOw7oeqdTQHWYt9P4GDXhDodPIIgh1rskEdtzW04mIvFWJHZlDbeTgHn/YUr82zwgGO6HL0qH9k/NSBb5IGX3a+pZHNAKmE74gjsJSdCLQNlGsWjsIVM+eR8fCjXTHMCrwVQwfJBHkqepvxQZQWEG/TghEMYJ+2qviF0kBbBp3O0b9LJD6foTg8uF/LEfw/gZHvEr/ttq3znSkwdUmTtQIG3KMi6KJQmSqIep7dABnpXupHh8Vgs/6xnwxB68n5ajze1KAjWGg91sU8BWVDftGC7zw4iwQM6mW1RBb10KEIpIheOb01UrsNus+bkvYq1M/7OlqEHhvOuK/mxyFkhjvX0DDSL1NpH2ffrUFR5rkjYlYlWov6loodBrDVo72/qxA4lAz4gL44dg9Ce85nCq8nnVo8Dpio1kITv0W6ffKdeqlZuom+J3WWB5jFgY5jRyev1oqGh+eL9igzR8H0CJO4khU");
		
		lb.handleRequest(map, null);
	}

}
