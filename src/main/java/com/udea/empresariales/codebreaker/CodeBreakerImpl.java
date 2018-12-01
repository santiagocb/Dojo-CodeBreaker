package com.udea.empresariales.codebreaker;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeBreakerImpl implements CodeBreakerController {

	private CodeBreaker codeBreaker;
	
	@Override
	public ResponseEntity<CodeBreakerDTO> guess(@PathVariable("number") String number) {
		if(codeBreaker == null) {
			codeBreaker = new CodeBreaker();
		}
		String result = codeBreaker.guess(number);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setExpires(1000);
		responseHeaders.set("MiHeader", "valor x");
		
		CodeBreakerDTO codeBreakerDTO = new CodeBreakerDTO();
		codeBreakerDTO.setSecret(result);
		codeBreakerDTO.setMessage("Este fue el Resultado");

		return new ResponseEntity<CodeBreakerDTO>(codeBreakerDTO, responseHeaders, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<CodeBreakerDTO> generateSecret(@RequestBody CodeBreakerDTO codeBreakerDTO) {
		if (codeBreakerDTO != null) {
			codeBreaker = new CodeBreaker(codeBreakerDTO.getSecret());
		}else {
			codeBreaker = new CodeBreaker();
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setExpires(1000);
		responseHeaders.set("MiHeader", "valor x");
		
		return new ResponseEntity<CodeBreakerDTO>(codeBreakerDTO, responseHeaders, HttpStatus.CREATED);
	}

}
