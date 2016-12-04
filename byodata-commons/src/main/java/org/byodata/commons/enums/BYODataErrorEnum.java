package org.byodata.commons.enums;

/**
 * Error messages enumeration
 * @author Giuseppe Vincenzi
 *
 */
public enum BYODataErrorEnum {
	INPUT_GET_USER_PARAMETER_ERROR(4001, "input.get.user.parameter.error"),
	INPUT_GET_USER_NOT_EXISTS_ERROR(4002, "input.get.user.not.exists.error"),
	LOGIN_PERMISSION_ERROR(4011,"login.permission.error"),
	LOGIN_ERROR(4012,"login.error");
	
	/**
	 * Key message used by Spring MVC
	 */
	private final String key;
	
	/**
	 * Error code
	 */
	private final int codeError;
	
	/**
	 * Constructor
	 * @param key String
	 */
	private BYODataErrorEnum(int value, String key) {
		this.key = key;
		this.codeError = value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the value
	 */
	public int getCodeError() {
		return codeError;
	}
	
}
