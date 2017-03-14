package insertion;

public class Insert {

	Insert( int N, int M, int from, int to) {		
		System.out.println("INPUT : ");
		System.out.println("N : " + Integer.toBinaryString(N));
		System.out.println("M : " + Integer.toBinaryString(M));
		
		int maskRight = (~0 << from);
		System.out.println("maskRight : " + Integer.toBinaryString(maskRight));
		
		int maskLeft = ~(~0 << (to+1));
		System.out.println("maskLeft : " + Integer.toBinaryString(maskLeft));
		
		int maskAND = (maskRight ^ maskLeft);
		System.out.println("maskAND : " + Integer.toBinaryString(maskAND));
		
		int maskAND2 = maskAND ^ (M << from);
		System.out.println("maskAND2 : " + Integer.toBinaryString(maskAND2));
		
		int maskOR = ~maskAND;
		System.out.println("maskOR : " + Integer.toBinaryString(maskOR));
		
		int output = ( N | maskOR ) & maskAND2;
		System.out.println("A : " + Integer.toBinaryString(output));
		
	}
	
	public static void main(String args[]) {
		Insert ins = new Insert(6217,153,2,9);
	}
}
