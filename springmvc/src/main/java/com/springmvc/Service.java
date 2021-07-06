package com.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springmvc.dao.AdminDao;
import com.springmvc.model.Customer;

public class Service {
	@Autowired
	AdminDao adminDao;
	public String editCustomers() {
		return "editCustomers";
	}

}
