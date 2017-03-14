package ladder;

import java.util.Arrays;

public class Stepladder {
	
	static int ladder0(int nb) {
		int temp[] = new int[nb+1];
		Arrays.fill(temp, -1);
		return ladder(nb, temp);
	}
	
	static int ladder(int nb, int[] temp) {
		if ( nb < 0 ) {
			return 0;
		} else if ( nb == 0 ) {
			return 1;
		} else if (temp[nb] != -1 ){
			return temp[nb];
		} else {
			return ladder( nb - 1, temp ) + ladder( nb - 2, temp ) + ladder( nb - 3, temp);
		}
	}

	public static void main (String args[]) {
		System.out.println("nb pos : " + ladder0(28));
	}
}
