package com.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.DealerDao;
import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Users;

public class DealerService {
	
	@Autowired
	DealerDao dealerDao;
	public void insertDealer(Users dealer) {
		dealerDao.insertDealer(dealer);
	}
	public List<Cars> showDealerCars(int dealerId) {
		return dealerDao.showDealerCars(dealerId);
	}
	public void deleteCar(int carId) {
		dealerDao.deleteCar(carId);
	}
	public void dealerAddCar(Cars cars) {
		dealerDao.dealerAddCar(cars);
	}
	public void dealerUpdateRent(int carId, int rent) {
		dealerDao.dealerUpdateRent(carId,rent);
	}
	public List<CarDates> viewDealerCustomers(int dealerId) {
		return dealerDao.viewDealerCustomers(dealerId);
	}
}
