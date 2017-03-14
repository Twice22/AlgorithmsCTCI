package oneAway;

public class Edit {
	
	static boolean oneAway(String str1, String str2) {
		if ( Math.max(str1.length(), str2.length()) > Math.min(str1.length(), str2.length())+1 ) {
			return false;
		}
		
		int char_set[] = new int[128];
		int c = 0;
		if ( str1.length() == str2.length() ) {			
			for (int i = 0; i < str1.length(); i++) {
				int val1 = str1.charAt(i);
				int val2 = str2.charAt(i);
				
				char_set[val1]++;
				char_set[val2]--;
			}
			
			for ( int i = 0; i < 128; i++ ) {
				c += char_set[i];
			}
			return (c == 0);
		} else {
			for ( int i = 0; i < str1.length(); i++ ) {
				int val1 = str1.charAt(i);
				char_set[val1]++;
			}
			
			for ( int i = 0; i < str2.length(); i++ ) {
				int val2 = str2.charAt(i);
				char_set[val2]--;
			}
			
			for ( int i = 0; i < 128; i++ ) {
				c += char_set[i];
			}
			return (Math.abs(c) == 1);
		}
	}

	public static void main (String args[]) {
		String str1 = "test";
		String str2 = "te";
		
		System.out.println("edit one away : " + oneAway(str1, str2));
	}
}
