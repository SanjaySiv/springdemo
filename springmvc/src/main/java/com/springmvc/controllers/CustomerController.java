package com.springmvc.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.dao.CustomerDao;
import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;
import com.springmvc.services.CustomerService;
@Controller
public class CustomerController {
	@Autowired 
	CustomerDao customerDao;
	@Autowired
	CustomerService customerService;
	String message;
	Customer customer;
	@RequestMapping(value="/login",method = RequestMethod.POST)  
    public String getUser(HttpServletRequest request,Model model) {    
		String username=request.getParameter("username"); 
		String password=request.getParameter("password");
		int flag=customerService.getUser(username,password);
		if(flag==0) {
			message="Sorry, You entered incorrect credentials"; 
			model.addAttribute("message",message);
			return "errorpage";
		}
		else if(flag==1) {
			return "admin";
		}
		else {
			return "view";
		}
    }
	@RequestMapping("/viewCarList") 
	public String viewCars(Model model) {
		List<Cars>carList=customerService.viewCars(); 
		model.addAttribute("list",carList);
		return	"viewCars"; 
	 }
	@RequestMapping(value="/save")
	public String addCustomer(HttpServletRequest request) {
		Customer customer=new Customer();
		customer.setName(request.getParameter("name"));
		customer.setAddress(request.getParameter("address"));
		customer.setPhone(request.getParameter("phone"));
		customer.setEmail(request.getParameter("email"));
		customer.setUsername(request.getParameter("username"));
		customer.setPassword(request.getParameter("password"));
		customer.setRole(request.getParameter("role"));
		customerService.addCustomer(customer);
		return "success";
	}
	@RequestMapping(value="/bookCar/{carId}",method = RequestMethod.GET)
	 public String bookCar(@PathVariable int carId,Model model) {   
		model.addAttribute("carId",carId);
        return "bookCar";    
    }
	@RequestMapping("/bookCar/confirmBooking")
	public String confirmBooking(HttpServletRequest request,Model model) throws ParseException {
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
		carDate.setCustomer_id(customer.getCustomer_id());
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
	@RequestMapping("/myBookings")
	public String myBookings(Model model) throws ParseException{
		List<CarDates>bookings=customerService.myBookings(customer);
		model.addAttribute("list", bookings);
		return "myBookings";
	}
}
