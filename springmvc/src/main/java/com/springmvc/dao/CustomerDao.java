package com.springmvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.springmvc.model.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Boolean saveUser(final Customer customer){  
		String query="insert into customer values(?,?,?,?,?)";  
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
		        customer.setName(rs.getString(1));  
		        customer.setAddress(rs.getString(2));  
		        customer.setPhone(rs.getString(3));
		        customer.setEmail(rs.getString(4));
		        customer.setPassword(rs.getString(5));
		        list.add(customer);  
		        }  
		        return list;  
		        }  
		    });  
	}
}
