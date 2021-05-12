package com.springmvc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.CarDates;
import com.springmvc.model.Cars;
import com.springmvc.model.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;

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
		String query="select * from customer where email='"+email+"' and password='"+pass+"'";
		return jdbcTemplate.query(query,new ResultSetExtractor<List<Customer>>(){  
		    @Override  
		     public List<Customer> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Customer> list=new ArrayList<Customer>();  
		        while(rs.next()){  
		        Customer customer=new Customer();
		        customer.setCid(rs.getInt(1));
		        customer.setName(rs.getString(2));  
		        customer.setAddress(rs.getString(3));  
		        customer.setPhone(rs.getString(4));
		        customer.setEmail(rs.getString(5));
		        customer.setPassword(rs.getString(6));
		        list.add(customer);  
		        }  
		        return list;  
		        }  
		    });  
	}
	public List<Cars> getCars(){    
	    return jdbcTemplate.query("select * from cars",new RowMapper<Cars>(){
	    	 @Override
	        public Cars mapRow(ResultSet rs, int row) throws SQLException {    
	            Cars cars=new Cars();    
	            cars.setCarId(rs.getInt(1));    
	            cars.setModel(rs.getString(2));    
	            cars.setSeat(rs.getInt(3));    
	            cars.setPermit(rs.getString(5)); 
	            return cars;    
	        }    
	    });    
	}  
	public Boolean saveDate(final CarDates date){
		//check date valid or not
		String query="insert into carDates (name,bookingdate,returnDate)values(?,?,?)";  
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
}
