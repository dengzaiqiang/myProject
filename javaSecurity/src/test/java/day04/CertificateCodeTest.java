package day04;

import javax.crypto.EncryptedPrivateKeyInfo;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 证书校验
 * @author Administrator
 *
 */
public class CertificateCodeTest {
	
	private String password = "ab123456";
	private String alias = "dzq";
	private String certificatePath = "C:\\Users\\Administrator\\dzq.cer";
	private String keyStorePath = "C:\\Users\\Administrator\\dzq.keystore";
	@Test
	public void test01() throws Exception{
		System.out.println("公钥加密 ----私钥解密");
		String inputStr = "数字证书";
		byte[] data = inputStr.getBytes();
		//公钥加密
		byte[] encrypt = CertificateCoder.encryptByPublicKey(data, certificatePath);
		//私钥解密
		byte[] decrypt = CertificateCoder.decryptByPrivateKey(encrypt, keyStorePath, alias, password);
		
		String outputStr = new String(decrypt);
		System.out.println(inputStr);
		System.out.println(outputStr);
		//Assert.assertSame(data, decrypt);
		
	}
	
	@Test
	public void test02() throws Exception{
		System.out.println("私钥加密----公钥解密");
		String inputStr = "数字签名";
		byte[] data = inputStr.getBytes();
		//私钥加密
		byte[] encrypt = CertificateCoder.encryptByPrivateKey(data, keyStorePath, alias, password);
		//公钥解密
		byte[] decrypt = CertificateCoder.decryptByPublicKey(encrypt, certificatePath);
		
		String outputStr = new String(decrypt);
		System.out.println(inputStr);
		System.out.println(outputStr);
		
	}
	
	@Test
	public void testSign() throws Exception{
		String inputStr = "签名";
		byte[] data = inputStr.getBytes();
		System.out.println("私钥签名----公钥验证");
		//签名
		byte[] sign = CertificateCoder.sign(data, keyStorePath, alias, password);
		//验证
		boolean flag = CertificateCoder.verfiy(data, sign, certificatePath);
		System.out.println(flag);
	}

}
