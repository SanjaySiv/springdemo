package com.springmvc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

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
	Customer customer;
	@RequestMapping("/login")  
    public String checkUser(HttpServletRequest req,Model model) {    
		String email=req.getParameter("email"); 
		String pass=req.getParameter("pass");
		List<Customer>customerList=dao.getUser(email,pass); 
		 if(email.contentEquals("admin")&&pass.contentEquals("admin")) {
			 return "admin";
		 }
		 else if(customerList.isEmpty()) {
			 msg="Sorry, You entered incorrect credentials"; 
			 model.addAttribute("message",msg); 
			 return "errorpage"; 
		}
		 else {
			 customer=customerList.get(0);
			 msg="Welcome "+customer.getName();
			 model.addAttribute("message", msg);
			 return "view"; 
		}
    }
	@RequestMapping("/viewCars") 
	public String viewCars(Model m) {
		List<Cars>carList=dao.getCars(); 
		/*
		 * CustomerService service = new CustomerService(); service.getCar();
		 */
		m.addAttribute("list",carList);
		return	"viewCars"; 
	 }
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String addCustomer(HttpServletRequest req) {
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
	public String confirmBooking(HttpServletRequest req,Model model) throws ParseException {
		List<CarDates>carDateList=new ArrayList<CarDates>();
		String bookingDate=req.getParameter("bookingDate");
		String returningDate=req.getParameter("returningDate");
		int carId=Integer.parseInt(req.getParameter("carId"));
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date bookDate=sdformat.parse(bookingDate);
		Date returnDate= sdformat.parse(returningDate);
		Date date=new Date();
		String today=sdformat.format(date);
		Date now=sdformat.parse(today);
		int rent=Integer.parseInt(dao.getRent(carId));
		int daysCount = (int) ((returnDate.getTime() - bookDate.getTime())/(1000*60*60*24));
		int rentAmount=daysCount*rent;
		CarDates carDate=new CarDates();
		carDate.setCarId(carId);
		carDate.setBookingDate(bookingDate);
		carDate.setReturnDate(returningDate);
		carDate.setRentAmount(rentAmount);
		if((bookDate.compareTo(now)<0) || (returnDate.compareTo(bookDate)<0)){
			model.addAttribute("carId",carId);
			return "bookCar";
		}
		else {		
			carDateList=dao.checkDate(carId);
			if(carDateList.isEmpty()) {
				dao.saveDate(carDate,customer);
				model.addAttribute("rentAmount",rentAmount);
				return "booked";
			}
			else {
				int count=0;
				for(CarDates dates:carDateList) {
					Date bookDb=sdformat.parse(dates.getBookingDate());
					Date returnDb=sdformat.parse(dates.getReturnDate());
					if((bookDate.compareTo(bookDb)>=0)&&(bookDate.compareTo(returnDb)<=0))
						count++;
					else if((returnDate.compareTo(bookDb)>=0)&&(returnDate.compareTo(returnDb)<=0))
						count++;
				}
				if(count==0) {
					dao.saveDate(carDate,customer);
					model.addAttribute("rentAmount",rentAmount);
					return "booked";
				}
				else {
					model.addAttribute("carId",carId);
					return "bookCar";
				}
			}
		}
	}
	@RequestMapping("/myBookings")
	public String myBookings(Model model) throws ParseException {
		List<CarDates>bookings=dao.myBookings(customer);
		model.addAttribute("list", bookings);
		return "myBookings";
	}
}
