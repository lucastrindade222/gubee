package br.com.lucas.gudee.resource.exception;

public class ConstraintViolationException extends RuntimeException {
	 private static final long serialVersionUID = 1L;

	    public ConstraintViolationException(String msg) {
	        super(msg);
	    }

	    public ConstraintViolationException(String msg, Throwable cause) {
	        super(msg, cause);
	    }

}
