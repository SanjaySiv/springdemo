package com.springmvc.controllers;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Users;
import com.springmvc.services.CustomerService;
@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@RequestMapping(value="/login",method = RequestMethod.POST)  
    public String getUser(HttpServletRequest request,Model model) { 
		String message = null;
		String username=request.getParameter("username"); 
		String password=request.getParameter("password");
		Users users=customerService.getCustomer(username,password);
		if(users==null) {
			model.addAttribute("message",message);
			return "errorpage";
		}
		else if(!(users==null) && users.getRole().contentEquals("employee")) {
		return "admin";
		}
		else if(!(users==null) && users.getRole().contentEquals("dealer")) {
			model.addAttribute("users",users);
			return "dealer";
			}
		else {
			model.addAttribute("users",users);
			return "view";
		}
    }
	@RequestMapping(value="/viewCarList",method = RequestMethod.POST) 
	public String viewCars(Model model,HttpServletRequest request) {
		String location=request.getParameter("location");
		List<Cars>carList=customerService.viewCars(location);
		String UserId=request.getParameter("userId");
		model.addAttribute("userId",UserId);
		model.addAttribute("carList",carList);
		return	"viewCars"; 
	 }
	@RequestMapping("/customerRegister")
	public String customerRegister() {
		return "register";
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String addCustomer(HttpServletRequest request,Model model) {
		Users users=new Users();
		users.setName(request.getParameter("name"));
		users.setAddress(request.getParameter("address"));
		users.setPhone(request.getParameter("phone"));
		users.setEmail(request.getParameter("email"));
		users.setUsername(request.getParameter("username"));
		users.setPassword(request.getParameter("password"));
		users.setRole("customer");
		try {
		customerService.addCustomer(users);
		return "success";
		}
		catch(DuplicateKeyException e){
			model.addAttribute("message","user already exist");
			return "register";
		}
	}
	@RequestMapping(value="/bookCar/{carId}",method = RequestMethod.POST)
	 public String bookCar(@PathVariable int carId,Model model,HttpServletRequest request) {   
		model.addAttribute("carId",carId);
		String userId=request.getParameter("userId");
		model.addAttribute("userId",userId);
        return "bookCar";    
    }
	@RequestMapping(value="/bookCar/confirmBooking",method = RequestMethod.POST)
	public String confirmBooking(HttpServletRequest request,Model model)  {
		try {
			int userId = Integer.parseInt(request.getParameter("userId"));
			return customerService.confirmBooking(request,model,userId);
		} catch (ParseException e) {
			return "";
		}
	}
	@RequestMapping("/myBookings")
	public String myBookings(HttpServletRequest request,Model model) {
		int userId=Integer.parseInt(request.getParameter("userId"));
		List<CarDates>bookings=customerService.myBookings(userId);
		model.addAttribute("bookings", bookings);
		return "myBookings";
	}
	@RequestMapping("/location")
	public String selectLocation(HttpServletRequest request,Model model) {
		List<Cars>locationList=customerService.selectLocation();
		int userId=Integer.parseInt(request.getParameter("userId"));
		model.addAttribute("locationList",locationList);
		model.addAttribute("userId",userId);
		return "selectLocation";
	}
}