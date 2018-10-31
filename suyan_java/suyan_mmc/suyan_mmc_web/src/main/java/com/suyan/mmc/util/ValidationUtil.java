package com.suyan.mmc.util;

import com.suyan.mmc.result.MmcResult;
import com.suyan.mmc.result.MmcResultCode;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.regex.Pattern;

public abstract class ValidationUtil {

	public static boolean isNullOrEmpty(MmcResult<?> message, String fieldName, String value) {
		if (hasText(value)) {
			return false;
		}
		message.setErrorCode(MmcResultCode.FIELD_NOT_ALLOWED_EMPTY, fieldName);
		return true;
	}

	public static boolean isNotNullOrEmpty(MmcResult<?> message, String fieldName, String value) {
		return !isNullOrEmpty(message, fieldName, value);
	}

	public static boolean isEmptyOrLessThan(
			MmcResult<?> message,
			String fieldName,
			String value,
			int minLength) {
		return validate(message, fieldName, value, minLength, 0);
	}

	public static boolean isLessThan(
			MmcResult<?> message,
			String fieldName,
			String value,
			int minLength) {
		return validate(message, fieldName, true, value, minLength, 0);
	}

	public static boolean isLessThan(
			MmcResult<?> message,
			String fieldName,
			BigDecimal value,
			double minValue) {

		if (value == null) {
			return true;
		}
		if (value.floatValue() < minValue) {
			message.setErrorCode(MmcResultCode.FIELD_VALUE_MUST_LARGE_THAN, fieldName,minValue);
			return false;
		}
		return true;
	}

	public static boolean isMoreThan(
			MmcResult<?> message,
			String fieldName,
			BigDecimal value,
			double maxValue) {

		if (value == null) {
			return true;
		}
		if (value.floatValue() > maxValue) {
			message.setErrorCode(MmcResultCode.FIELD_VALUE_MUST_LESS_THAN,
					fieldName,maxValue);
			return false;
		}
		return true;
	}

	public static boolean isLessThan(
			MmcResult<?> message,
			String fieldName,
			Integer value,
			int minValue) {

		if (value == null) {
			return true;
		}
		if (value.intValue() < minValue) {
			message.setErrorCode(MmcResultCode.FIELD_VALUE_MUST_LARGE_THAN,
					fieldName);
			return false;
		}
		return true;
	}

	public static boolean isMoreThan(
			MmcResult<?> message,
			String fieldName,
			Integer value,
			int maxValue) {

		if (value == null) {
			return false;
		}
		if (value.intValue() > maxValue) {
			message.setErrorCode(MmcResultCode.FIELD_VALUE_MUST_LARGE_THAN,
					fieldName, maxValue);
			return false;
		}
		return true;
	}

	public static boolean isLessThan(
			MmcResult<?> message,
			String fieldName,
			Long value,
			long minValue) {

		if (value == null) {
			return true;
		}
		if (value.longValue() < minValue) {
			message.setErrorCode(MmcResultCode.FIELD_VALUE_MUST_LARGE_THAN,
					fieldName);
			return false;
		}
		return true;
	}

	public static boolean isMoreThan(
			MmcResult<?> message,
			String fieldName,
			Long value,
			long maxValue) {

		if (value == null) {
			return true;
		}
		if (value.longValue() > maxValue) {
			message.setErrorCode(MmcResultCode.FIELD_VALUE_MUST_LARGE_THAN,
					fieldName);
			return false;
		}
		return true;
	}

	public static boolean isEmptyOrMoreThan(
			MmcResult<?> message,
			String fieldName,
			String value,
			int maxLength) {
		return validate(message, fieldName, value, 0, maxLength);
	}

	public static boolean isMoreThan(
			MmcResult<?> message,
			String fieldName,
			String value,
			int maxLength) {
		return validate(message, fieldName, true, value, 0, maxLength);
	}

	public static boolean isEmptyOrNotInRange(
			MmcResult<?> message,
			String fieldName,
			String value,
			int minLength,
			int maxLength) {
		return validate(message, fieldName, value, minLength, maxLength);
	}

	public static boolean isNotInRange(
			MmcResult<?> message,
			String fieldName,
			String value,
			int minLength,
			int maxLength) {
		return validate(message, fieldName, true, value, minLength, maxLength);
	}

	public static boolean validate(
			MmcResult<?> message,
			String fieldName,
			String value,
			int minLength,
			int maxLength)
	{
		return validate(message, fieldName, false, value, minLength, maxLength);
	}

