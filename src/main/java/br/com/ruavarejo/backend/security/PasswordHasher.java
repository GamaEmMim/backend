package br.com.ruavarejo.backend.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
	public static String hashPassword(String password){
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public static boolean validatePassword(String cleanPassword, String hashedPassword){
		return BCrypt.checkpw(cleanPassword, hashedPassword);
	}

}
