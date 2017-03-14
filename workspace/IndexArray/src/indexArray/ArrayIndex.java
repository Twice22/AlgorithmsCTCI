package indexArray;

public class ArrayIndex {
	
	private int[] tab = null;
	
	ArrayIndex(int[] tab) {
		this.tab = tab;
	}
	
	public int positionA() {
		int len = tab.length-1;
		
		if ( this.tab[len] <= len) {
			return -1;
		}
		return positionARec(tab, 0, len);
	}
	
	public int positionARec(int tab[], int beg, int to) {
		//System.out.println("[beg, fin] : [" + beg + "," + to + "]");
		int temp = (beg+to)/2;
		
		if ( beg == temp ) {
			return tab[temp] == temp ? temp : -1;
		}		
		
		if ( tab[temp] == temp ) {
			return temp;
		} else if ( tab[temp] > temp ) {
			return positionARec(tab, beg, temp);
		} else {
			return positionARec(tab, temp, to);
		}
	}

	public static void main (String args[]) {
		//int tab[] = {-7,-5,-3,0,1,3,6,7,9,18};
		int tab[] = {-3,1,4,5,8,9,11,12,14,18};
		
		ArrayIndex arrTest = new ArrayIndex(tab);
		int test = arrTest.positionA();
		System.out.println("position : " + test);

	}
}
