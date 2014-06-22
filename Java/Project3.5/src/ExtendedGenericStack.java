public class ExtendedGenericStack {
	protected Object[] elements;
	protected int top;
	public static int CAPACITY = 1;

	/** Construct a stack with the default capacity 16 */
	public ExtendedGenericStack() {
		 elements = new Object[CAPACITY];
	}

	

	/** Push a new integer into the top of the stack */
	public void push(Object value) {		
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
		return elements.length;
	}
}


class ExtendedGenericStack2 extends ExtendedGenericStack{
	 
	
	public ExtendedGenericStack2(){
		super();
		
	}
	public void push(Object Value){
		if (top >= elements.length) {
			Object[] temp = new Object[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}

		elements[top++] = Value;
		
	}
	
}