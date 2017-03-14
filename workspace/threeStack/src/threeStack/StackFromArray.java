package threeStack;

public class StackFromArray {
	
	private int numberOfStack = 3;
	private int stackCapacity;
	private int values[];
	private int sizes[];
	
	public StackFromArray( int stackSize ) {
		this.stackCapacity = stackSize;
		values = new int[stackSize * numberOfStack];
		sizes = new int[numberOfStack];
	}
	
	public void push(int stackNum, int value) throws FullStackException {
		if ( isFull(stackNum) ) {
			throw new FullStackException();
		}
		
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
		
	}
	
	public int pop(int stackNum, int value) throws EmptyStackException {
		if ( isEmpty(stackNum) ) {
			throw new EmptyStackException();
		}
		
		int top = values[indexOfTop(stackNum)];
		values[indexOfTop(stackNum)] = 0;
		sizes[stackNum]--;
		return top;
	}
	
	public int peek(int stackNum, int value) throws EmptyStackException {
		if ( isEmpty(stackNum) ) {
			throw new EmptyStackException();
		}
		
		return values[indexOfTop(stackNum)];
	}
	
	public boolean isEmpty(int stackNum) {
		return ( values[indexOfTop(stackNum)] == 0 );
	}
	
	public int indexOfTop(int stackNum) {
		int offset = stackNum*stackCapacity;
		int other = sizes[stackNum];
		return offset + other - 1;
	}
	
	public boolean isFull(int stackNum) {
		return ( values[indexOfTop(stackNum)] != 0 );
	}
	
	
	public static void main(String args[]) {
		StackFromArray sfa = new StackFromArray(32);
		
	}
}
