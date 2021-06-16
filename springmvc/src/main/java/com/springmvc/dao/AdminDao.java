package com.springmvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;

public class AdminDao {
	String query;
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
public List<Cars> showCars(){    
    return jdbcTemplate.query("select * from cars",new RowMapper<Cars>(){
    	 @Override
        public Cars mapRow(ResultSet resrultSet, int row) throws SQLException {    
            Cars cars=new Cars();    
            cars.setCarId(resrultSet.getInt("carId"));    
            cars.setModel(resrultSet.getString("model"));    
            cars.setSeat(resrultSet.getInt("seat"));
            cars.setRegNo(resrultSet.getString("regNo"));
            cars.setPermit(resrultSet.getString("permit"));
            cars.setRent(resrultSet.getInt("rent"));
            return cars;    
        }    
    });    
	}    
public int deleteCar(int carId){    
	query="delete from cars where carId='"+carId+"'";    
    return jdbcTemplate.update(query);    
	}  
public Boolean addCar(final Cars cars){  
	query="insert into cars(model,seat,regNo,permit,rent) values(?,?,?,?,?)";  
    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
    @Override  
    public Boolean doInPreparedStatement(PreparedStatement preparedStmt)  
            throws SQLException, DataAccessException {  
              
    	preparedStmt.setString(1,cars.getModel());    
    	preparedStmt.setInt(2,cars.getSeat());  
    	preparedStmt.setString(3,cars.getRegNo());
    	preparedStmt.setString(4,cars.getPermit());
    	preparedStmt.setInt(5,cars.getRent());
        return preparedStmt.execute();      
    }  
    });
}
public List<Customer> editCustomer(){    
    return jdbcTemplate.query("select customer_id,name,address,phone,email from customer",new RowMapper<Customer>(){
    	 @Override
        public Customer mapRow(ResultSet resrultSet, int row) throws SQLException {    
    		 Customer customer=new Customer();    
    		 customer.setCustomer_id(resrultSet.getInt("customer_id")); 
    		 customer.setName(resrultSet.getString("name"));    
    		 customer.setAddress(resrultSet.getString("address"));    
    		 customer.setPhone(resrultSet.getString("phone"));    
    		 customer.setEmail(resrultSet.getString("email")); 
            return customer;    
        }    
    });    
	}    
public int deleteCustomer(int customer_id){    
	query="delete from customer where customer_id='"+customer_id+"'";    
    return jdbcTemplate.update(query);    
	} 
public List<CarDates> viewBookings(){    
    return jdbcTemplate.query("select * from cardates",new RowMapper<CarDates>(){
    	 @Override
        public CarDates mapRow(ResultSet resrultSet, int row) throws SQLException {    
    		 CarDates carDates=new CarDates();    
            carDates.setCarId(resrultSet.getInt("carId"));    
            carDates.setBookingDate(resrultSet.getString("bookingDate"));    
            carDates.setReturnDate(resrultSet.getString("returnDate"));
            carDates.setCustomer_id(resrultSet.getInt("customer_id"));
            carDates.setRentAmount(resrultSet.getInt("rentAmount"));
            return carDates;    
        }    
    });    
	}    
public int updateRent(int carId,int rent) {
	query="update cars set rent="+rent+" where carId="+carId;
	return jdbcTemplate.update(query);
	}
}