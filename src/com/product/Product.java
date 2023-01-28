package com.product;

public class Product {

	private Integer id;
	private String type;
	private String name;
	private String description;
	private String image;
	private Double price;
	
	public Product(Integer id, String type, String name, String description, String image, Double price) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
