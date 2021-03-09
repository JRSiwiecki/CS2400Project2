/*
 * Student Name: Joseph Siwiecki
 * Class Section: CS 2400.04
 */

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 
 * @author Joseph
 * An implentation of the StackInterface using a resizeable array.
 */
public class ResizeableArrayStack<T> implements StackInterface<T>
{
	private T[] stack; // Array of stack entries
	private int topIndex; // Index of top entry
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ResizeableArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}

	public ResizeableArrayStack(int initialCapacity)
	{
		integrityOK = true;
		checkCapacity(initialCapacity);
		
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		integrityOK = true;
	}
	
	@Override
	public void push(T newEntry) 
	{
		checkIntegrity();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}

	@Override
	public T pop() 
	{
		checkIntegrity();
		
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		
		else
		{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}

	@Override
	public T peek() 
	{
		checkIntegrity();
		
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		
		else
		{
			return stack[topIndex];
		}
	}

	@Override
	public boolean isEmpty() 
	{
		return topIndex < 0;
	}

	@Override
	public void clear() 
	{
		checkIntegrity();
		
		// Remove references to the objects in the stack
		// but do not deallocate the array
		while (topIndex > -1)
		{
			stack[topIndex] = null;
			topIndex--;
		}
		
		// Assertion: topIndex is -1
		
	}
	
	/**
	 * If the array is full, double its size.
	 */
	private void ensureCapacity()
	{
		if (topIndex >= stack.length - 1)
		{
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}
	}
	
	/**
     * Throws an exception if this object is not initialized. 
     */
    private void checkIntegrity()
    {
        if (!integrityOK)
        {
            throw new SecurityException("ResizeableArrayBag object is corrupt.");
        }
    }
    
    /**
     * Checks capacity of the bag to make sure it is larger than the array should be.
     * @param capacity The capacity to be checked.
     */
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a bag whose " +
                                        "capacity exceeds allowed " +
                                        "maximum of " + MAX_CAPACITY);
        }
    }
    
    /**
     * Evaluates a postfix expression.
     * @param postfix The expression.
     * @return The result of the expression.
     */  
    public int evaluatePostfix(String postfix) 
    { 
        // Create a ResizeableArrayStack
        ResizeableArrayStack<Integer> valueStack = new ResizeableArrayStack<>(); 
          
        // Scan all characters of postfix individually
        for (int i = 0; i < postfix.length(); i++) 
        { 
            char nextCharacter = postfix.charAt(i); 
              
            // If the scanned character is an integer, 
            // push it to the stack. 
            if(Character.isDigit(nextCharacter)) 
            {
            	valueStack.push(nextCharacter - '0'); 
            }
            	
              
            //  If the character is an operator, pop the last two 
            //  elements from stack and apply the operator 
            else
            { 
                int operandOne = valueStack.pop(); 
                int operandTwo = valueStack.pop(); 
                  
                switch(nextCharacter) 
                { 
                    // addition
                	case '+': 
                    	valueStack.push(operandTwo + operandOne); 
                    	break; 
                      
                    // subtraction
                	case '-': 
                    	valueStack.push(operandTwo - operandOne); 
                    	break; 
                      
                    // division
                	case '/': 
                    	valueStack.push(operandTwo / operandOne); 
                    	break; 
                      
                    // multiplication
                	case '*': 
                    	valueStack.push(operandTwo * operandOne); 
                    	break; 
                    
                    // exponentiation
                	case '^':
                		// cast to int since power function returns a double
                		valueStack.push((int) Math.pow(operandTwo, operandOne));
                		break;
                		
                	// ignore unexpected characters
                	default: 
                		break; 
              } 
            } 
        } 
        // pop instead of peek in case we use this
        // instance of the stack again, so that way
        // the stack will be empty ready for use again
        return valueStack.pop();     
    } 
}
