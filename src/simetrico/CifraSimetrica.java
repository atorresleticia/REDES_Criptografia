package simetrico;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class CifraSimetrica {
	
	static String ALG = "AES";
	static KeyGenerator gerador;
	static SecretKey chave;
	static String textoAberto;
	static Cipher cifra;
	
	public static void main(String[] args) {
		try {
			gerador = KeyGenerator.getInstance(ALG);
			chave = gerador.generateKey();  
	        textoAberto = "the quick brown fox jumps over the lazy dog";
	        cifra = Cipher.getInstance(ALG);
	        
	        cifra.init(Cipher.ENCRYPT_MODE, chave);
	        byte[] buffer = cifra.doFinal(textoAberto.getBytes());
	        
	        System.out.println("Texto aberto = " + textoAberto + " Tamanho = " + textoAberto.length());
	        System.out.println("Texto cifrado = " + new String(Base64.getEncoder().encode(buffer)) 
	        					+ " Tamanho = " + buffer.length);

	        cifra.init(Cipher.DECRYPT_MODE, chave);
	        buffer = cifra.doFinal(buffer);
	        
	        System.out.println("Texto recuperado = " + new String(buffer));
	        
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
