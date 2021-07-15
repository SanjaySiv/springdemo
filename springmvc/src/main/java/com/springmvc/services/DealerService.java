package com.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.DealerDao;
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
	
}
