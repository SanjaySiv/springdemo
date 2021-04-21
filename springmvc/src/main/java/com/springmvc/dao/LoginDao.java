package com.springmvc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc.model.Login;

public class LoginDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int saveUser(Login log){  
	    String query="insert into login(id,fname,lname,email,password) values("+log.getId()+",'"+log.getFname()+"','"+
	log.getLname()+"','"+log.getEmail()+"','"+log.getPassword()+"')";  
	    return jdbcTemplate.update(query);  
	}
	public int getUser(Login log) {
		String query="select * from login where email='"+log.getEmail()+
				"' and password='"+log.getPassword()+"')";
		return jdbcTemplate.update(query);
	}
}
