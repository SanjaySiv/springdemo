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
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;

@Controller
public class AdminController {
	@Autowired
	AdminDao dao;
	
	@RequestMapping(value="/editCars") 
	public String editCars(Model m) {
		List<Cars>list=dao.editCars(); 
		m.addAttribute("list",list);
		return	"editCars"; 
	 }
	@RequestMapping(value="/deleteCar/{carId}",method = RequestMethod.GET)
	 public String deleteCar(@PathVariable int carId){    
        dao.deleteCar(carId);    
        return "redirect:/editCars";    
    } 
	@RequestMapping(value="/addCar",method = RequestMethod.POST)
	public String addCustomer(HttpServletRequest req) {
		Cars car=new Cars();
		car.setModel(req.getParameter("model"));
		car.setSeat(Integer.parseInt(req.getParameter("seat")));
		car.setRegNo(req.getParameter("regNo"));
		car.setPermit(req.getParameter("permit"));
		dao.addCar(car);
		return "redirect:/editCars";
	}
	@RequestMapping("/viewCustomers")
	public String editCustomer(Model m) {
		List<Customer>list=dao.editCustomer(); 
		m.addAttribute("list",list);
		return "editCustomer";
	}
	@RequestMapping(value="/deleteCustomer/{id}",method = RequestMethod.GET)
	 public String deleteCustomer(@PathVariable int cid){    
       dao.deleteCustomer(cid);    
       return "redirect:/editCustomer";    
   } 
}
