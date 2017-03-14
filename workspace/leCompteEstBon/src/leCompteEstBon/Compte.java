package leCompteEstBon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Compte implements Cloneable {
	
	static final int stock[] = {1,2,3,4,5,6,7,8,9,10,25,50,75,100};	
	private int bestDiff = 2_000_000;
	
	private int nbToFind; // number to find
	private int[][] numbers = null; // number to use
	
	private Solution tempSolution = new Solution();
	private Solution bestSolution = new Solution();
	
	private int tempDepth = 0; // number of operation
	private int bestDepth = 0;
	
	public void displayGame(int n) {
		System.out.println("You must find : " + this.nbToFind);
		for ( int nb : this.numbers[n] ) {
			System.out.print(nb + " ");
		}
		System.out.println("");
	}
	
	public void displaySolution(int round) {
		System.out.println("SOLUTION : ");
		for ( int i = 6; i > round; i-- ) {
			System.out.println("-- " + bestSolution.value1[i] + " " +  bestSolution.operation[i] + " " + bestSolution.value2[i] + " = " + bestSolution.result[i]);
		}
	}
	
	public void solve(int round) {
		int nb1, nb2;
		
		// terminate case
		int diff = Math.abs(nbToFind-numbers[round][0]);
		if ( diff <= bestDiff ) {
			if ( diff < bestDiff ) {
				bestDiff = diff;
				bestSolution = tempSolution;
				bestDepth = tempDepth;
				if (diff == 0) {
					this.displaySolution(round);
				}
			} else { // diff = bestDiff
				if ( round > bestDepth ) {
					bestSolution = tempSolution;
					bestDepth = round;
				}
				if ( diff == 0 ) {
					this.displaySolution(round);
				}
				
			}
		}
		if (round == 1) return;
		
		for ( int i = 0; i < round-1; i++ ) {
			for ( int j = i+1; j < round; j++ ) {				
				// choose 2 numbers among the list of 6
				nb1 = numbers[round][i];
				nb2 = numbers[round][j];
				
				// copy all the number from the list of used numbers
				// except the 2 used to another level
				for ( int k = 0, n = 1; k < round; k++ ) {
					if ( k != i && k != j ) {
						numbers[round-1][n++] = numbers[round][k];
					}
				}
				
				// save the value of used numbers
				tempSolution.value1[round] = nb1;
				tempSolution.value2[round] = nb2;
				
				// do the math
				tempSolution.operation[round] = "+";
				numbers[round-1][0] = nb1 + nb2;
				tempSolution.result[round] = numbers[round-1][0] + "";
				solve(round-1);
				
				if ( nb1 != 1 && nb2 != 1 ) {
					tempSolution.operation[round] = "*";
					numbers[round-1][0] = nb1 * nb2;
					tempSolution.result[round] = numbers[round-1][0] + "";
					solve(round-1);
				}
				
				if ( nb1 != nb2 ) {
					if ( nb1 < nb2 ) {
						tempSolution.value1[round] = nb2;
						tempSolution.value2[round] = nb1;
					}
					tempSolution.operation[round] = "-";
					numbers[round-1][0] = Math.abs(nb1-nb2);
					tempSolution.result[round] = numbers[round-1][0] + "";
					solve(round-1);
				}				
				
				// no need to test if nb2 or nb1 is 0
				if ( nb2 != 1 && nb1 % nb2 == 0 ) {
					tempSolution.operation[round] = "/";
					numbers[round-1][0]  = nb1/nb2;
					tempSolution.result[round] = numbers[round-1][0] + "";
					solve(round-1);
				} else if ( nb1 != 1 && nb2 % nb1 == 0) {
					tempSolution.value1[round] = nb2;
					tempSolution.value2[round] = nb1;
					numbers[round-1][0] = nb2/nb1;
					tempSolution.result[round] = numbers[round-1][0] + "";
					solve(round-1);
				}
			}
		}
	}
	
	Compte(int n) throws tooBigException {
		int i = 0, cloneStock[] = stock.clone();	
		this.numbers = new int[n+1][n];
		this.nbToFind = (int) (100 + Math.floor(Math.random()*900));
		
		if ( n > stock.length ) {
			throw new tooBigException();
		}
		while ( i < n ) {
			int temp = (int) Math.floor( Math.random() * cloneStock.length );
			if ( cloneStock[temp] != 0 ) {
				numbers[n][i++] = cloneStock[temp];
				cloneStock[temp] = 0;
			} 
		}
	}	

	public static void main(String args[]) throws tooBigException {		
		int n = 6;
		Compte game = new Compte(n);
		game.displayGame(n);
		game.solve(n);
	}
}
