package com.springmvc.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dao.AdminDao;
import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;

@RestController
@RequestMapping("/api")
public class RestApiController {
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	 
    @Autowired
    AdminDao dao;
    
    @RequestMapping(value = "/cars/", method = RequestMethod.GET)
    public ResponseEntity<List<Cars>> listAllCars() {
    	logger.info("entering list all listAllCars");
        List<Cars> cars = dao.showCars();
        
        if (cars.isEmpty()) {
            return new ResponseEntity<List<Cars>>(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Cars>>(cars, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/bookings/", method = RequestMethod.GET)
    public ResponseEntity<List<CarDates>> listAllBookings() {
    	logger.info("entering list all Bookings");
    	List<CarDates> bookings = dao.viewBookings();
        
        if (bookings.isEmpty()) {
            return new ResponseEntity<List<CarDates>>(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<CarDates>>(bookings, HttpStatus.OK);
    }
}