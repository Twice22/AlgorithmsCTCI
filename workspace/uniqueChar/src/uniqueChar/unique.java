package uniqueChar;

import java.util.LinkedHashMap;
import java.util.Map;

public class unique {
	
	static boolean unique1(String str) {
		Map<String, Boolean> charList = new LinkedHashMap<String, Boolean>();
		for ( int i = 0; i < str.length(); i++ ) {
			if ( charList.get(str.charAt(i)+"") == null ) {
				charList.put(str.charAt(i)+"", true);
			} else {
				return false;
			}
		}
		return true;
	}
	
	static boolean unique2(String str) {
		for ( int i = 0; i < str.length(); i++ ) {
			for ( int j = i+1; j < str.length(); j++ ) {
				if ( (str.charAt(i)+"").equals(str.charAt(j)+"") ) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main (String args[]) {
		String str = "juiolpmtrgje";
		System.out.println("unique1 char : " + unique1(str));
		System.out.println("unique2 char : " + unique2(str));
		
	}
}
