package day02;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * 基于口令的对称加密
 * 
 * @author Administrator
 * 
 */
public class SecretKeyForPBTest {

	public static void main(String[] args) throws Exception{
		byte[] result = encryptSecret();
		decryptSecret(result);
	}

	private static byte[] encryptSecret() throws Exception {
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		// 使用密码生成key
		KeySpec keySpec = new PBEKeySpec("dengzaiqiang".toCharArray());
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
				.generateSecret(keySpec);
		//88888888为算法的盐，是个八位的字节数组，加解密的盐必须一致
		PBEParameterSpec param = new PBEParameterSpec("88888888".getBytes(),10);
		cipher.init(Cipher.ENCRYPT_MODE, key,param);

		byte[] result = cipher.doFinal("abc".getBytes());

		return result;
	}

	private static void decryptSecret(byte[] result) throws Exception{
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		//使用密码生成key
		KeySpec keySpec = new PBEKeySpec("dengzaiqiang".toCharArray());
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
				.generateSecret(keySpec);
		PBEParameterSpec param = new PBEParameterSpec("88888888".getBytes(),10);
		cipher.init(Cipher.DECRYPT_MODE, key,param);
		byte[] src = cipher.doFinal(result);
		System.out.println(new String(src));
	}
}
