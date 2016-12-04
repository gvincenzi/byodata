package org.byodata.commons.exceptions;

import org.byodata.commons.enums.BYODataErrorEnum;

public class BYODataRequestException extends BYODataGenericException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6710177617104056143L;

	/**
	 * Constructor
	 * @param error BYODataErrorEnum
	 */
	public BYODataRequestException(BYODataErrorEnum error) {
		super(error);
	}

	/**
	 * Constructor
	 * @param error BYODataErrorEnum
	 * @param messageToLog String
	 */
	public BYODataRequestException(BYODataErrorEnum error, String messageToLog) {
		super(error, messageToLog);
	}
}
