package com.shaman.servlet.model;

import com.shaman.servlet.controller.transformer.annotation.DBColumn;

public class Dish {

	@DBColumn(name = "dish_id")
	private int id;
	@DBColumn(name = "name")
	private String name;
	@DBColumn(name = "description")
	private String description;
	@DBColumn(name = "price")
	private double price;

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
				+ description + ", price=" + price + "]";
	}
}
