package com.springmvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.dao.AdminDao;
import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;

@Controller
public class AdminController {
	@Autowired
	AdminDao dao;
	AdminService service;
	
	@RequestMapping(value="/editCars") 
	public String editCars(Model model) {
		List<Cars>list=dao.showCars(); 
		model.addAttribute("list",list);
		return	"editCars"; 
	}
	@RequestMapping(value="/deleteCar/{carId}",method = RequestMethod.GET)
	 public String deleteCar(@PathVariable int carId){    
        dao.deleteCar(carId);    
        return "redirect:/editCars";    
    } 
	@RequestMapping(value="/addCar",method = RequestMethod.POST)
	public String addCustomer(HttpServletRequest request) {
		Cars car=new Cars();
		car.setModel(request.getParameter("model"));
		car.setSeat(Integer.parseInt(request.getParameter("seat")));
		car.setRegNo(request.getParameter("regNo"));
		car.setPermit(request.getParameter("permit"));
		car.setRent(Integer.parseInt(request.getParameter("rent")));
		dao.addCar(car);
		return "redirect:/editCars";
	}
	@RequestMapping("/viewCustomers")
	public String editCustomer(Model model) {
		List<Customer>list=dao.editCustomer(); 
		model.addAttribute("list",list);
		return "editCustomer";
	}
	@RequestMapping(value="/deleteCustomer/{customer_id}",method = RequestMethod.GET)
	 public String deleteCustomer(@PathVariable int customer_id){    
       dao.deleteCustomer(customer_id);    
       return "redirect:/viewCustomers";    
    } 
	@RequestMapping("/viewBookings")
	public String viewBookings(Model model) {
		List<CarDates>list=dao.viewBookings(); 
		model.addAttribute("list",list);
		return "viewBookings";
	}
	@RequestMapping(value="/changeRent/{carId}",method = RequestMethod.GET)
	 public String changeRent(@PathVariable int carId,HttpServletRequest request){
		int rent=Integer.parseInt(request.getParameter("rent"));
		dao.updateRent(carId,rent);
        return "redirect:/editCars";    
    } 
}