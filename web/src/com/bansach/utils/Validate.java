package com.bansach.utils;

public class Validate {
	public static boolean isNumber(String value) {
		return value.matches("\\d+");
	}
	
	public static boolean isEmail(final String value) {
		if (value == null) return false;
		return value.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
	
	public static boolean isBirthday(final String value) {
		if (value == null) return false;
		return value.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((18|19|20)\\d\\d)");
	}
}
