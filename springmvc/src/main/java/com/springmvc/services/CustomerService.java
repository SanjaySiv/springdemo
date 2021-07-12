package com.springmvc.services;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.springmvc.dao.CustomerDao;
import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;

public class CustomerService {
	@Autowired 
	CustomerDao adminDao;
	String message;
	public int getUser(String username,String password) {
		 List<Customer>customerList=adminDao.getUser(username,password);
		 if(customerList.isEmpty()) { 
			 return 0; 
		}
		 if(!customerList.isEmpty() && customerList.get(0).getRole().contentEquals("admin")) {
			 return 1;
		 }
		 else {
			 Customer customer = customerList.get(0);
			 message="Welcome "+customer.getName();
			 //model.addAttribute("message", message);
			 return 2; 
		}
	}
	public void addCustomer(Customer customer) {
		adminDao.saveUser(customer);
	}
	public List<Cars> viewCars() {
		return adminDao.viewCars(); 
	}
	public List<CarDates> myBookings(Customer customer) throws ParseException {
		return adminDao.myBookings(customer);
	}
}
