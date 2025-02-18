package structs;

public class StackMain {

	public static void main(String[] args) {
		MyStack stack = new MyStack(500);
		
		MyStack stack2 = new MyStack();
		
		
		
		
		stack.push(100);
		stack.push(200);
		stack2.push(3);
		stack2.push(6 );


Object o = stack.pop();
		stack.status("stack.pop()", o);
		o = stack.pop();
		stack.status("stack.pop()", o);

	
	}
}
