package multiply;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MultiplyRec {
	
	static int multiply(int a, int b) {
		int count = 0, c = 1;
		
		if ( b <= 0 ) return 0;
		
		for ( ; c <= b; c <<= 1 ) {
			count++;
		}
		c >>= 1; count--;
		System.out.println("b-c : " + b + " - " + c);
		return (a << count) + multiply(a, b - c);
	}

	public static void main(String args[]) {
		
		System.out.println("78 * 45 = " + multiply(78,45));
	}
}
