/** A class of stacks whose entries are stored in a chain of nodes.
 * 
 * @author Joseph
 * 
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T>
{

	// references the first node in the chain.
	private Node topNode;
	
	public LinkedStack()
	{
		topNode = null;
	}
	
	@Override
	public void push(T newEntry) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub
		
	}
	
	private class Node
	{
		private T Data; // entry in the stack
		private Node next; // link to the next node
		
		// getters and setters
		public T getData()
		{
			return Data;
		}
		
		public void setData(T newData)
		{
			Data = newData;
		}
		
		public Node getNextNode()
		{
			return next;
		}
		
		public void setNextNode(Node newNode)
		{
			next = newNode;
		}
	}
	
}
