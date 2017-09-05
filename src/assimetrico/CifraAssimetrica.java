package assimetrico;

import java.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CifraAssimetrica {
	
	static String ALG = "RSA";
	static KeyPairGenerator gerador;
	static KeyPair chave;
	static String textoAberto;
	static Cipher cifra;

	public static void main(String[] args) {
		try {
			gerador = KeyPairGenerator.getInstance(ALG); 
			chave = gerador.genKeyPair(); 
 			textoAberto = "the quick brown fox jumps over the lazy dog";
	        cifra = Cipher.getInstance(ALG);

	        cifra.init(Cipher.ENCRYPT_MODE, chave.getPublic());
	        byte[] buffer = cifra.doFinal(textoAberto.getBytes());
	        
	        System.out.println("Texto aberto = " + textoAberto + " Tamanho = " + textoAberto.length());
	        System.out.println("Texto cifrado = " + new String(Base64.getEncoder().encode(buffer)) 
								+ " Tamanho = " + buffer.length);
	        
	        cifra.init(Cipher.DECRYPT_MODE, chave.getPrivate());
	        buffer = cifra.doFinal(buffer);
	        
	        System.out.println("Texto recuperado = " + new String(buffer));
	        
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
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
