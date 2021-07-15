package com.springmvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

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

}
