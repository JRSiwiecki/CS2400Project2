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
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
		//topNode = new Node(newEntry, topNode); // Alternate code
		
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
