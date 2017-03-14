package compression;

public class StringCompression {
	
	static String zip(String str) {
		StringBuilder nStr = new StringBuilder();
		
		int i = 0;
		
		while ( i < str.length() ) {
			nStr.append(str.charAt(i));
			int j = i+1, c = 1;
			while ( j < str.length() && str.charAt(i) == str.charAt(j) ) {
				j++;
			}
			if ( j-i > 2 ) {
				nStr.append((j-i)+"");
			} else if ( j-i == 2 ){
				nStr.append(str.charAt(i));
			}
			i = j;			
		}
		
		return nStr.toString();
	}

	public static void main(String args[]) {
		
		String str = "aaahhjkkolllllmUUUUUiddd";
		System.out.println("compression : "+ zip(str));
	}
}
