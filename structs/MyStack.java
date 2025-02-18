package structs;

public class MyStack<E> implements Stack <E>{
	
	protected int capacity;
	public static final int CAPACITY = 1000;
	private int size = -1;
	protected E S[];
	protected int top = -1;
	
	public MyStack() {
		this(CAPACITY);
	}
	
	public MyStack(int cap) {
		this.capacity = cap;
		S = (E[]) new Object[capacity];
	}
	
	public int size() {
		return (top + 1);
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	public void push(E element) throws FullStackException{
		if(size() == capacity) {
			throw new FullStackException("Stack is Full");
		}
		S[++top] = element;	
	}
	
	public E top() {
		if(this.isEmpty()) {
			throw new EmptyStackException("Stack is Empty");
		}
		return S[top];
	}
	
	public E pop() throws EmptyStackException{
		if(size() == capacity) {
			throw new FullStackException("Stack is full");
		}
		E element = S[top];
		S[top--] = null; // dereference for garbage collection
		return element;
	}
	
	public String toString() {
		String s;
		s = "[";
		if(size() > 0) s+= S[0];
		if(size() > 1) {
			for(int i = 1; i <= size()-1; i++) {
				s += " , " + S[i];
			}
			
		}return s + "]";
	}
	
	public void status(String op, Object element) {
		System.out.print("\n--------> " + op);
		System.out.print(", returns " + element);
		System.out.print(" result: size = " + size());
		System.out.println(", stack: " + this);
	}
	
}
