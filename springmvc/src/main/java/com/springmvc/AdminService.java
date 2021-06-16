package com.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springmvc.dao.AdminDao;
import com.springmvc.model.Customer;

public class AdminService {
	
	@Autowired
	AdminDao dao;
	public String viewCustomers(Model model) {
		List<Customer>list=dao.editCustomer(); 
		model.addAttribute("list",list);
		return "editCustomers";
	}
}
