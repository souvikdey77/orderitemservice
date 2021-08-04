package com.tech.order.orderitemservice.exception;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class OrderItemNotFoundExceptionHandler {

	@ExceptionHandler(value = OrderItemNotFoundException.class)
	public ResponseEntity<Object> orderItemNotFoundException(OrderItemNotFoundException ex, WebRequest request) {
		Map<String, Object> details = new LinkedHashMap<>();
		details.put("timestamp", now());
		details.put("message", ex.getMessage());
		return new ResponseEntity<>(details, NOT_FOUND);
	}
}
