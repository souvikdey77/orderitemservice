package com.tech.order.orderitemservice.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.order.orderitemservice.dao.OrderItemRepository;
import com.tech.order.orderitemservice.entity.OrderItem;
import com.tech.order.orderitemservice.service.OrderItemService;

/**
 * 
 * @author souvikdey
 *
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository repository;

	@Override
	public OrderItem getOrderItem(int productId) {
		Optional<OrderItem> item = repository.findById(productId);
		if (item.isPresent()) {
			return item.get();
		}
		return null;
	}

	@Override
	public String createOrderItem(Set<OrderItem> orderItem) {
		repository.saveAll(orderItem);
		return "All the orders items are successfully created";
	}

	@Override
	public Integer updateOrderItem(OrderItem orderItem, int productId) {
		OrderItem newItem = null;
		Optional<OrderItem> item = repository.findById(productId);
		if (item.isPresent()) {
			OrderItem oldItem = item.get();
			oldItem.setProductName(orderItem.getProductName());
			oldItem.setQuantity(orderItem.getQuantity());
			newItem = repository.save(oldItem);
			return newItem.getProductCode();
		}
		return null;
	}

	@Override
	public void deleteOrderItem(int productId) {
		repository.deleteById(productId);
	}

}
