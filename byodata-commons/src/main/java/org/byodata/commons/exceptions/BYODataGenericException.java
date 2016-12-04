package org.byodata.commons.exceptions;

import org.byodata.commons.api.View;
import org.byodata.commons.enums.BYODataErrorEnum;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Generic exception class
 * @author Giuseppe Vincenzi
 *
 */
public class BYODataGenericException extends Exception {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6943842923233038803L;
	
	/**
	 * BYODataErrorEnum
	 */
	private BYODataErrorEnum error;
	
	/**
	 * Constructor
	 * @param error BYODataErrorEnum
	 */
	public BYODataGenericException(BYODataErrorEnum error) {
		super(error.name());
		this.error=error;
	}
	
	/**
	 * Constructor
	 * @param error BYODataErrorEnum
	 * @param messageToLog String
	 */
	public BYODataGenericException(BYODataErrorEnum error, String messageToLog) {
		super(messageToLog);
		this.error=error;
	}

	/**
	 * @return the error
	 */
	public BYODataErrorEnum getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(BYODataErrorEnum error) {
		this.error = error;
	}
	
	@JsonView(View.BYODataException.class)
	public String getKey(){
		return this.error.getKey();
	}
	
	@JsonView(View.BYODataException.class)
	public int getCodeError(){
		return this.error.getCodeError();
	}
	
	@JsonView(View.BYODataException.class)
	public String getMessage(){
		return super.getMessage();
	}
}
