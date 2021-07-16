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
import com.springmvc.model.Users;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	String query;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Boolean saveUser(final Users users){  
		query="insert into users (name,address,phone,email,username,password,role)values(?,?,?,?,?,?,?)";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement preparedStatement)  
	            throws SQLException, DataAccessException {  
	        preparedStatement.setString(1,users.getName());  
	        preparedStatement.setString(2,users.getAddress());  
	        preparedStatement.setString(3,users.getPhone());  
	        preparedStatement.setString(4,users.getEmail());
	        preparedStatement.setString(5,users.getUsername());
	        preparedStatement.setString(6,users.getPassword());
	        preparedStatement.setString(7,users.getRole());
	        return preparedStatement.execute();      
	    }  
	    });
	}
	public List<Users> getUser(String username,String password) {
		query="select * from users where username='"+username+"' and password='"+password+"'";
		return jdbcTemplate.query(query,new RowMapper<Users>(){ 
	        public Users mapRow(ResultSet resrultSet, int row) throws SQLException {    
	        	Users users=new Users();
	        	users.setUserId(resrultSet.getInt("userId"));
	        	users.setName(resrultSet.getString("name"));  
	        	users.setAddress(resrultSet.getString("address"));  
	        	users.setPhone(resrultSet.getString("phone"));
	        	users.setEmail(resrultSet.getString("email"));
	        	users.setUsername(resrultSet.getString("username"));
	        	users.setPassword(resrultSet.getString("password"));
	        	users.setRole(resrultSet.getString("role"));
	    		return users;}
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
		query="insert into carDates (carId,bookingdate,returnDate,userId,rentAmount)values(?,?,?,?,?)";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement preparedStatement)  
	            throws SQLException, DataAccessException {  
	    	preparedStatement.setInt(1,date.getCarId());  
	    	preparedStatement.setString(2, date.getBookingDate());  
	    	preparedStatement.setString(3,date.getReturnDate());  
	    	preparedStatement.setInt(4,date.getUserId());
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
	public List<CarDates> myBookings(int userId)  {
		query="select bookingDate,returndate,rentAmount from carDates where userId="+userId;
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
	public List<Cars> selectLocation() {
		query="select distinct location from cars";
	    return jdbcTemplate.query(query,new RowMapper<Cars>(){
	    	 @Override
	        public Cars mapRow(ResultSet resrultSet, int row) throws SQLException {    
	            Cars cars=new Cars();    
	            cars.setLocation(resrultSet.getString("location"));    
	            return cars;    
	        }    
	    });  
	}
}
