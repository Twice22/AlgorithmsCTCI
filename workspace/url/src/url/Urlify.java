package url;

public class Urlify {
	
	static String urlMe(String str, int len) {
		char arr[] = new char[str.length()];
		for (int i = 0; i < str.length(); i++ ) {
			arr[i] = str.charAt(i);
		}
		
		for ( int i = str.length()-1; i > 0 && len > 0; i-- ) {
			if ( arr[len] != ' ' ) {
				arr[i] = arr[len];
			} else {
				arr[i--] = '0';
				arr[i--] = '2';
				arr[i] = '%';
			}
			len--;
		}
		return new String(arr);
	}
	
	public static void main (String args[]) {
		String str = "Sa lut ca va mon enfant          ";
		String strify = urlMe(str, 22);
		System.out.println(strify);
	}

}
