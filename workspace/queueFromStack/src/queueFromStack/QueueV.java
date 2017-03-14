package queueFromStack;

import java.util.Stack;

public class QueueV {
	
	private Stack<Integer> Stack1 = new Stack();
	private Stack<Integer> Stack2 = new Stack();
	
	public boolean isEmpty() {
		return Stack1.isEmpty() && Stack2.isEmpty();
	}
	
	public void add(int nb) {
		Stack1.push(nb);
	}
	
	public void peek() {
		Stack1.peek();
	}
	
	public int remove() {		
		while ( !Stack1.isEmpty() ) {
			Stack2.push(Stack1.pop());
		}
		int rNum = Stack2.pop();
		while ( !Stack2.isEmpty() ) {
			Stack1.push(Stack2.pop());
		}
		return rNum;
	}
	
	public void display() {
		System.out.println("size : " + Stack1);
	}
	
	public static void main(String args[]) {
		
		QueueV q = new QueueV();
		q.add(8);
		q.add(85);
		q.add(17);
		q.add(32);
		q.add(103);
		
		q.display();
		
		q.remove();
		q.remove();
		q.add(108);
		
		q.display();
		
	}

}
