package com.springmvc.controllers;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;
import com.springmvc.services.CustomerService;
@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	String message;
	public static int customer_id;
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
		model.addAttribute("carList",carList);
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
		customer.setRole("customer");
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
		return customerService.confirmBooking(request,model,customer_id);
	}
	@RequestMapping("/myBookings")
	public String myBookings(Model model) throws ParseException{
		List<CarDates>bookings=customerService.myBookings(customer_id);
		model.addAttribute("bookings", bookings);
		return "myBookings";
	}
}