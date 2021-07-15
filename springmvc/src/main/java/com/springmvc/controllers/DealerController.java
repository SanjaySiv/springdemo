package com.springmvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Cars;
import com.springmvc.model.Users;
import com.springmvc.services.DealerService;

@Controller
public class DealerController {
	@Autowired
	DealerService dealerService;
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
		return "dealerCarList";
	}
}
