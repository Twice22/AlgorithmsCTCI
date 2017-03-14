package roundedSort;

import java.util.Arrays;
import java.util.Scanner;

public class RoundedArray {
	
	// modified this shit
	public static void roundBy(int[] tab, int round) {
		
		int len = tab.length-1;
		int pt = round % len;
		int roundStep = round % len;
		
		int temp = tab[0];
		int swap = 0, i = 0;
		int c = 0, active = 0;

		if ( (len+1) % round != 0 ) {
			while ( i <= len ) {
				
				if ( pt > len ) {
					pt = pt % (len+1);
				}
				
				swap = tab[pt];
				tab[pt] = temp;
				temp = swap;
				
				if ( i == len ) break;
				
				pt += roundStep;
				i++;
			}
		} else {
			while ( i <= len + roundStep ) {
				
				if ( pt > len ) {
					pt = pt % (len+1);
					active = 1;
					++c;
				}
				
				swap = tab[pt];
				tab[pt] = temp;
				temp = swap;
				
				pt += roundStep;
				if ( active == 1 ) {
					pt = c;
					active = 0;
				}
				i++;
			}
		}		
		
	}
	
	public static int findNum(int[] tab, int n) {
		int pivot = (tab.length-1)/2;
		int left = 0;
		int right = tab.length-1;
		
		while ( tab[pivot] != n ) {
			if ( tab[pivot] > tab[right] && n < tab[right] || tab[pivot] < n && n < tab[right] ) {
				left = pivot;
				pivot = left + (right-left)/2;
			} else if ( tab[left] < n && tab[left] > tab[pivot] || tab[left] < n && n < tab[pivot]  ) {
				right =  pivot;
				pivot = right - (right-left)/2;
			}
		}
		return pivot;
	}
	
	public static void displayTab(int[] tab) {
		for (int n : tab ) {
			System.out.print(n + ", ");
		}
		System.out.println("");
	}

	public static void main(String args[]) {
		
		int[] arr = {1,5,8,14,23,36,45,56,68,73,77,88,92,99,123};
		
		displayTab(arr);
		roundBy(arr, 5);
		displayTab(arr);
		System.out.println(findNum(arr, 23));
		
	}
	
}
