package day03;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

/**
 * 非对称加密 RSA (比较慢)
 * @author Administrator
 *
 */
public class KeyPairTest {
	
	public static void main(String[] args) throws Exception{
		Cipher cipher = Cipher.getInstance("RSA");
		//生成公钥和私钥
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		//私钥加密的用公钥才能解密
		//公钥加密
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] results = cipher.doFinal("abc".getBytes());
		System.out.println(new String(results));
		//私钥解密
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] src = cipher.doFinal(results);
		System.out.println(new String(src));
	}
	
}
