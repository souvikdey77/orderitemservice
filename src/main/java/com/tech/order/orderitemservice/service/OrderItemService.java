package com.tech.order.orderitemservice.service;

import java.util.Set;

import com.tech.order.orderitemservice.entity.OrderItem;

/**
 * 
 * @author souvikdey
 *
 */

public interface OrderItemService {

	public OrderItem getOrderItem(int productId);

	public String createOrderItem(Set<OrderItem> orderItems);

	public Integer updateOrderItem(OrderItem orderItem, int productId);

	public void deleteOrderItem(int productId);

}
