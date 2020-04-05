package com.bank.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author saluri
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommonCustomException extends RuntimeException{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1463417615831199530L;

	public CommonCustomException(String e) {
		super(e);
	}
}
