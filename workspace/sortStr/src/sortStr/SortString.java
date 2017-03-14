package sortStr;

public class SortString {
	
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
	
	public static void display(String tab[]) {
		for (String ch : tab) {
			System.out.print(ch + ", ");
		}
		System.out.println("");
	}
	
	public static void quickSortRec(String tab[], int left, int right) {
		int index = partition(tab, left, right);
		if ( left < index - 1 ) {
			quickSortRec(tab, left, index-1);
		}
		if ( right > index ) {
			quickSortRec(tab, index, right);
		}
	}
	
	public static void swap(String[] tab, int left, int right) {
		String temp = tab[left];
		tab[left] = tab[right];
		tab[right] = temp;
	}
	
	public static int partition(String[] arr, int left, int right) {
		String pivot = arr[(left+right)/2];
		while ( left <= right ) {
			while ( cmpString(arr[left], pivot) == 1 ) left++;
			while ( cmpString(arr[right], pivot) == -1 ) right--;
			
			if ( left <= right ) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void quickSort(String tab[]) {
		quickSortRec(tab, 0, tab.length-1);
	}
	
	public static void main(String args[]) {
		String tabStr[] = {"salut", "hello", "jules", "salutA", "Saluta", "Hello", "chat", "zoe", "zoo", "helix"};
		
		display(tabStr);
		quickSort(tabStr);
		display(tabStr);
		
		
	}

}
