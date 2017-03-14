package missingNumbers;

public class ArrayMinus2 {
	
	static int detectOne(int[] tab) {
		int c = 0, i = 0;
		for ( ; i < tab.length; i++ ) {
			c += (i+1) - tab[i];
		}
		return (c + i + 1);
	}
	
	static String detectTwo(int[] tab) {
		int c1 = 0, c2 = 0, i = 0;
		for ( ; i < tab.length; i++ ) {
			c1 += (i+1) - tab[i];
			c2 += (i+1)*(i+1) - tab[i]*tab[i];
		}
		int u = (c1 + 2*i + 3);
		int v = (c2 + (i+1)*(i+1) + (i+2)*(i+2));
		
		int s1 = (int) (u + Math.sqrt(2*v-u*u))/2;
		int s2 = u - s1;
		return s1 + ", " + s2;
	}

	public static void main(String args[]) {
		//int tab[] = {4,8,13,11,5,3,2,7,10,1,9,6};
		//System.out.println("un nombre manquant : " + detectOne(tab));
		
		int tab[] = {4,8,13,11,5,3,2,7,10,1,15,6,18,14,16,17};
		System.out.println("un nombre manquant : " + detectTwo(tab));
	}
}
