package isPermutation;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringOperation {
	
	static Boolean isPermutation(String str1, String str2) {
		if ( str1.length() != str2.length() ) {
			return false;
		}
		
		int[] char_set = new int[128];
		for (int i = 0; i < str1.length(); i++) {
			int val1 = str1.charAt(i);
			int val2 = str2.charAt(i);
			char_set[val1] += 1;
			char_set[val2] -= 1;
		}
		int i = 0;
		while ( i < 128 && char_set[i] == 0 ) {
			i++;
		}
		return (i == 128);
	}
	
	
	public static void main (String args[]) {
		String str1 = "kokukoiz";
		String str2 = "kkuoikoz";
		System.out.println(str1 + " is a permutation of " + str2 + " ? " + isPermutation(str1, str2));
		
	}

}
