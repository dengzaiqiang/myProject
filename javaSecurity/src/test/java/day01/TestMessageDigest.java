package day01;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class TestMessageDigest {

	/**
	 * MD5加密
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void test01() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String beforeContent = "ab123456";
		System.out.println(beforeContent);
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bt = md.digest(beforeContent.getBytes("UTF-8"));
		System.out.println(convertToHexString(bt));
	}
	
	private static String convertToHexString(byte data[]) {
		  StringBuffer strBuffer = new StringBuffer();
		  for (int i = 0; i < data.length; i++) {
		   strBuffer.append(Integer.toHexString(0xff & data[i]));
		   //为何使用这个Integer.toHexString(0xff & data[i])
		   //请看http://blog.csdn.net/guo_rui22/article/details/2826308
		  }
		  return strBuffer.toString();
		 }
}
