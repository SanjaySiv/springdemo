package com.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.AdminDao;
import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;

@org.springframework.stereotype.Service
public class AdminService {	
	@Autowired
	AdminDao adminDao;
	public List<Customer> viewCustomers() {
		return adminDao.viewCustomers();
	}
	public List<Cars> showCars() {
		return adminDao.showCars();
	}
	public List<CarDates> viewBookings() {
		return adminDao.viewBookings();
	}
	public void deleteCar(int carId) {
		adminDao.deleteCar(carId);
	}
	public void addCar(Cars cars) {
		adminDao.addCar(cars);
	}
	public void deleteCustomer(int customer_id) {
		adminDao.deleteCustomer(customer_id);
	}
	public void updateRent(int carId, int rent) {
		adminDao.updateRent(carId, rent);
	}
	public void insertAdmin(Customer customer) {
		adminDao.insertAdmin(customer);
	}
	public List<Customer> viewAdmins() {
		return adminDao.viewAdmins();
	}
}