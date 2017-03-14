package binaryToString;

public class BtoS {
	
	BtoS(double bin) {
		if ( bin > 1 || bin < 0 ) {
			System.out.println("ERROR");
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		
		while ( bin > 0 ) {
			if ( binary.length() >= 32 ) {
				System.out.println("ERROR");
				return;
			}
			
			double r = bin * 2;
			if ( r >= 1 ) {
				binary.append(1);
				bin = r - 1;
			} else {
				binary.append(0);
				bin = r;
			}
		}
		
		System.out.println(binary.toString());

		
	}
	
	public static void main(String args[]) {
		BtoS bin = new BtoS(1/Math.sqrt(2));
	}
}
