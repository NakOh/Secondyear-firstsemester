
public class Test {
	
	public static void main(String args[]){
		
		ExtendedGenericStack2  useStack= new ExtendedGenericStack2();
		System.out.println(useStack.getSize());
		useStack.push("Hello");
		System.out.println(useStack.getSize());
		useStack.push("Good");
		System.out.println(useStack.getSize());
		useStack.push("ZEEL");
		System.out.println(useStack.getSize());
		useStack.pop();
		useStack.push("Perfect");
		System.out.println(useStack.peek());
		System.out.println(useStack.getSize());
	
		
		
		
	}

}
