package day03;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * 数字签名
 * @author Administrator
 *
 */
public class NumberSignTest {
	/**
	 * 私钥签名，公钥验证
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		
		Signature signature = Signature.getInstance("MD5withRSA");
		//私钥签名
		signature.initSign(privateKey);
		signature.update("abc".getBytes());
		//签名完成
		byte[] results = signature.sign();
		
		//公钥校验数据
		signature.initVerify(publicKey);
		//如果数据不一样，则会返回false
		//signature.update("123".getBytes());
		signature.update("abc".getBytes());
		boolean flag = signature.verify(results);
		System.out.println(flag);
		
	}

}
