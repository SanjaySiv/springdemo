package com.springmvc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springmvc.controllers.CustomerController;
import com.springmvc.dao.CustomerDao;
import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;

public class CustomerService {
	@Autowired 
	CustomerDao customerDao;
	String message;
	public int getUser(String username,String password) {
		 List<Customer>customerList=customerDao.getUser(username,password);
		 if(customerList.isEmpty()) { 
			 return 0; 
		}
		 if(!customerList.isEmpty() && customerList.get(0).getRole().contentEquals("employee")) {
			 return 1;
		 }
		 else {
			 CustomerController.customer_id = customerList.get(0).getCustomer_id();
			 return 2; 
		}
	}
	public void addCustomer(Customer customer) {
		customerDao.saveUser(customer);
	}
	public List<Cars> viewCars() {
		return customerDao.viewCars(); 
	}
	public List<CarDates> myBookings(int customer_id) throws ParseException {
		return customerDao.myBookings(customer_id);
	}
	public String confirmBooking(HttpServletRequest request,Model model,int customer_id) throws ParseException {
		List<CarDates>carDateList=new ArrayList<CarDates>();
		String bookingDate=request.getParameter("bookingDate");
		String returningDate=request.getParameter("returningDate");
		int carId=Integer.parseInt(request.getParameter("carId"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date bookDate=simpleDateFormat.parse(bookingDate);
		Date returnDate= simpleDateFormat.parse(returningDate);
		Date date=new Date();
		String today=simpleDateFormat.format(date);
		Date now=simpleDateFormat.parse(today);
		int rent=Integer.parseInt(customerDao.getRent(carId));
		int daysCount = (int) ((returnDate.getTime() - bookDate.getTime())/(1000*60*60*24));
		int rentAmount=(daysCount+1)*rent;
		CarDates carDate=new CarDates();
		carDate.setCarId(carId);
		carDate.setBookingDate(bookingDate);
		carDate.setReturnDate(returningDate);
		carDate.setRentAmount(rentAmount);
		carDate.setCustomer_id(customer_id);
		if((bookDate.compareTo(now)<0) || (returnDate.compareTo(bookDate)<0)){
			model.addAttribute("carId",carId);
			return "bookCar";
		}
		else {		
			carDateList=customerDao.checkDate(carId);
			if(carDateList.isEmpty()) {
				customerDao.saveDate(carDate);
				model.addAttribute("details",carDate);
				return "booked";
			}
			else {
				int count=0;
				for(CarDates dates:carDateList) {
					Date bookDataBase=simpleDateFormat.parse(dates.getBookingDate());
					Date returnDataBase=simpleDateFormat.parse(dates.getReturnDate());
					if((bookDate.compareTo(bookDataBase)>=0)&&(bookDate.compareTo(returnDataBase)<=0))
						count++;
					else if((returnDate.compareTo(bookDataBase)>=0)&&(returnDate.compareTo(returnDataBase)<=0))
						count++;
				}
				if(count==0) {
					customerDao.saveDate(carDate);
					model.addAttribute("details",carDate);
					return "booked";
				}
				else {
					model.addAttribute("carId",carId);
					return "bookCar";
				}
			}
		}
	}
}