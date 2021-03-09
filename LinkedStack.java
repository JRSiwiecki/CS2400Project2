/*
 * Student Name: Joseph Siwiecki
 * Class Section: CS 2400.04
 */

import java.util.EmptyStackException;

/** A class of stacks whose entries are stored in a chain of nodes.
 * 
 * @author Joseph
 * 
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T>
{

	// references the first node in the chain.
	private Node<T> topNode;
	
	public LinkedStack()
	{
		topNode = null;
	}
	
	@Override
	public void push(T newEntry) 
	{
		Node<T> newNode = new Node<T>(newEntry, topNode);
		topNode = newNode;
		//topNode = new Node(newEntry, topNode); // Alternate code	
	}

	@Override
	public T pop() 
	{
		T top = peek(); // Might throw EmptyStackException
		
		// Assertion: topNode != null
		topNode = topNode.getNextNode();
		
		return top;
	}

	@Override
	public T peek() 
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		
		else
		{
			return (T) topNode.getData();
		}
	}

	@Override
	public boolean isEmpty() 
	{
		return topNode == null;
	}

	@Override
	public void clear() 
	{
		topNode = null;
	}
	
	/**
	 * Converts an infix expression to an equivalent postfix expression.
	 * operatorStack = A new empty stack.
	 * postfix = A new empty string.
	 * @param infix The infix expression.
	 * @return The postfix expression.
	 */
	public String convertToPostfix(String infix)
	{
		LinkedStack<String> operatorStack = new LinkedStack<String>();
		LinkedStack<String> topOperator = new LinkedStack<String>();
		
		String postfix = "";			
		
		for (int i = 0; i < infix.length(); i++)
		{
			char nextCharacter = infix.charAt(i);
			
			if (((nextCharacter > 'a') && (nextCharacter < 'z')) || ((nextCharacter > 'A') && (nextCharacter < 'Z')))
			{
				postfix += nextCharacter;
			}
					
			switch(nextCharacter)
			{
				case '^':
					operatorStack.push(String.valueOf(nextCharacter));
					break;
				
				case '+': case '-': case '*': case '/':
					while (!operatorStack.isEmpty()) // TODO: also need to have precedence of nextCharacter <= precedence of operatorStack.peek() in the while loop condition...
					{
						postfix += operatorStack.peek();
						operatorStack.pop();
					}
					operatorStack.push(String.valueOf(nextCharacter));
					break;
				
				case '(':
					operatorStack.push(String.valueOf(nextCharacter));
					break;
				
				case ')': // Stack is not empty if infix expression is valid
					topOperator.push(operatorStack.pop());
					while (topOperator.peek() != "(")
					{
						postfix += topOperator;
						topOperator.push(operatorStack.pop());
					}
					break;
					
				default: break; // Ignore unexpected characters	
			}
			
			while (!operatorStack.isEmpty())
			{
				topOperator.push(operatorStack.pop());
				postfix += topOperator;
			}
		}
		
		return postfix;
	}
	
	/**
	 * Function used to show which operator
	 * takes higher precendence.
	 * @param c The operator.
	 * @return The precedence the operator has.
	 */
	private static int precedence(char c)
	{
		switch (c)
		{
			case '+': case '-': 
				return 1;
			
			case '*': case '/':
				return 2;
				
			case '^':
				return 3;
		}
		
		return -1;
	}
	
	/**
     * Nodes representing entries in the linked bag.
     * @param <T> The entry datatype.
     */
    @SuppressWarnings("hiding")
	private class Node<T>
    {
        /**
         * @InstanceField data The entry itself.
         * @InstanceField next The entry next to the current node.
         */
    	private T data; 
        private Node<T> next; 

        /**
         * Creates a node of data at the front of the list.
         * @param dataPortion The entry.
         */
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        /**
         * Creates a node at a given position
         * @param dataPortion The entry.
         * @param nextNode The given position.
         */
        private Node(T dataPortion, Node<T> nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        /**
         * Getter function to get the entry.
         * @return The entry.
         */
        private T getData()
        {
            return data;
        }

        /**
         * Setter function to set the entry.
         * @param newData The entry.
         */
        @SuppressWarnings("unused")
		private void setData(T newData)
        {
            data = newData;
        }

        /**
         * Gets the next node.
         * @return The node.
         */
        private Node<T> getNextNode()
        {
            return next;
        }

        /**
         * Sets the next node.
         * @param nextNode The next node.
         */
        @SuppressWarnings("unused")
		private void setNextNode(Node<T> nextNode)
        {
            next = nextNode;
        }
	}
	
}
