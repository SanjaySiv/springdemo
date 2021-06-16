package com.springmvc;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.springmvc.dao.CustomerDao;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;

public class CustomerService {
	@Autowired 
	CustomerDao dao;
	String msg;
	public String getCustomer(HttpServletRequest req,Model m) {
		String email=req.getParameter("email"); 
		String pass=req.getParameter("pass");
		 List<Customer>list=dao.getUser(email,pass); 
		 if(list.isEmpty()) {
			 msg="Sorry  You entered incorrect credentials"; 
			 m.addAttribute("message",msg); 
			 return "errorpage"; 
		} 
		 else { 
			 return "view"; 
		}
	}
	public String addCustomer(HttpServletRequest req) {
		Customer customer=new Customer();
		customer.setName(req.getParameter("name"));
		customer.setAddress(req.getParameter("address"));
		customer.setPhone(req.getParameter("phone"));
		customer.setEmail(req.getParameter("email"));
		customer.setPassword(req.getParameter("pass"));
		dao.saveUser(customer);
		return "success";
	}
	public String getCar() {
		dao.getCars(); 
		return	"viewCars";
	}
}
