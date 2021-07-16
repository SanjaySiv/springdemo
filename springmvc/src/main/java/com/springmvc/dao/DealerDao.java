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
import com.springmvc.model.Users;

public class DealerDao {
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Boolean insertDealer(final Users dealer) {
		String query="insert into users (name,address,phone,email,username,password,role)values(?,?,?,?,?,?,?)";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement preparedStatement)  
	            throws SQLException, DataAccessException {  
	        preparedStatement.setString(1,dealer.getName());  
	        preparedStatement.setString(2,dealer.getAddress());  
	        preparedStatement.setString(3,dealer.getPhone());  
	        preparedStatement.setString(4,dealer.getEmail());
	        preparedStatement.setString(5,dealer.getUsername());
	        preparedStatement.setString(6,dealer.getPassword());
	        preparedStatement.setString(7,dealer.getRole());
	        return preparedStatement.execute();      
	    }  
	    });
	}
	public List<Cars> showDealerCars(int dealerId) {
		String query="select * from cars where dealerId="+dealerId;
	    return jdbcTemplate.query(query,new RowMapper<Cars>(){
	    	 @Override
	        public Cars mapRow(ResultSet resrultSet, int row) throws SQLException {    
	            Cars cars=new Cars();    
	            cars.setCarId(resrultSet.getInt("carId"));    
	            cars.setModel(resrultSet.getString("model"));    
	            cars.setSeat(resrultSet.getInt("seat"));
	            cars.setRegNo(resrultSet.getString("regNo"));
	            cars.setPermit(resrultSet.getString("permit"));
	            cars.setRent(resrultSet.getInt("rent"));
	            cars.setLocation(resrultSet.getString("location"));
	            return cars;    
	        }    
	    });    
	}
	public int deleteCar(int carId){    
		String query="delete from cars where carId='"+carId+"'";    
	    return jdbcTemplate.update(query);    
		}
	public Boolean dealerAddCar(Cars cars) {
		String query="insert into cars(model,seat,regNo,permit,rent,location,dealerId) values(?,?,?,?,?,?,?)";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement preparedStmt)  
	            throws SQLException, DataAccessException {  
	              
	    	preparedStmt.setString(1,cars.getModel());    
	    	preparedStmt.setInt(2,cars.getSeat());  
	    	preparedStmt.setString(3,cars.getRegNo());
	    	preparedStmt.setString(4,cars.getPermit());
	    	preparedStmt.setInt(5,cars.getRent());
	    	preparedStmt.setString(6,cars.getLocation());
	    	preparedStmt.setInt(7,cars.getDealerId());
	        return preparedStmt.execute();      
	    }  
	    });
	}
	public int dealerUpdateRent(int carId, int rent) {
		String query="update cars set rent="+rent+" where carId="+carId;
		return jdbcTemplate.update(query);
	}
	public List<CarDates> viewDealerCustomers(int dealerId) {
		String query="select * from cardates where dealerId="+dealerId;
	    return jdbcTemplate.query(query,new RowMapper<CarDates>(){
	    	 @Override
	        public CarDates mapRow(ResultSet resrultSet, int row) throws SQLException {    
	    		 CarDates carDates=new CarDates();    
	            carDates.setCarId(resrultSet.getInt("carId"));    
	            carDates.setBookingDate(resrultSet.getString("bookingDate"));    
	            carDates.setReturnDate(resrultSet.getString("returnDate"));
	            carDates.setUserId(resrultSet.getInt("userId"));
	            carDates.setRentAmount(resrultSet.getInt("rentAmount"));
	            carDates.setDealerId(resrultSet.getInt("dealerId"));
	            return carDates;    
	        }    
	    });    
	}  
}
