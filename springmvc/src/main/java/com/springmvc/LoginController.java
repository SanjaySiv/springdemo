package com.springmvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.dao.CustomerDao;
import com.springmvc.model.Customer;

@Controller
public class LoginController {
	@Autowired 
	CustomerDao dao;
	String msg;
	@RequestMapping("/login")  
    public String checkUser(HttpServletRequest req,Model m) {    
		/*
		 * CustomerService cService = new CustomerService(); return
		 * cService.getCustomer(req, m);
		 */
		
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
	
	

	/*
	 * @RequestMapping(value="/save",method = RequestMethod.POST) public String
	 * insertUser(HttpServletRequest req) { return cService.addCustomer(req); }
	 */
}
