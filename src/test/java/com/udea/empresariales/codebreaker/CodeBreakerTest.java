package com.udea.empresariales.codebreaker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeBreakerTest {

	CodeBreaker codeBreaker = new CodeBreaker("1234");
	
	@Test
	public void all_match() {
		String answer = codeBreaker.guess("1234");
		assertEquals("XXXX", answer);
	}
	
	@Test
	public void first_match() {
		String answer = codeBreaker.guess("1987");
		assertEquals("X", answer);
	}
	
	@Test
	public void two_match() {
		String answer = codeBreaker.guess("1984");
		assertEquals("XX", answer);
	}	
	
	@Test
	public void contains_all_in_diferent_position() {
		String answer = codeBreaker.guess("4321");
		assertEquals("____", answer);
	}	
	
	@Test
	public void contains_two_in_diferent_position() {
		String answer = codeBreaker.guess("4891");
		assertEquals("__", answer);
	}
	

	@Test
	public void contains_two_in_diferent_and_one_same_position() {
		String answer = codeBreaker.guess("4831");
		assertEquals("X__", answer);
	}
	
	@Test
	public void contains_nothing_match() {
		String answer = codeBreaker.guess("9867");
		assertEquals("", answer);
	}
	
	@Test
	public void contains_two_in_diferent_and_two_same_position() {
		String answer = codeBreaker.guess("2134");
		assertEquals("XX__", answer);
	}
	
	@Test
	public void contains_one_in_diferent_and_two_same_position() {
		String answer = codeBreaker.guess("4230");
		assertEquals("XX_", answer);
	}
	
	@Test
	public void more_digits_than_expected() {
		String answer = codeBreaker.guess("42300");
		assertEquals("", answer);
	}
	
	@Test
	public void less_digits_than_expected() {
		String answer = codeBreaker.guess("425");
		assertEquals("", answer);
	}
	
	@Test
	public void null_parameter() {
		String answer = codeBreaker.guess(null);
		assertEquals("", answer);
	}
	

	@Test
	public void all_match_v2() {
		codeBreaker = new CodeBreaker("4589");
		String answer = codeBreaker.guess("4589");
		assertEquals("XXXX", answer);
	}
	
	@Test
	public void first_match_v2() {
		codeBreaker = new CodeBreaker("4589");
		String answer = codeBreaker.guess("1523");
		assertEquals("X", answer);
	}

}
