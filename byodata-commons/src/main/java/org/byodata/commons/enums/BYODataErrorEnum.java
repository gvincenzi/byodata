package org.byodata.commons.enums;

/**
 * Error messages enumeration
 * @author Giuseppe Vincenzi
 *
 */
public enum BYODataErrorEnum {
	LOGIN_ERROR("login.error"),
	LOGIN_PERMISSION_ERROR("login.permission.error");
	
	/**
	 * Key message used by Spring MVC
	 */
	private String key;
	
	/**
	 * Constructor
	 * @param key String
	 */
	private BYODataErrorEnum(String key) {
		this.setKey(key);
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
}
