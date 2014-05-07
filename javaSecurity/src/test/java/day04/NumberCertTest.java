package day04;

import java.io.FileInputStream;
import java.security.KeyStore;

/**
 * 操作数字证书
 * @author Administrator
 *
 */
public class NumberCertTest {
	
	/**
	 * 获得密钥库
	 * @param keyStorePath
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static KeyStore getKeyStore(String keyStorePath,String password)
		throws Exception{
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		FileInputStream fis = new FileInputStream(keyStorePath);
		keyStore.load(fis, password.toCharArray());
		return keyStore;
	}
	
	public static void main(String[] args) throws Exception{
		KeyStore keyStore = getKeyStore("C:\\Users\\Administrator\\dzq.keystore","ab123456");
		System.out.println(keyStore);
	}

}
