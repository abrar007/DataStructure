package stack;

import java.util.ArrayList;

public class Stack {
	static ArrayList<Integer> stack=new ArrayList<Integer>();
	static int pointer=0;
	public static void push(int key) {
		stack.add(key);
		pointer++;
		
	}
	public static int peek() {
		return stack.get(pointer-1);
	}
	public static void poll() {
		stack.remove(pointer-1);
		pointer--;
	}
	public static void printStack(){
		for(int i=0;i<stack.size();i++) {
			System.out.print(stack.get(i)+" ");
		}
	}
	public static int stackSize() {
		return stack.size();
	}
	
	
	public static void main(String [] args) {
		push(77);
		push(79);
		push(87);
		push(227);
		
		System.out.println(peek());
		poll();
		printStack();
	}
	
}
