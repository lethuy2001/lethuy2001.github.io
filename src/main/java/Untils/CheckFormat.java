package Untils;

public class CheckFormat {
	public static boolean checkPhoneNumber( String k ) {
		String patern = "0\\d{9,10}" ;
		
		if( k.matches(patern) ) {
			return true ;
		}
		return false ;
	}
	
	public static boolean checkEmail( String k ) {
		String patern = "\\w+@\\w+\\.\\w+";
		
		if( k.matches(patern) ) {
			return true ;
		}
		return false ;
	}
	
	public static boolean checkEmpty( String k ) {
		if( k.isEmpty() || k.equals("")) {
			return true ;
		}
		return false ;
	}
	
	public static boolean checkSoAm( int k ) {
		try {
			if( k <= 0 ) {
				return false ;
			}
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}
}
