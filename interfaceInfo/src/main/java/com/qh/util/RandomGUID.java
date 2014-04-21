package com.qh.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Ëæ»úÉú³ÉGUID
 * @author Administrator
 *
 */
public class RandomGUID {
	
	public String valueBeforeMD5="";
	public String valueAfterMD5 ="";
	private static Random myRand;
	private static SecureRandom mySecureRand;
	private static String s_id;
	private static final int PAD_BELOW = 0x10;
	private static final int TWO_BYTES =0xFF;
	
	static{
		mySecureRand = new SecureRandom();
		long secureInit = mySecureRand.nextLong();
		myRand = new Random(secureInit);
		
		try {
			s_id = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public RandomGUID(){
		getRandomGUID(true);
	}

	private void getRandomGUID(boolean secure) {
		MessageDigest md5 = null;
		StringBuffer sbValueBeforeMD5 = new StringBuffer(128);
		
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		long time = System.currentTimeMillis();
		long rand = 0;
		if(secure){
			rand = mySecureRand.nextLong();
		}else{
			rand = myRand.nextLong();
		}
		System.out.println(Long.toString(Math.abs(rand)).length());
		sbValueBeforeMD5.append(s_id);
		sbValueBeforeMD5.append(":");
		sbValueBeforeMD5.append(Long.toString(time));
		sbValueBeforeMD5.append(":");
		sbValueBeforeMD5.append(Long.toString(Math.abs(rand)));
		
		valueBeforeMD5 = sbValueBeforeMD5.toString();
		md5.update(valueBeforeMD5.getBytes());
		
		byte[] array = md5.digest();
		StringBuffer sb = new StringBuffer(array.toString());
		//StringBuffer sb = new StringBuffer(32);
		/*for(int i=0;i<array.length;++i){
			int b= array[i] & TWO_BYTES;
			if(b <PAD_BELOW){
				sb.append('0');
			}
			sb.append(Integer.toHexString(b));
		}*/
		valueAfterMD5 = sb.toString();
		
	}
	
	public String toString(){
		String raw = valueAfterMD5.toUpperCase();
		return raw;
	}
	
	public static void main(String[] args) {
		 RandomGUID myGUID = new RandomGUID();
		 System.out.println("Seeding String=" + myGUID.valueBeforeMD5);
		 System.out.println("rawGUID=" + myGUID.valueAfterMD5);
		 System.out.println("RandomGUID=" + myGUID.toString());
	}

}
