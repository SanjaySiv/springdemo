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
import com.springmvc.model.Customer;

public class AdminDao {
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
public List<Cars> editCars(){    
    return jdbcTemplate.query("select * from cars",new RowMapper<Cars>(){
    	 @Override
        public Cars mapRow(ResultSet rs, int row) throws SQLException {    
            Cars cars=new Cars();    
            cars.setCarId(rs.getInt(1));    
            cars.setModel(rs.getString(2));    
            cars.setSeat(rs.getInt(3));
            cars.setRegNo(rs.getString(4));
            cars.setPermit(rs.getString(5)); 
            return cars;    
        }    
    });    
	}    
public int deleteCar(int carId){    
    String sql="delete from cars where carId='"+carId+"'";    
    return jdbcTemplate.update(sql);    
	}  
public Boolean addCar(final Cars cars){  
	String query="insert into cars(model,seat,regNo,permit) values(?,?,?,?)";  
    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
    @Override  
    public Boolean doInPreparedStatement(PreparedStatement ps)  
            throws SQLException, DataAccessException {  
              
        ps.setString(1,cars.getModel());    
        ps.setInt(2,cars.getSeat());  
        ps.setString(3,cars.getRegNo());
        ps.setString(4,cars.getPermit());
        return ps.execute();      
    }  
    });
}
public List<Customer> editCustomer(){    
    return jdbcTemplate.query("select cid,name,address,phone,email from customer",new RowMapper<Customer>(){
    	 @Override
        public Customer mapRow(ResultSet rs, int row) throws SQLException {    
    		 Customer customer=new Customer();    
    		 customer.setCid(rs.getInt(1)); 
    		 customer.setName(rs.getString(2));    
    		 customer.setAddress(rs.getString(3));    
    		 customer.setPhone(rs.getString(4));    
    		 customer.setEmail(rs.getString(5)); 
            return customer;    
        }    
    });    
	}    
public int deleteCustomer(int cid){    
    String sql="delete from customer where cid='"+cid+"'";    
    return jdbcTemplate.update(sql);    
	} 
}
