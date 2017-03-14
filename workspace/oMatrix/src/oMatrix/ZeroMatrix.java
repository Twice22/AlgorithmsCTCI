package oMatrix;

import java.util.ArrayList;

public class ZeroMatrix {
	
	public static int[][] slcto0(int mat[][]) {
		int lenCol = mat[0].length;
		int lenLine = mat.length;
		
		class Coord {
			int x;
			int y;
			
			Coord(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		
		ArrayList<Coord> aCoord = new ArrayList<Coord>();

		for ( int i = 0; i < lenCol; i++ ) {
			for ( int j = 0; j < lenLine; j++ ) {
				if ( mat[j][i] == 0 ) {
					
					Coord v = new Coord(i,j);
					v.x = i;
					v.y = j;
					aCoord.add(v);
				}
			}
		}
		
		for ( Coord k : aCoord ) {
			for ( int i = 0; i < lenCol; i++ ) {
				mat[k.y][i] = 0;
			}
			
			for ( int j = 0; j < lenLine; j++ ) {
				mat[j][k.x] = 0;
			}
		}
		
		return mat;
		
	}

	public static void main(String args[]) {
		int[][] mat = {
				{5,8,6,0,981,10},
				{12,3,666,57,97,10},
				{-12,8,-3,758,22,505},
				{0,38,654,7,0,10},
				{4,877,64,18,59,22},
				{5,637,168,77,923,10},
				{89,10,126,74,219,23},
				{14,25,85,63,45,78},
				{5,863,24,56,87,7}
			};

		for (int[] u : mat) {
			for ( int k : u ) {
				System.out.print("| " + k + " ");
			}
			System.out.println("");
		}
		
		slcto0(mat);
		System.out.println("");
		
		for (int[] u : mat) {
			for ( int k : u ) {
				System.out.print("| " + k + " ");
			}
			System.out.println("");
		}
	}
}
