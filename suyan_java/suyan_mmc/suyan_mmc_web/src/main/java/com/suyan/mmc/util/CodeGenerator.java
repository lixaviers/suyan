package com.suyan.mmc.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CodeGenerator {
	private static Random random = new Random();
	private final static String NUMBERS_UPPERLETTER =  "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String NUMBERS =  "123456789";
	private final static int COUPON_CODE_LENGTH =  9;
	
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
	 * 生成优惠券券码
	 * @return
	 */
	public static String generateCouponCode(){
		return getRandomString(COUPON_CODE_LENGTH, NUMBERS_UPPERLETTER);
	}
	
	/**
	 * 生成虚拟商品sku
	 * @return
	 */
	public static String generateItemNo(){
		return getRandomString(COUPON_CODE_LENGTH, NUMBERS);
	}
	
	public static Set<String> generateCouponCode(int codeAnount){
		Set<String> codes = new HashSet<>(codeAnount);
		for(int i = 0 ; i < codeAnount ; i++){
			codes.add(generateCouponCode());
		}
		return codes;
	}

}
