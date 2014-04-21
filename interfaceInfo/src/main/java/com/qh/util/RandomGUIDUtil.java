package com.qh.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomGUIDUtil {

	public static String getRandomGUID(){
		SecureRandom secureRand = new SecureRandom();
		Random rand = new Random(secureRand.nextLong());
		return Long.toString(Math.abs(rand.nextLong()));
	}
}
