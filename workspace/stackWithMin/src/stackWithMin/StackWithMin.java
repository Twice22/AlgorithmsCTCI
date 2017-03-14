package stackWithMin;

import java.util.Stack;

public class StackWithMin extends Stack<withMin> {

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new withMin(newMin, value));
	}
		
	public int min() {
		if ( this.isEmpty() ) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}
		
}
