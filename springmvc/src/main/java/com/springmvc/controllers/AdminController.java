package com.springmvc.controllers;

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
import com.springmvc.services.AdminService;
import com.springmvc.services.CustomerService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="/viewCars") 
	public String editCars(Model model) {
		List<Cars>carList=adminService.showCars(); 
		model.addAttribute("carList",carList);
		return	"editCars"; 
	}
	@RequestMapping(value="/deleteCar/{carId}",method = RequestMethod.GET)
	 public String deleteCar(@PathVariable int carId){    
		adminService.deleteCar(carId);    
        return "redirect:/viewCars";    
    }
	@RequestMapping(value="/addCar")
	public String addCar() {
		return "cars";
	}
	@RequestMapping(value="/insertCar",method = RequestMethod.POST)
	public String addCar(HttpServletRequest request) {
		Cars car=new Cars();
		car.setModel(request.getParameter("model"));
		car.setSeat(Integer.parseInt(request.getParameter("seat")));
		car.setRegNo(request.getParameter("regNo"));
		car.setPermit(request.getParameter("permit"));
		car.setRent(Integer.parseInt(request.getParameter("rent")));
		adminService.addCar(car);
		return "redirect:/viewCars";
	}
	@RequestMapping("/viewCustomers")
	public String viewCustomers(Model model) {
		List<Customer>customerList=adminService.viewCustomers(); 
		model.addAttribute("customerList",customerList);
		return "editCustomer";
	}
	@RequestMapping(value="/deleteCustomer/{customer_id}",method = RequestMethod.GET)
	 public String deleteCustomer(@PathVariable int customer_id){    
		adminService.deleteCustomer(customer_id);    
       return "redirect:/viewCustomers";    
    } 
	@RequestMapping("/viewBookings")
	public String viewBookings(Model model) {
		List<CarDates>bookingList=adminService.viewBookings(); 
		model.addAttribute("bookingList",bookingList);
		return "viewBookings";
	}
	@RequestMapping(value="/changeRent/{carId}",method = RequestMethod.GET)
	 public String changeRent(@PathVariable int carId,HttpServletRequest request){
		int rent=Integer.parseInt(request.getParameter("rent"));
		adminService.updateRent(carId,rent);
        return "redirect:/viewCars";    
    } 
	@RequestMapping(value="/viewAdmins")
	public String viewAdmins(Model model) {
		List<Customer>adminList=adminService.viewAdmins();
		model.addAttribute("adminList",adminList);
		return "viewAdmins";
	}
	@RequestMapping(value="/addAdmin")
	public String addAdmin() {
		return "addAdmin";
	}
	@RequestMapping(value="/insertAdmin")
	public String addCustomer(HttpServletRequest request) {
		Customer customer=new Customer();
		customer.setName(request.getParameter("name"));
		customer.setAddress(request.getParameter("address"));
		customer.setPhone(request.getParameter("phone"));
		customer.setEmail(request.getParameter("email"));
		customer.setUsername(request.getParameter("username"));
		customer.setPassword(request.getParameter("password"));
		customer.setRole(request.getParameter("role"));
		adminService.insertAdmin(customer);
		return "redirect:/viewAdmins";
	}
}