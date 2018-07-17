package com.egiants.mrkt.Exceptions;

public class MismatchIdentifierException extends MarketingServiceException {

    private static final long serialVersionUID = 1L;
    private static final String ERROR_MESSAGE =
            "EmailId in header param %s doesn't matches with user request body";

    public MismatchIdentifierException(String callId) {
        super(String.format(ERROR_MESSAGE, callId));
    }

}
