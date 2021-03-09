/*
 * Student Name: Joseph Siwiecki
 * Class Section: CS 2400.04
 */

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

/** Test class using JUnit to test ResizeableArrayStack methods.
 * 
 * @author Joseph
 *
 */
public class ArrayStackTest 
{
	public static void main(String[] args)
	{
		
	}
	
	/**
	 * Basic test of evaluatePostfix.
	 */
	@Test
	void postfixTestOne() 
	{
		ResizeableArrayStack<String> test = new ResizeableArrayStack<String>();
		int output = test.evaluatePostfix("23*42-/56*+");
		assertEquals(33, output);
	}
	
	
	/**
	 * Tests postfix's ability to read the expression with spaces.
	 */
	@Test
	void postfixTestTwo() 
	{
		ResizeableArrayStack<String> test = new ResizeableArrayStack<String>();
		int output = test.evaluatePostfix("2 3 * 4 2 - / 5 6 * +");
		assertEquals(33, output);
	}
	
	
	/**
	 * Testing a different expression.
	 */
	@Test
	void postfixTestThree() 
	{
		ResizeableArrayStack<String> test = new ResizeableArrayStack<String>();
		int output = test.evaluatePostfix("45+39+*");
		assertEquals(108, output);
	}
	
	/**
	 * Different expression to test with spaces.
	 */
	@Test
	void postfixTestFour() 
	{
		ResizeableArrayStack<String> test = new ResizeableArrayStack<String>();
		int output = test.evaluatePostfix("1 2 + 3 + 4 +");
		assertEquals(10, output);
	}
	
	/**
	 * Testing expressions with the same numbers.
	 */
	@Test
	void postfixTestFive() 
	{
		ResizeableArrayStack<String> test = new ResizeableArrayStack<String>();
		int output = test.evaluatePostfix("8 7 + 8 *");
		assertEquals(120, output);
	}
}
