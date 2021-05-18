package com.springmvc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.dao.CustomerDao;
import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;
@Controller
public class CustomerController {
	@Autowired 
	CustomerDao dao;
	String msg;
	@RequestMapping("/login")  
    public String checkUser(HttpServletRequest req,Model m) {    
		String email=req.getParameter("email"); 
		String pass=req.getParameter("pass");
		List<Customer>list=dao.getUser(email,pass); 
		 if(email.contentEquals("admin")&&pass.contentEquals("admin")) {
			 return "admin";
		 }
		 else if(list.isEmpty()) {
			 msg="Sorry, You entered incorrect credentials"; 
			 m.addAttribute("message",msg); 
			 return "errorpage"; 
		}
		 else { 
			 return "view"; 
		}
    }
	@RequestMapping("/viewCars") 
	public String viewCars(Model m) {
		List<Cars>list=dao.getCars(); 
		m.addAttribute("list",list);
		return	"viewCars"; 
	 }
	@RequestMapping(value="/save",method = RequestMethod.POST)
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
	@RequestMapping(value="/bookCar/{carId}",method = RequestMethod.GET)
	 public String bookCar(@PathVariable int carId,Model m) {   
		m.addAttribute("carId",carId);
        return "bookCar";    
    }
	@RequestMapping("/bookCar/confirmBooking")
	public String confirmBooking(HttpServletRequest req,HttpServletResponse res) throws ParseException {
		String bookingDate=req.getParameter("bookingDate");
		String returningDate=req.getParameter("returningDate");
		int carId=Integer.parseInt(req.getParameter("carId"));
		CarDates carDate=new CarDates();
		carDate.setCarId(carId);
		carDate.setBookingDate(bookingDate);
		carDate.setReturnDate(returningDate);
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date bookDate=sdformat.parse(bookingDate);
		Date returnDate= sdformat.parse(returningDate);
		Date date=new Date();
		String today=sdformat.format(date);
		Date now=sdformat.parse(today);
		if((bookDate.compareTo(now)<0) || (returnDate.compareTo(bookDate)<0)){
			return "bookCar";
		}
		else {
			List<CarDates>list=dao.checkDate(carId);
			if(list.isEmpty()) {
				dao.saveDate(carDate);
				return "booked";
			}
			else {
				return "welcome";
			}
		}
	}
}