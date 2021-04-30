package com.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.dao.CarsDao;
import com.springmvc.model.Cars;

@Controller
public class CarsController {
	@Autowired
	CarsDao dao;

	@RequestMapping("/viewCars") 
	public String viewCars(Model m) {
	//carList=serviceClass.getCarslist();
		List<Cars>list=dao.getCars(); 
		m.addAttribute("list",list);
		return	"viewCars"; 
	 }

}