package com.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.AdminDao;
import com.springmvc.model.Customer;

@org.springframework.stereotype.Service
public class AdminService {	
	@Autowired
	AdminDao dao;
	public List<Customer> editCustomers() {
		return dao.editCustomer();
	}
}