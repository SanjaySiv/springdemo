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
	        public Customer mapRow(ResultSet rs, int row) throws SQLException {    
	        	Customer customer=new Customer();
	        	customer.setCid(rs.getInt("cid"));
	        	customer.setName(rs.getString("name"));  
	        	customer.setAddress(rs.getString("address"));  
	        	customer.setPhone(rs.getString("phone"));
	        	customer.setEmail(rs.getString("email"));
	        	customer.setPassword(rs.getString("password"));
	    		return customer;}
	        });    
	}
	public List<Cars> getCars(){    
	    return jdbcTemplate.query("select * from cars",new RowMapper<Cars>(){
	    	 @Override
	        public Cars mapRow(ResultSet rs, int row) throws SQLException {    
	            Cars cars=new Cars();    
	            cars.setCarId(rs.getInt("carId"));    
	            cars.setModel(rs.getString("model"));    
	            cars.setSeat(rs.getInt("seat"));    
	            cars.setPermit(rs.getString("permit")); 
	            return cars;    
	        }    
	    });    
	}  
	public Boolean saveDate(final CarDates date){
		//check date valid or not
		query="insert into carDates (carId,bookingdate,returnDate)values(?,?,?)";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement ps)  
	            throws SQLException, DataAccessException {  
	              
	        ps.setInt(1,date.getCarId());  
	        ps.setString(2, date.getBookingDate());  
	        ps.setString(3,date.getReturnDate());  
	        return ps.execute();      
	    }  
	    });
	}
	public List<CarDates> checkDate(int carId) throws ParseException {
			query="select * from carDates where carId="+carId;
			return jdbcTemplate.query(query,new RowMapper<CarDates>(){
		    	 @Override
		        public CarDates mapRow(ResultSet rs, int row) throws SQLException {    
		            CarDates carDate=new CarDates();    
		            carDate.setCarId(rs.getInt("carId"));    
		            carDate.setBookingDate(rs.getString("bookingDate"));    
		            carDate.setReturnDate(rs.getString("returnDate"));   
		            return carDate;    
		        }    
		    });   
	}
}
