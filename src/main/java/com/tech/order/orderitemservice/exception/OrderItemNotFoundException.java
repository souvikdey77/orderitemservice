package com.tech.order.orderitemservice.exception;

/**
 * 
 * @author souvikdey
 *
 */
public class OrderItemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7302024063616216936L;
	
	public OrderItemNotFoundException(String message) {
		super(message);
	}

}
