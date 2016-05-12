package io.cloudslang.content.openstack.exceptions;

public class CustomException extends Exception {

    private int errorCode;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Exception ex) {
        super(ex);
    }

    public CustomException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomException(String message, Exception ex, int errorCode) {
        super(message, ex);
        this.errorCode = errorCode;
    }

}

