package com.springmvc.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Cars;

public class CarsDao {
		JdbcTemplate jdbcTemplate;
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
	public List<Cars> getCars(){    
	    return jdbcTemplate.query("select * from cars",new RowMapper<Cars>(){
	    	 @Override
	        public Cars mapRow(ResultSet rs, int row) throws SQLException {    
	            Cars cars=new Cars();    
	            cars.setModel(rs.getString(1));    
	            cars.setAvailable(rs.getString(2));    
	            cars.setSeat(rs.getInt(3));    
	            cars.setPermit(rs.getString(4)); 
	            return cars;    
	        }    
	    });    
	}    
}
