/*
 * Student Name: Joseph Siwiecki
 * Class Section: CS 2400.04
 */

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class LinkedStackTest 
{
	public static void main(String[] args)
	{
		
	}
	
	/**
	 * Basic test of convertToPostfix
	 */
	@Test
	void infixToPostfixTestOne() 
	{
		LinkedStack<String> test = new LinkedStack<String>();
		String output = test.convertToPostfix("a*b/(c-a)+d*e");
		assertEquals("ab*ca-/de*+", output);
	}
	
	/**
	 * Testing if convertToPostfix can handle spaces.
	 */
	@Test
	void infixToPostfixTestTwo() 
	{
		LinkedStack<String> test = new LinkedStack<String>();
		String output = test.convertToPostfix("a * b / (c - a) + d * e");
		assertEquals("ab*ca-/de*+", output);
	}
	
	/**
	 * Different expression, also checks if capitals work.
	 */
	@Test
	void infixToPostfixTestThree() 
	{
		LinkedStack<String> test = new LinkedStack<String>();
		String output = test.convertToPostfix("(A + B) * (C + D)");
		assertEquals("AB+CD+*", output);
	}
	
	/**
	 * Different expression.
	 */
	@Test
	void infixToPostfixTestFour() 
	{
		LinkedStack<String> test = new LinkedStack<String>();
		String output = test.convertToPostfix("a + b + c + d");
		assertEquals("ab+c+d+", output);
	}
	
	/**
	 * Different expression, testing if it can handle multiple variables
	 * with the same character.
	 */
	@Test
	void infixToPostfixTestFive() 
	{
		LinkedStack<String> test = new LinkedStack<String>();
		String output = test.convertToPostfix("(a+b)*a");
		assertEquals("ab+a*", output);
	}
	
}

