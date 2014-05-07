package day04;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.crypto.Cipher;

public abstract class CertificateCoder {
	//证书类型
	public static final String CERT_TYPE = "X.509";
	
	public static boolean verfiy(byte[] data,byte[] sign,String certificatePath)
		throws Exception{
		X509Certificate x509cert = (X509Certificate)getCertificate(certificatePath);
		Signature signature = Signature.getInstance(x509cert.getSigAlgName());
		signature.initVerify(x509cert);
		signature.update(data);
		return signature.verify(sign);
	}
	
	/**
	 * 签名
	 * @param sign
	 * @param keyStorePath
	 * @param alias
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static byte[] sign(byte[] sign,String keyStorePath,String alias,
			String password) throws Exception{
		X509Certificate x509cert = (X509Certificate)getCertificate(keyStorePath, alias, password);
		Signature signature =Signature.getInstance(x509cert.getSigAlgName());
		PrivateKey privateKey = getPrivateKeyByKeyStore(keyStorePath, alias, password);
		signature.initSign(privateKey);
		signature.update(sign);
		return signature.sign();
	}
	
	
	/**
	 * 公钥解密
	 * @param data
	 * @param certificatePath
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data,String certificatePath) throws Exception{
		PublicKey publicKey = getPublicKeyByCertificate(certificatePath);
		Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}
	
	/**
	 * 公钥加密
	 * @param data
	 * @param certificatePath
	 * @return
	 */
	public static byte[] encryptByPublicKey(byte[] data,String certificatePath)
		throws Exception{
		PublicKey publicKey = getPublicKeyByCertificate(certificatePath);
		Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}
	
	
	/**
	 * 私钥解密
	 * @param data
	 * @param keyStorePath
	 * @param alias
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data,String keyStorePath,
			String alias,String password) throws Exception{
		PrivateKey privateKey = getPrivateKeyByKeyStore(keyStorePath, alias, password);
		Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}
	
	/**
	 * 私钥加密数据
	 * @param data
	 * @param keyStorePath
	 * @param alias
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data,String keyStorePath,
			String alias,String password) throws Exception{
		PrivateKey privateKey = getPrivateKeyByKeyStore(keyStorePath, alias, password);
		Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}
	
	/**
	 * 通过密钥库获取证书
	 * @param keyStorePath
	 * @param alias
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static Certificate getCertificate(String keyStorePath,
			String alias,String password) throws Exception{
		KeyStore ks = getKeyStore(keyStorePath, password);
		return ks.getCertificate(alias);
	}
	
	/**
	 * 通过证书获取公钥
	 * @param certificatePath
	 * @return
	 * @throws Exception
	 */
	private static PublicKey getPublicKeyByCertificate(String certificatePath)
		throws Exception{
		Certificate cert = getCertificate(certificatePath);
		return cert.getPublicKey();
	}
	/**
	 * 获取证书
	 * @param certificatePath
	 * @return
	 * @throws Exception
	 */
	private static Certificate getCertificate(String certificatePath)
		throws Exception{
		CertificateFactory factory = CertificateFactory.getInstance(CERT_TYPE);
		FileInputStream fis = new FileInputStream(certificatePath);
		Certificate cert = factory.generateCertificate(fis);
		fis.close();
		return  cert;
	}
	
	/**
	 * 获取私钥
	 * @param keyStorePath
	 * @param alias
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static PrivateKey getPrivateKeyByKeyStore(String keyStorePath,
			String alias,String password) throws Exception{
		KeyStore keyStore = getKeyStore(keyStorePath, password);
		//密钥库获取私钥
		return (PrivateKey)keyStore.getKey(alias, password.toCharArray());
	}
	
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
		fis.close();
		return keyStore;
	}

}
