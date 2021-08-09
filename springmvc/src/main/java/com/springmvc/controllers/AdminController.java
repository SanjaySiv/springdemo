package com.springmvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Users;
import com.springmvc.services.AdminService;

@Controller
public class AdminController {
	
	AdminService adminService;
	
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
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
	public String addCar(HttpServletRequest request,Model model) {
		Cars car=new Cars();
		try {
		car.setModel(request.getParameter("model"));
		car.setSeat(Integer.parseInt(request.getParameter("seat")));
		car.setRegNo(request.getParameter("regNo"));
		car.setPermit(request.getParameter("permit"));
		car.setRent(Integer.parseInt(request.getParameter("rent")));
		car.setLocation(request.getParameter("location"));
		car.setDealerId(Integer.parseInt(request.getParameter("dealerId")));
		adminService.addCar(car);
		return "redirect:/viewCars";
		}
		catch(DuplicateKeyException e) {
			model.addAttribute("message","Car already exist");
			return "cars";
		}
	}
	@RequestMapping("/viewCustomers")
	public String viewCustomers(Model model) {
		List<Users>customerList=adminService.viewCustomers(); 
		model.addAttribute("customerList",customerList);
		return "editCustomer";
	}
	@RequestMapping(value="/deleteCustomer/{userId}",method = RequestMethod.GET)
	 public String deleteCustomer(@PathVariable int userId){    
		adminService.deleteCustomer(userId);    
       return "redirect:/viewCustomers";    
    } 
	@RequestMapping(value="/addCustomer")
	public String addCustomer() {
		return "addCustomer";
	}
	@RequestMapping(value="/insertCustomer",method = RequestMethod.POST)
	public String insertCustomer(HttpServletRequest request,Model model) {
		Users users=new Users();
		users.setName(request.getParameter("name"));
		users.setAddress(request.getParameter("address"));
		users.setPhone(request.getParameter("phone"));
		users.setEmail(request.getParameter("email"));
		users.setUsername(request.getParameter("username"));
		users.setPassword(request.getParameter("password"));
		users.setRole("customer");
		try {
		adminService.insertUser(users);
		return "redirect:/viewCustomers";
		}
		catch(DuplicateKeyException e) {
			model.addAttribute("message","user already exist");
			return "addCustomer";
		}
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
		List<Users>adminList=adminService.viewAdmins();
		model.addAttribute("adminList",adminList);
		return "viewAdmins";
	}
	@RequestMapping(value="/addAdmin")
	public String addAdmin() {
		return "addAdmin";
	}
	@RequestMapping(value="/insertAdmin",method = RequestMethod.POST)
	public String insertAdmin(HttpServletRequest request,Model model) {
		Users users=new Users();
		users.setName(request.getParameter("name"));
		users.setAddress(request.getParameter("address"));
		users.setPhone(request.getParameter("phone"));
		users.setEmail(request.getParameter("email"));
		users.setUsername(request.getParameter("username"));
		users.setPassword(request.getParameter("password"));
		users.setRole("employee");
		try {
		adminService.insertUser(users);
		return "redirect:/viewAdmins";
		}
		catch(DuplicateKeyException e) {
			model.addAttribute("message","user already exist");
			return "addAdmin";
		}
	}
	@RequestMapping(value="/deleteAdmin/{userId}",method = RequestMethod.GET)
	 public String deleteDealer(@PathVariable int userId){    
		adminService.deleteCustomer(userId);    
      return "redirect:/viewAdmins";    
   } 
	
	
	
	
	@RequestMapping(value="/viewDealers")
	public String viewDealers(Model model) {
		List<Users>dealerList=adminService.viewDealers();
		model.addAttribute("dealerList",dealerList);
		return "viewDealers";
	}
	@RequestMapping(value="/addDealer")
	public String addDealer() {
		return "addDealer";
	}
	@RequestMapping(value="/insertDealers",method = RequestMethod.POST)
	public String insertDealer(HttpServletRequest request,Model model) {
		Users users=new Users();
		try {
		users.setName(request.getParameter("name"));
		users.setAddress(request.getParameter("address"));
		users.setPhone(request.getParameter("phone"));
		users.setEmail(request.getParameter("email"));
		users.setUsername(request.getParameter("username"));
		users.setPassword(request.getParameter("password"));
		users.setRole("dealer");
		adminService.insertDealer(users);
		return "redirect:/viewDealers";
		}
		catch(DuplicateKeyException e) {
			model.addAttribute("message","user already exist");
			return "addAdmin";
		}
	}
	@RequestMapping(value="/deleteDealer/{userId}",method = RequestMethod.GET)
	 public String deleteAdmin(@PathVariable int userId){    
		adminService.deleteDealer(userId);    
      return "redirect:/viewDealers";    
   } 
	
}