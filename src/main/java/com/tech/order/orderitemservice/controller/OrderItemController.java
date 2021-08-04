package com.tech.order.orderitemservice.controller;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.order.orderitemservice.entity.OrderItem;
import com.tech.order.orderitemservice.exception.OrderItemNotFoundException;
import com.tech.order.orderitemservice.impl.OrderItemServiceImpl;

@RestController
@RequestMapping(value = "/orderitemmanagement")
public class OrderItemController {

	@Autowired
	private OrderItemServiceImpl service;

	@GetMapping(value = "/api/v1/orderitem/{productId}")
	public ResponseEntity<OrderItem> getOrderItem(@PathVariable(required = true) int productId) {
		OrderItem item = service.getOrderItem(productId);
		if (item == null) {
			throw new OrderItemNotFoundException("OrderItem is not available with product id " + productId);
		}
		return new ResponseEntity<OrderItem>(item, OK);
	}

	@PostMapping(value = "/api/v1/orderItem")
	public ResponseEntity<String> createOrderItem(@RequestBody @Valid Set<OrderItem> orderItem) {
		String message = service.createOrderItem(orderItem);
		return new ResponseEntity<String>(message, CREATED);
	}

	@PutMapping(value = "/api/v1/updateItem/{productId}")
	public ResponseEntity<Integer> updateOrderItem(@RequestBody @Valid OrderItem orderItem, @PathVariable int productId) {
		Integer newProduct = service.updateOrderItem(orderItem,productId);
		if (newProduct == null) {
			throw new OrderItemNotFoundException("Order item is not available for update!");
		}
		return new ResponseEntity<Integer>(newProduct, ACCEPTED);
	}

	@DeleteMapping(value = "/api/v1/{productId}")
	public void deleteOrderItem(@PathVariable(required = true) int productId) {
		service.deleteOrderItem(productId);
	}

}
