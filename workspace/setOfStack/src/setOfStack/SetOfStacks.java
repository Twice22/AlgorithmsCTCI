package setOfStack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class SetOfStacks {
	
	private int limit;
	private ArrayList<Stack> stack = new ArrayList<Stack>();
	
	
	public SetOfStacks(int limit) {
		this.limit = limit;
	}
	
	public void push(int v) {
		Stack last = getLastStack(stack);
		if ( last != null && last.size() != limit ) {
			last.push(v);
		} else {
			Stack addStack = new Stack();
			addStack.push(v);
			stack.add(addStack);
		}
	}
	
	public int pop( int v ) {
		Stack last = getLastStack(stack);
		int popNumber = (int) last.pop();
		if ( last.size() == 0 ) {
			stack.remove(stack.size()-1);
		}
		return popNumber;
		
	}
	
	public int peek( int v ) {
		Stack last = getLastStack(stack);
		return (int) last.peek();
	}
	
	public boolean isEmpty() {
		return (getLastStack(stack).peek() == null);
	}
	
	public Stack getLastStack(ArrayList<Stack> lStack) {
		if ( lStack.size() == 0 ) {
			return null;
		}
		Stack last = lStack.get(lStack.size()-1);
		return last;
	}

	public int popAt(int index) {
		Stack myStack = stack.get(index);
		int popNumber = (int) myStack.pop();
		return popNumber;
	}
	
	public static void main(String args[]) {
		SetOfStacks setStack = new SetOfStacks(3);
		setStack.push(1);
		setStack.push(2);
		setStack.push(21);
		setStack.push(13);
		setStack.push(15);
		setStack.push(21);
		setStack.push(13);
		setStack.push(15);
		setStack.push(21);
		setStack.push(13);
		setStack.push(15);
		setStack.popAt(2);
		setStack.push(15);
		setStack.push(21);
	}
	
}
