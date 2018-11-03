package com.udea.empresariales.codebreaker;

public class CodeBreaker {
	private String secret;
	
	public CodeBreaker() {
		int secret = (int)Math.floor(Math.random()*(10000));
		if(secret<1000) {
			secret+=1000;
		}
		this.secret = String.valueOf(secret);
	}
	
	public CodeBreaker(String secret) {
		this.secret = secret;
	}
	
	public String guess(String in) {
		String answerx = "";
		String answer_ = "";
				
		if(in == null || in.length() != secret.length()) {
			return "";
		}
	
		for(int i = 0; i<in.length(); i++) {
			if(in.charAt(i) == secret.charAt(i)) {
				answerx = answerx.concat("X");
			}
			else if(secret.contains(in.substring(i, i+1))) {
				answer_ = answer_.concat("_");
			}
		}
		return answerx + answer_;
	}

}