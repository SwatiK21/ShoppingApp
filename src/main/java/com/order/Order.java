package com.order;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
	private Integer id;
	private Integer userId; 
	private LocalDateTime date;
	private List<OrderItem> items;
	
	
	public Order(Integer id, Integer userId, LocalDateTime date, List<OrderItem> items) {
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
}
