package com.udea.empresariales.codebreaker;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeBreakerImpl implements CodeBreakerController {

	@Override
	public ResponseEntity<String> getClientById(@PathVariable("number") String number) {
		CodeBreaker codeBreaker = new CodeBreaker();
		String result = codeBreaker.guess(number);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setExpires(1000);
		responseHeaders.set("MiHeader", "valor x");

		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);

	}

}
