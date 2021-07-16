package com.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.AdminDao;
import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Users;

@org.springframework.stereotype.Service
public class AdminService {	
	@Autowired
	AdminDao adminDao;
	public List<Users> viewCustomers() {
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
	public void deleteCustomer(int userId) {
		adminDao.deleteCustomer(userId);
	}
	public void updateRent(int carId, int rent) {
		adminDao.updateRent(carId, rent);
	}
	public void insertUser(Users users) {
		adminDao.insertUser(users);
	}
	public List<Users> viewAdmins() {
		return adminDao.viewAdmins();
	}
	
	
	
	
	public List<Users> viewDealers() {
		return adminDao.viewdealers();
	}
	public void insertDealer(Users users) {
		adminDao.insertDealer(users);
	}
	public void deleteDealer(int userId) {
		adminDao.deleteDealer(userId);
	}
}