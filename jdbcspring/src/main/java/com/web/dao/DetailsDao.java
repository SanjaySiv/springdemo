package com.web.dao;

import java.sql.*;
import com.web.model.Details;

public class DetailsDao {
	public Details getDetails(int id) {
		Details d=new Details();	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursedetails","root","sqlroot");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from details where id="+id);
			if(rs.next()) {
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("name"));
				d.setTech(rs.getString("tech"));
			}
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		return d;
	}
}
