public class ParameterizedStack<T> {
	private Object[] elements;
	private int top;
	public static final int CAPACITY = 10;

	/** Construct a stack with the default capacity 16 */
	public ParameterizedStack() {
		 elements = new Object[CAPACITY];
	}

	

	/** Push a new integer into the top of the stack */
	public void push(T value) {		
		elements[top++] = value;
	}

	/** Return and remove the top element from the stack */
	public Object pop() {
		return elements[--top];
	}

	/** Return the top element from the stack */
	public Object peek() {
		return elements[top - 1];
	}

	/** Test whether the stack is empty */
	public boolean empty() {
		return top == 0;
	}

	/** Return the number of elements in the stack */
	public int getSize() {
		return top;
	}
}