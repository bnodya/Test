package com.shaman.servlet.model;

import com.shaman.servlet.controller.transformer.annotation.DBColumn;

public class Item {

	@DBColumn(name = "item_id")
	private int id;
	@DBColumn(name = "name")
	private String name;
	@DBColumn(name = "description")
	private String description;
	@DBColumn(name = "price")
	private double price;
	@DBColumn(name = "picture")
	private String picture;
	@DBColumn(name = "type")
	private boolean type;
	
		
	
	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", type=" + (type == false?"Food":"Drink") + "]";
	}
}
