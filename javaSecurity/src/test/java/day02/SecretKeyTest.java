package day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * 对称加密与解密AES
 * @author Administrator
 *
 */
public class SecretKeyTest {

	public static void main(String[] args) throws Exception {
		byte[] result = encryptKey();
		decryptSecret(result);
	}
	
	//加密后返回字符串
	private static byte[] encryptKey() throws Exception{
		
		Cipher cipher = Cipher.getInstance("AES");
		//生成密钥,解密必须用此key才能解
		SecretKey key = KeyGenerator.getInstance("AES").generateKey();
		//将key保存到文件，用于传输
		FileOutputStream fosKey = new FileOutputStream("secret.key");
		ObjectOutputStream oos = new ObjectOutputStream(fosKey);
		oos.writeObject(key);
		oos.close();
		fosKey.close();
		//既可以加密，又可以解密，所以要初始化
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] result = cipher.doFinal("abc".getBytes());
		return result;
	}
	
	public static void decryptSecret(byte[] result) throws Exception{
		Cipher cipher = Cipher.getInstance("AES");
		//从文件 中获取key
		FileInputStream fisKey = new FileInputStream("secret.key");
		ObjectInputStream ois = new ObjectInputStream(fisKey);
		Key key = (Key)ois.readObject();
		ois.close();
		fisKey.close();
		
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] src = cipher.doFinal(result);
		System.out.println(new String(src));
	}
}
