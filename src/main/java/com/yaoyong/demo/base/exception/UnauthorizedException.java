package com.yaoyong.demo.base.exception;

public class UnauthorizedException extends RuntimeException  {

	  public UnauthorizedException(String msg) {
	        super(msg);
	    }

	    public UnauthorizedException() {
	        super();
	    }

}
