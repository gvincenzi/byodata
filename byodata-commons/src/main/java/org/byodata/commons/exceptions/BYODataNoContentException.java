package org.byodata.commons.exceptions;

import org.byodata.commons.enums.BYODataErrorEnum;

public class BYODataNoContentException extends BYODataGenericException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4448102699375820237L;

	/**
	 * Constructor
	 * @param error BYODataErrorEnum
	 */
	public BYODataNoContentException(BYODataErrorEnum error) {
		super(error);
	}

	/**
	 * Constructor
	 * @param error BYODataErrorEnum
	 * @param messageToLog String
	 */
	public BYODataNoContentException(BYODataErrorEnum error, String messageToLog) {
		super(error, messageToLog);
	}
}
