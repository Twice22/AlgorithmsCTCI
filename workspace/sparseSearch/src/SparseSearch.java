import java.util.Scanner;


public class SparseSearch {
	
	public static int cmpString(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		if ( str1.equals(str2) ) {
			return 0;
		}		
				
		int len1 = str1.length(), len2 = str2.length();
		int i = 0, min = Math.min(len1, len2);
		
		while ( i < min &&  (int) str1.charAt(i) == (int) str2.charAt(i) ) {
			i++;
		}
		if ( i < min ) {
			return ( (int) str1.charAt(i) < (int) str2.charAt(i) ) ? 1 : -1;
		} else {
			return len2 > len1 ? 1 : -1;
		}
	}
	
	public static int searchSpace(String[] arr, String str) {
		int left = 0, right = arr.length-1;
		int pivot = (right-left)/2;
		Scanner reader = new Scanner(System.in);
		
		while ( cmpString(arr[pivot], str) != 0 ) {
			int pivotR = pivot, pivotL = pivot;
			
			while ( pivotR < right && arr[pivotR].equals("") ) pivotR++;
			while ( pivotL > left && arr[pivotL].equals("") ) pivotL--;
			
			
			int cmpR = cmpString(arr[pivotR], str);
			int cmpL = cmpString(arr[pivotL], str);


			if ( cmpR == 0 ) {
				return pivotR;
			} else if ( cmpL == 0) {
				return pivotL;
			} else if ( cmpR == 1 ) {
				left = pivotR;
				pivot = pivotR + (right-left)/2;
			} else {
				right = pivotL;
				pivot = pivotL - (right-left)/2;
			}
		}
		
		return pivot;
	}

	public static void main(String args[]) {
		
		String[] arr = {"cutie", "", "", "", "hello", "", "", "joke", "", "", "", "", "love", "", "", "stop", "", ""};
		System.out.println("index : " + searchSpace(arr, "hello"));
		
	}
}
