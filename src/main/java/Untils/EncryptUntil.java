package Untils;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptUntil {
	public static String encry( String origin ) {
		return BCrypt.hashpw(origin, BCrypt.gensalt()) ;
	}
	
	public static boolean check( String origin , String encryted) {
		return BCrypt.checkpw(origin, encryted) ;
	}
}
