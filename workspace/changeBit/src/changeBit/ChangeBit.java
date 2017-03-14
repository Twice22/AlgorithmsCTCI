package changeBit;

public class ChangeBit {
	
	ChangeBit(int a, int b) {
		System.out.println("A : " + Integer.toBinaryString(a));
		System.out.println("B : " + Integer.toBinaryString(b));
		
		int aXb = a ^ b;
		int count = 0;
		
		while ( aXb != 0 ) {
			aXb >>= 1;
			count += (aXb & 1);
		}
		
		System.out.println("Bit a flip pour passer de A à B : " + count);
		
	}
	
	static public void main (String args[]) {
		ChangeBit cb = new ChangeBit(29,15);
	}

}
