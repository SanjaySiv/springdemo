package com.springmvc.model;

public class CarDates {
	private int carId;
	private String bookingDate;
	private String returnDate;
	private int customer_id;
	private int rentAmount;
	public int getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(int rentAmount) {
		this.rentAmount = rentAmount;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
}
