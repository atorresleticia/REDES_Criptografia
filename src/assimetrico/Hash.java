package assimetrico;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hash {
	
	//MD5, SHA-1, SHA-256
	static String ALG = "SHA-256";
	
	public static void main(String[] args){
		try {
			MessageDigest md = MessageDigest.getInstance(ALG);
			String textoAberto = "the quick brown fox jumps over the lazy dog"; //Hash = d63R1fQSI9VYL8pzalyzNQ==
			
			byte[] buffer = md.digest(textoAberto.getBytes());
			System.out.println("Hash = " + Base64.getEncoder().encodeToString(buffer));
			
			textoAberto = "the quick brown fox jumps over the lazy cog"; //Hash = 7opkmVgxOq9R0Jt6lMYskQ==
			
			buffer = md.digest(textoAberto.getBytes());
			System.out.println("Hash = " + Base64.getEncoder().encodeToString(buffer));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
}
