package com.suyan.user.util;

import java.util.Random;

public class CodeGeneratorUtil {
	private static Random random = new Random();
//	private final static String NUMBERS_LETTER = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String NUMBERS_UPPERLETTER =  "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String NUMBERS_LOWERCASE =  "0123456789abcdefghijklmnopqrstuvwxyz";
	private final static String NUMBERS =  "123456789";
	private final static int USER_OPEN_ID_LENGTH =  12;
	private final static int SYSTEM_CLIENT_ID_LENGTH =  9;
	private final static int SYSTEM_CLIENT_SECRET_LENGTH =  16;

	/**
	 * 生成length长度的随机码
	 * @param length
	 * @return
	 */
	private static String getRandomString(int length, String source) {
		if (length <= 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(source.length());
			sb.append(source.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 生成用户id
	 * @return
	 */
	public static String generateUserOpenId(){
		return getRandomString(USER_OPEN_ID_LENGTH, NUMBERS_LOWERCASE);
	}

	/**
	 * 生成系统应用id
	 * @return
	 */
	public static String generateSystemClientId(){
		return getRandomString(SYSTEM_CLIENT_ID_LENGTH, NUMBERS_LOWERCASE);
	}

	/**
	 * 生成系统应用secret
	 * @return
	 */
	public static String generateSystemClientSecret(){
		return getRandomString(SYSTEM_CLIENT_SECRET_LENGTH, NUMBERS_LOWERCASE);
	}
	
	
	/**
	 * main测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(generateSystemClientId());
	}
}
