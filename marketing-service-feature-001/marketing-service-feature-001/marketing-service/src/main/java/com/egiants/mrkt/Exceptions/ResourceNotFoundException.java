package com.egiants.mrkt.Exceptions;

public class ResourceNotFoundException extends MarketingServiceException {

    public ResourceNotFoundException(String callId) {
        super(callId);
    }
}
