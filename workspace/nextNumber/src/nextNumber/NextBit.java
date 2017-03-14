package nextNumber;

public class NextBit {
	
	public int nbOne(int a) {
		int nbOfOne = 0;
		
		while ( a != 0 ) {
			if ( (a & 1) == 1 ) {
				nbOfOne++;
			}
			a >>= 1;
		}
		return nbOfOne;
	}
	
	NextBit(int a) {
		int nextA = a+1, prevA = a-1;
		int nbOneCurrent = this.nbOne(a);
		
		System.out.println("binary : " + Integer.toBinaryString(a));
		
		// retrieve nb of One in the current number		
		while ( this.nbOne(nextA) != nbOneCurrent ) {
			nextA++;
		}
		while ( this.nbOne(prevA) != nbOneCurrent ) {
			prevA--;
		}
		
		System.out.println("nextA : " + nextA);
		System.out.println("bin : " + Integer.toBinaryString(nextA));
		System.out.println("prevA : " + prevA);
		System.out.println("bin : " + Integer.toBinaryString(prevA));
	}

	public static void main (String args[]) {
		NextBit nb = new NextBit(894);
	}
}
