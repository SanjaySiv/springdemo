package com.springmvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	String query;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Boolean saveUser(final Customer customer){  
		query="insert into customer (name,address,phone,email,username,password,role)values(?,?,?,?,?,?,?)";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement preparedStatement)  
	            throws SQLException, DataAccessException {  
	        preparedStatement.setString(1,customer.getName());  
	        preparedStatement.setString(2,customer.getAddress());  
	        preparedStatement.setString(3,customer.getPhone());  
	        preparedStatement.setString(4,customer.getEmail());
	        preparedStatement.setString(5,customer.getUsername());
	        preparedStatement.setString(6,customer.getPassword());
	        preparedStatement.setString(7,customer.getRole());
	        return preparedStatement.execute();      
	    }  
	    });
	}
	public List<Customer> getUser(String username,String password) {
		query="select * from customer where username='"+username+"' and password='"+password+"'";
		return jdbcTemplate.query(query,new RowMapper<Customer>(){ 
	        public Customer mapRow(ResultSet resrultSet, int row) throws SQLException {    
	        	Customer customer=new Customer();
	        	customer.setCustomer_id(resrultSet.getInt("customer_id"));
	        	customer.setName(resrultSet.getString("name"));  
	        	customer.setAddress(resrultSet.getString("address"));  
	        	customer.setPhone(resrultSet.getString("phone"));
	        	customer.setEmail(resrultSet.getString("email"));
	        	customer.setUsername(resrultSet.getString("username"));
	        	customer.setPassword(resrultSet.getString("password"));
	        	customer.setRole(resrultSet.getString("role"));
	    		return customer;}
	        });    
	}
	public List<Cars> viewCars(){ 
		query="select * from cars";
	    return jdbcTemplate.query(query,new RowMapper<Cars>(){
	    	 @Override
	        public Cars mapRow(ResultSet resrultSet, int row) throws SQLException {    
	            Cars cars=new Cars();    
	            cars.setCarId(resrultSet.getInt("carId"));    
	            cars.setModel(resrultSet.getString("model"));    
	            cars.setSeat(resrultSet.getInt("seat"));    
	            cars.setPermit(resrultSet.getString("permit")); 
	            cars.setRent(resrultSet.getInt("rent"));
	            return cars;    
	        }    
	    });    
	}  
	public Boolean saveDate(final CarDates date){
		query="insert into carDates (carId,bookingdate,returnDate,customer_id,rentAmount)values(?,?,?,?,?)";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement preparedStatement)  
	            throws SQLException, DataAccessException {  
	    	preparedStatement.setInt(1,date.getCarId());  
	    	preparedStatement.setString(2, date.getBookingDate());  
	    	preparedStatement.setString(3,date.getReturnDate());  
	    	preparedStatement.setInt(4,date.getCustomer_id());
	    	preparedStatement.setInt(5,date.getRentAmount());
	        return preparedStatement.execute();      
	    }  
	    });
	}
	public List<CarDates> checkDate(int carId) throws ParseException {
			query="select * from carDates where carId="+carId;
			return jdbcTemplate.query(query,new RowMapper<CarDates>(){
		    	 @Override
		        public CarDates mapRow(ResultSet resrultSet, int row) throws SQLException {    
		            CarDates carDate=new CarDates();    
		            carDate.setCarId(resrultSet.getInt("carId"));    
		            carDate.setBookingDate(resrultSet.getString("bookingDate"));    
		            carDate.setReturnDate(resrultSet.getString("returnDate"));   
		            return carDate;    
		        }    
		    });   
	}
	public String getRent(int carId){
		query = "select rent from cars  where carId=?";
	    String rent =  jdbcTemplate.queryForObject(query, new Object[] { carId }, String.class);
	    return rent;
	}
	public List<CarDates> myBookings(Customer customer) throws ParseException {
		query="select bookingDate,returndate,rentAmount from carDates where customer_id="+customer.getCustomer_id();
		return jdbcTemplate.query(query,new RowMapper<CarDates>(){
	    	 @Override
	        public CarDates mapRow(ResultSet resrultSet, int row) throws SQLException {    
	            CarDates carDate=new CarDates();    
	            carDate.setBookingDate(resrultSet.getString("bookingDate"));    
	            carDate.setReturnDate(resrultSet.getString("returnDate"));    
	            carDate.setRentAmount(resrultSet.getInt("rentAmount"));   
	            return carDate;    
	        }    
	    });   
	}
}
