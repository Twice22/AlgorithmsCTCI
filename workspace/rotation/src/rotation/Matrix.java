package rotation;

public class Matrix {
	
	static int[][] rotate90(int[][] mat) {
		return rotate90rec(mat, 0, mat[0].length-1);
	}
	
	static int[][] rotate90rec(int[][] img, int b, int e) {
		if ( b >= e ) {
			return img;
		}
		
		int varT, varR, varB, varL;		
		for ( int i = b; i < e; i++ ) {
			varT = img[b][i];
			varR = img[i][e];
			varB = img[e][e-i+b];
			varL = img[e-i+b][b];
			
			img[i][e] = varT;
			img[e][e-i+b] = varR;
			img[e-i+b][b] = varB;
			img[b][i] = varL;
		}
		return rotate90rec(img, ++b, --e);
	}

	public static void main (String args[]) {
		int[][] mat = {
						{5,8,6,7,981,10},
						{12,3,666,57,97,10},
						{-12,8,-3,758,22,505},
						{0,38,654,7,9,10},
						{4,877,64,18,59,22},
						{5,637,168,77,923,10},
						{89,8,126,74,219,23}
					};
		
		for (int[] u : mat) {
			for ( int k : u ) {
				System.out.print("| " + k + " ");
			}
			System.out.println("");
		}
		
		rotate90(mat);
		System.out.println("");
		
		for (int j = 0; j < mat[0].length; j++) {
			for ( int k = 0; k < mat[0].length; k++ ) {
				System.out.print("| " + mat[j][k] + " ");
			}
			System.out.println("");
		}
	}
}