	public static boolean validate(
			MmcResult<?> message,
			String fieldName,
			Boolean isAllowEmpty,
			String value,
			int minLength,
			int maxLength) {

		if (isAllowEmpty) {
			if (!hasText(value)) {
				return false;
			}
		} else if (isNullOrEmpty(message, fieldName, value)) {
			return true;
		}
		int length = value.length();
		if (minLength > 0 && maxLength < 1 && length < minLength) {
			message.setErrorCode(MmcResultCode.FIELD_LENGTH_MUST_MORE, fieldName, minLength);
			return true;
		}
		if (maxLength > 0 && minLength < 1 && length > maxLength) {
			message.setErrorCode(MmcResultCode.FIELD_LENGTH_MUST_LESS, fieldName, maxLength);
			return true;
		}
		if (maxLength > 0 && minLength > 0 && (length > maxLength || length < minLength)) {
			message.setErrorCode(MmcResultCode.FIELD_LENGTH_MUST_BETWEEN, fieldName, minLength, maxLength);
			return true;
		}
		return false;
	}


	private final static Pattern userNamePattern = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9]{5,19}");

	/**
	 * 是否是合法的用户名
	 *
	 * @param message
	 * @param fieldName
	 * @param value
	 * @return boolean
	 * @throws null
	 * @author lixavier
	 */
	public static boolean isValidUserName(MmcResult<?> message, String fieldName, String value) {

		if (isNullOrEmpty(message, fieldName, value)) {
			return false;
		}
		if (userNamePattern.matcher(value).find()) {
			return true;
		}
		message.setErrorCode(MmcResultCode.FIELD_NOT_EMAIL, fieldName);
		return false;
	}

	private final static Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

	/**
	 * 是否是合法的邮箱地址
	 * 
	 * @param message
	 * @param fieldName
	 * @param value
	 * @return boolean
	 * @throws null
	 * @author lixavier
	 */
	public static boolean isValidEmail(MmcResult<?> message, String fieldName, String value) {

		if (isNullOrEmpty(message, fieldName, value)) {
			return false;
		}
		if (emailPattern.matcher(value).find()) {
			return true;
		}
		message.setErrorCode(MmcResultCode.FIELD_NOT_EMAIL, fieldName);
		return false;
	}

	private final static Pattern mobilePattern = Pattern.compile("^1[34578]\\d{9}$");

	/**
	 * 是否是合法的手机号
	 * 
	 * @param message
	 * @param fieldName
	 * @param value
	 * @return boolean
	 * @throws null
	 * @author lixavier
	 */
	public static boolean isValidMobile(MmcResult<?> message, String fieldName, String value) {
		if (isNullOrEmpty(message, fieldName, value)) {
			return false;
		}
		if (mobilePattern.matcher(value).matches()) {
			return true;
		}
		message.setErrorCode(MmcResultCode.FIELD_NOT_MOBILE, fieldName);
		return false;
	}

	private final static Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");

	/**
	 * 是否是合法的身份号码
	 * 
	 * @param message
	 * @param fieldName
	 * @param value
	 * @return boolean
	 * @throws null
	 * @author lixavier
	 */
	public static boolean isValidIDNumber(MmcResult<?> message, String fieldName, String value) {
		if (idNumPattern.matcher(value).matches()) {
			return true;
		}
		message.setErrorCode(MmcResultCode.FIELD_NOT_ID_NUM, fieldName);
		return false;
	}

	/**
	 * 是否为空，用于判断非字符串变量
	 * 
	 * @param message
	 * @param fieldName
	 * @param obj
	 * @return boolean
	 * @throws null
	 * @author lixavier
	 */
	public static boolean isNull(MmcResult<?> message, String fieldName, Object obj) {
		if (obj == null) {
			message.setErrorCode(MmcResultCode.FIELD_NOT_ALLOWED_EMPTY, fieldName);
			return true;
		}
		return false;
	}

	/**
	 * 是否是合法的日期
	 * 
	 * @param message
	 * @param dateInMs
	 * @return boolean
	 * @throws null
	 * @author lixavier
	 */
	public static boolean isValidDate(MmcResult<?> message, String fieldName, long dateInMs) {
		try {
			if (dateInMs <= 0) {
				message.setErrorCode(MmcResultCode.FIELD_NOT_ALLOWED_EMPTY, fieldName);
				return false;
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(dateInMs);
			return true;
		} catch (Exception e) {
			message.setErrorCode(MmcResultCode.FIELD_NOT_DATE, fieldName);
			return false;
		}

	}

	public static boolean hasText(String value) {
		return StringUtils.hasText(value);
	}
}
