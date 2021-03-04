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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub
		
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
}
