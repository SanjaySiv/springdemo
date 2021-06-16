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
		String query="insert into customer (name,address,phone,email,password)values(?,?,?,?,?)";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement ps)  
	            throws SQLException, DataAccessException {  
	        ps.setString(1,customer.getName());  
	        ps.setString(2,customer.getAddress());  
	        ps.setString(3,customer.getPhone());  
	        ps.setString(4,customer.getEmail());
	        ps.setString(5,customer.getPassword());
	        return ps.execute();      
	    }  
	    });
	}
	public List<Customer> getUser(String email,String pass) {
		query="select * from customer where email='"+email+"' and password='"+pass+"'";
		return jdbcTemplate.query(query,new RowMapper<Customer>(){ 
	        public Customer mapRow(ResultSet resrultSet, int row) throws SQLException {    
	        	Customer customer=new Customer();
	        	customer.setCustomer_id(resrultSet.getInt("customer_id"));
	        	customer.setName(resrultSet.getString("name"));  
	        	customer.setAddress(resrultSet.getString("address"));  
	        	customer.setPhone(resrultSet.getString("phone"));
	        	customer.setEmail(resrultSet.getString("email"));
	        	customer.setPassword(resrultSet.getString("password"));
	    		return customer;}
	        });    
	}
	public List<Cars> getCars(){    
	    return jdbcTemplate.query("select * from cars",new RowMapper<Cars>(){
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
	public Boolean saveDate(final CarDates date,final Customer customer){
		query="insert into carDates (carId,bookingdate,returnDate,customer_id,rentAmount)values(?,?,?,?,?)";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement preparedStmt)  
	            throws SQLException, DataAccessException {  
	              
	    	preparedStmt.setInt(1,date.getCarId());  
	    	preparedStmt.setString(2, date.getBookingDate());  
	    	preparedStmt.setString(3,date.getReturnDate());  
	    	preparedStmt.setInt(4,customer.getCustomer_id());
	    	preparedStmt.setInt(5,date.getRentAmount());
	        return preparedStmt.execute();      
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
		String sql = "select rent from cars  where carId=?";
	    String rent =  jdbcTemplate.queryForObject(sql, new Object[] { carId }, String.class);
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
