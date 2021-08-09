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
import com.springmvc.services.DealerService;

@Controller
public class DealerController {

	DealerService dealerService;
	
	public DealerController(DealerService dealerService) {
		super();
		this.dealerService = dealerService;
	}
	@RequestMapping("/dealerRegister")
	public String dealerRegister() {
		return "dealerRegistration";
	}
	@RequestMapping(value="/insertDealer",method = RequestMethod.POST)
	public String insertAdmin(HttpServletRequest request,Model model) {
		Users dealer=new Users();
		try {
		dealer.setName(request.getParameter("name"));
		dealer.setAddress(request.getParameter("address"));
		dealer.setPhone(request.getParameter("phone"));
		dealer.setEmail(request.getParameter("email"));
		dealer.setUsername(request.getParameter("username"));
		dealer.setPassword(request.getParameter("password"));
		dealer.setRole("dealer");
		dealerService.insertDealer(dealer);
		return "success";
		}
		catch(DuplicateKeyException e) {
			model.addAttribute("message","dealer already exist");
			return "dealerRegistration";
		}
	}
	@RequestMapping("/viewDealerCars")
	public String viewMyCars(HttpServletRequest request,Model model) {
		int dealerId=Integer.parseInt(request.getParameter("dealerId"));
		List<Cars>dealerCarList=dealerService.showDealerCars(dealerId); 
		model.addAttribute("dealerCarList",dealerCarList);
		model.addAttribute("dealerId",dealerId);
		return "dealerCarList";
	}
	@RequestMapping(value="/dealerDeleteCar/{carId}/{dealerId}",method = RequestMethod.GET)
	 public String deleteCar(@PathVariable int carId,@PathVariable int dealerId,Model model){    
		dealerService.deleteCar(carId);
		model.addAttribute("dealerId",dealerId);
		return "redirect:/viewDealerCars";
   }
	@RequestMapping("/dealerAddCar")
	public String dealerAddCar(HttpServletRequest request,Model model) {
		model.addAttribute("dealerId",Integer.parseInt(request.getParameter("dealerId")));
		return "dealerAddCar";
	}
	@RequestMapping(value="/dealerInsertCar",method = RequestMethod.POST)
	public String dealerInsertCar(HttpServletRequest request,Model model) {
		Cars car=new Cars();
		try {
		car.setModel(request.getParameter("model"));
		car.setSeat(Integer.parseInt(request.getParameter("seat")));
		car.setRegNo(request.getParameter("regNo"));
		car.setPermit(request.getParameter("permit"));
		car.setRent(Integer.parseInt(request.getParameter("rent")));
		car.setLocation(request.getParameter("location"));
		car.setDealerId(Integer.parseInt(request.getParameter("dealerId")));
		dealerService.dealerAddCar(car);
		model.addAttribute("dealerId", request.getParameter("dealerId"));
		return "redirect:/viewDealerCars";
		}
		catch(DuplicateKeyException e) {
			model.addAttribute("message","Car already exist");
			return "dealerAddCar";
		}
	}
	@RequestMapping(value="/dealerChangeRent/{carId}",method = RequestMethod.GET)
	 public String dealerChangeRent(@PathVariable int carId,HttpServletRequest request,Model model){
		int rent=Integer.parseInt(request.getParameter("rent"));
		dealerService.dealerUpdateRent(carId,rent);
		model.addAttribute("dealerId", request.getParameter("dealerId"));
       return "redirect:/viewDealerCars";    
   } 
	@RequestMapping(value="/viewDealerCustomers",method = RequestMethod.GET)
	public String viewDealerCustomers(HttpServletRequest request,Model model) {
		int dealerId=Integer.parseInt(request.getParameter("dealerId"));
		List<CarDates>dealerCustomerList=dealerService.viewDealerCustomers(dealerId);
		model.addAttribute("dealerCustomerList",dealerCustomerList);
		return "dealerCustomerList";
	}
}
