package com.udea.empresariales.codebreaker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeBreakerTest {

	private CodeBreaker codeBreaker = new CodeBreaker("1234");
	
	@Test
	public void allMatch() {
		String answer = codeBreaker.guess("1234");
		assertEquals("XXXX", answer);
	}
	
	@Test
	public void firstMatch() {
		String answer = codeBreaker.guess("1987");
		assertEquals("X", answer);
	}
	
	@Test
	public void twoMatch() {
		String answer = codeBreaker.guess("1984");
		assertEquals("XX", answer);
	}	
	
	@Test
	public void containsAllInDiferentPosition() {
		String answer = codeBreaker.guess("4321");
		assertEquals("____", answer);
	}	
	
	@Test
	public void containsTwoInDiferentPosition() {
		String answer = codeBreaker.guess("4891");
		assertEquals("__", answer);
	}
	

	@Test
	public void containsTwoInDiferentAndOneSamePosition() {
		String answer = codeBreaker.guess("4831");
		assertEquals("X__", answer);
	}
	
	@Test
	public void containsNothingMatch() {
		String answer = codeBreaker.guess("9867");
		assertEquals("", answer);
	}
	
	@Test
	public void containsTwoInDiferentAndTwoSamePosition() {
		String answer = codeBreaker.guess("2134");
		assertEquals("XX__", answer);
	}
	
	@Test
	public void containsOneInDiferentAndTwoSamePosition() {
		String answer = codeBreaker.guess("4230");
		assertEquals("XX_", answer);
	}
	
	@Test
	public void moreDigitsThanExpected() {
		String answer = codeBreaker.guess("42300");
		assertEquals("", answer);
	}
	
	@Test
	public void lessDigitsThanExpected() {
		String answer = codeBreaker.guess("425");
		assertEquals("", answer);
	}
	
	@Test
	public void nullParameter() {
		String answer = codeBreaker.guess(null);
		assertEquals("", answer);
	}
	

	@Test
	public void allMatchV2() {
		codeBreaker = new CodeBreaker("4589");
		String answer = codeBreaker.guess("4589");
		assertEquals("XXXX", answer);
	}
	
	@Test
	public void firstMatchV2() {
		codeBreaker = new CodeBreaker("4589");
		String answer = codeBreaker.guess("1523");
		assertEquals("X", answer);
	}

}
