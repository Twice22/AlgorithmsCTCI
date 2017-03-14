package sort2Tab;

public class SortAB {
	
	public static int[] sort_AB(int[] tab, int tab2[]) {
		
		int i = tab.length-1, j = tab2.length-1, k = tab.length-tab2.length-1;
		
		while ( i >= 0  ) {
			
			if ( k < 0 ) {
				tab[i] = tab2[j--];
			} else if ( j < 0 ) {
				tab[i] = tab[k--];
			} else if ( tab2[j] > tab[k] ) {
				tab[i] = tab2[j--];
			} else {
				tab[i] = tab[k--];
			}
			i--;
		}
		return tab;
		
	}
	
	public static void display(int tab[]) {
		for (int n : tab) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
	
	public static void main(String args[]) {
		int temp[] = {2,6,10,17,28,55};
		int tab2[] = {1,3,4,18,24,37,47};
		
		int tab[] = new int[temp.length+tab2.length];
		for ( int i = 0; i < temp.length; i++) {
			tab[i] = temp[i];
		}
		
		display(tab);
		sort_AB(tab, tab2);
		display(tab);
		
	}

}
