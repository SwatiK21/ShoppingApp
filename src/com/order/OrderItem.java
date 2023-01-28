package com.order;

import com.product.Product;

public class OrderItem {

	private Integer id;
	private Integer orderId;
	private Product product;
	private Integer quantity;
	
	

	public OrderItem(Integer id, Integer orderId, Product product, Integer quantity) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
