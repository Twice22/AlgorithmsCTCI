package flipBit;

public class FlipBit {
	
	FlipBit(int bit) {
		System.out.println("input : " + Integer.toBinaryString(bit));
		
		int currentLength = 0;
		int maxLength = 0;
		int meetZero = 0;
		int currentBit = bit;
		
		while ( bit != 0 ) {
			if ( (bit & 1) == 1 ) {
				currentLength++;
				//System.out.println("bit : " + Integer.toBinaryString(bit));
				//System.out.println("current : " + currentLength);
			} else { // bit & 1 == 0
				if ( (bit & 2) == 0 ) { // 2 zéros se suivent
					maxLength = currentLength > maxLength ? meetZero != 1 ? currentLength+1 : currentLength : maxLength;
					currentLength = 0;
					bit >>= 1;
				} else {
					if  ( meetZero == 0 ) {
						currentLength++;
						meetZero++;
						currentBit = bit;
					} else {
						meetZero = 0;
						bit = currentBit;
						maxLength = currentLength > maxLength ? currentLength : maxLength;
						currentLength = 0;
					}
				}
			}
			bit >>= 1;
			
		}
		System.out.println("max : " + Math.max(maxLength, currentLength));
		
	}
	

	public static void main (String args[]) {
		
		FlipBit fb = new FlipBit(917275);
	}
}
