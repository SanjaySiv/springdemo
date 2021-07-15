package com.springmvc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springmvc.dao.CustomerDao;
import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Users;

public class CustomerService {
	@Autowired 
	CustomerDao customerDao;
	public Users getCustomer(String username, String password) {
		List<Users>customerList=customerDao.getUser(username,password);
		return customerList.get(0);
	}
	public void addCustomer(Users users) {
		customerDao.saveUser(users);
	}
	public List<Cars> viewCars() {
		List<Cars>cars=customerDao.viewCars(); 
		return cars;
	}
	public List<CarDates> myBookings(int userId) {
		return customerDao.myBookings(userId);
	}
	public String confirmBooking(HttpServletRequest request,Model model,int userId) throws ParseException {
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
		carDate.setUserId(userId);
		if((bookDate.compareTo(now)<0) || (returnDate.compareTo(bookDate)<0)){
			model.addAttribute("carId",carId);
			model.addAttribute("userId",userId);
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
					Date bookingDateOnDataBase=simpleDateFormat.parse(dates.getBookingDate());
					Date returnDateOnDataBase=simpleDateFormat.parse(dates.getReturnDate());
					if((bookDate.compareTo(bookingDateOnDataBase)>=0)&&(bookDate.compareTo(returnDateOnDataBase)<=0))
						count++;
					else if((returnDate.compareTo(bookingDateOnDataBase)>=0)&&(returnDate.compareTo(returnDateOnDataBase)<=0))
						count++;
				}
				if(count==0) {
					customerDao.saveDate(carDate);
					model.addAttribute("details",carDate);
					return "booked";
				}
				else {
					model.addAttribute("carId",carId);
					model.addAttribute("userId",userId);
					return "bookCar";
				}
			}
		}
	}
}