package com.egiants.mrkt.Exceptions;

public class MarketingServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE = "User information with %s doesn't exists";

	public MarketingServiceException(String callId) {
		super(String.format(ERROR_MESSAGE, callId));
	}

}
