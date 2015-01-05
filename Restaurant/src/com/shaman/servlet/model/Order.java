package com.shaman.servlet.model;

import com.shaman.servlet.controller.transformer.annotation.DBColumn;

public class Order {
	
	@DBColumn(name = "order_id")
	private int id;
	@DBColumn(name = "detail_id")
	private int detailId;
	@DBColumn(name = "user_id")
	private int userId;
	@DBColumn(name = "admin_id")
	private int adminId;
	@DBColumn(name = "date")
	private String date;
	@DBColumn(name = "applied")
	private boolean applied;
	@DBColumn(name = "ready")
	private boolean ready;
	@DBColumn(name = "paid")
	private boolean paid;
	@DBColumn(name = "price")
	private double price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isApplied() {
		return applied;
	}
	public void setApplied(boolean applied) {
		this.applied = applied;
	}
	public boolean isReady() {
		return ready;
	}
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", detailId=" + detailId + ", userId="
				+ userId + ", adminId=" + adminId + ", date=" + date
				+ ", applied=" + (applied == true?"yes":"no") + ", ready=" + (ready == true?"yes":"no") + ", paid="
				+ (paid == true?"yes":"no") + ", price=" + price + "]";
	}
	
	
}
