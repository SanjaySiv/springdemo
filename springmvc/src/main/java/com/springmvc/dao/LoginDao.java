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

import com.springmvc.model.Login;

public class LoginDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Boolean saveUser(final Login log){  
		String query="insert into login values(?,?,?,?,?)";  
	    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
	    @Override  
	    public Boolean doInPreparedStatement(PreparedStatement ps)  
	            throws SQLException, DataAccessException {  
	              
	        ps.setInt(1,log.getId());  
	        ps.setString(2,log.getFname());  
	        ps.setString(3,log.getLname());  
	        ps.setString(4,log.getEmail());
	        ps.setString(5,log.getPassword());
	        return ps.execute();      
	    }  
	    });
	}
	public List<Login> getUser(String email,String pass) {
		String query="select * from login where email='"+email+"' and password='"+pass+"'";
		return jdbcTemplate.query(query,new ResultSetExtractor<List<Login>>(){  
		    @Override  
		     public List<Login> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Login> list=new ArrayList<Login>();  
		        while(rs.next()){  
		        Login log=new Login();  
		        log.setId(rs.getInt(1));  
		        log.setFname(rs.getString(2));  
		        log.setLname(rs.getString(3));
		        log.setEmail(rs.getString(4));
		        log.setPassword(rs.getString(5));
		        list.add(log);  
		        }  
		        return list;  
		        }  
		    });  
	}
}
