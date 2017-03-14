package sortStack;

import java.util.Stack;

public class SortStackStack {
	
	public static Stack<Integer> sortStack(Stack<Integer> myStack) {
		
		int topStack = 0;	
		Stack<Integer> provStack = new Stack<Integer>();
		provStack.push((Integer) myStack.pop());
		
		while ( !myStack.isEmpty() ) {
			topStack = (int) myStack.pop();
			if ( topStack > provStack.peek() ) {
				provStack.push(topStack);
			} else {
				Integer pop = provStack.pop();
				while ( topStack < pop ) {
					myStack.push(pop);
					if ( !provStack.isEmpty() ) {
						pop = provStack.pop();
					} else {
						pop = Integer.MIN_VALUE;
					}
				}
				if ( pop != Integer.MIN_VALUE ) {
					provStack.push(pop);
				}
				provStack.push(topStack);
				while ( !myStack.isEmpty() && (int) myStack.peek() > provStack.peek() ) {
					provStack.push((Integer) myStack.pop());
				}				
			}
		}
		return provStack;
		
	}
	
	public static void displayStack(Stack<Integer> curStack) {
		
		for ( Integer num : curStack ) {
			System.out.println((int) num);
		}
		System.out.println("");
	}
	
	
	public static void main(String args[]) {
		
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(8);
		myStack.push(81);
		myStack.push(12);
		myStack.push(7);
		myStack.push(65);
		myStack.push(28);
		displayStack(myStack);
		myStack = sortStack(myStack);
		displayStack(myStack);		
		
	}

}
