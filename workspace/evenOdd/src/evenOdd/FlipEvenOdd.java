package evenOdd;

public class FlipEvenOdd {
	
	FlipEvenOdd(int a) {
		System.out.println("A : " + Integer.toBinaryString(a));
		
		int c = 0x55555555;		
		int result = ((a & c) << 1) | ((a & (c << 1)) >> 1);
		
		System.out.println("B : " + Integer.toBinaryString(result));
	}

	
	public static void main (String args[]) {
		FlipEvenOdd feo = new FlipEvenOdd(7894526);
	}
}
