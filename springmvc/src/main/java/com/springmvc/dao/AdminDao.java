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

public class AdminDao {
	
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
public List<Cars> showCars(){
	String query="select * from cars";
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
            cars.setDealerId(resrultSet.getInt("dealerId"));
            return cars;    
        }    
    });    
	}    
public int deleteCar(int carId){    
	String query="delete from cars where carId='"+carId+"'";    
    return jdbcTemplate.update(query);    
	}  
public Boolean addCar(final Cars cars){  
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
public List<Users> viewCustomers(){  
	String query="select userId,name,address,phone,email from users where role='customer'";
    return jdbcTemplate.query(query,new RowMapper<Users>(){
    	 @Override
        public Users mapRow(ResultSet resrultSet, int row) throws SQLException {    
    		 Users users=new Users();    
    		 users.setUserId(resrultSet.getInt("userId")); 
    		 users.setName(resrultSet.getString("name"));    
    		 users.setAddress(resrultSet.getString("address"));    
    		 users.setPhone(resrultSet.getString("phone"));    
    		 users.setEmail(resrultSet.getString("email")); 
            return users;    
        }    
    });    
	}    
public int deleteCustomer(int userId){    
	String query="delete from users where userId='"+userId+"'";    
    return jdbcTemplate.update(query);    
	} 
public List<CarDates> viewBookings(){  
	String query="select * from cardates";
    return jdbcTemplate.query(query,new RowMapper<CarDates>(){
    	 @Override
        public CarDates mapRow(ResultSet resrultSet, int row) throws SQLException {    
    		 CarDates carDates=new CarDates();    
            carDates.setCarId(resrultSet.getInt("carId"));    
            carDates.setBookingDate(resrultSet.getString("bookingDate"));    
            carDates.setReturnDate(resrultSet.getString("returnDate"));
            carDates.setUserId(resrultSet.getInt("userId"));
            carDates.setRentAmount(resrultSet.getInt("rentAmount"));
            return carDates;    
        }    
    });    
	}    
public int updateRent(int carId,int rent) {
	String query="update cars set rent="+rent+" where carId="+carId;
	return jdbcTemplate.update(query);
	}
public Boolean insertUser(final Users users){  
	String query="insert into users (name,address,phone,email,username,password,role)values(?,?,?,?,?,?,?)";  
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
public List<Users> viewAdmins() {
	String query="select userId,name,address,phone,email from users where role='employee'";
    return jdbcTemplate.query(query,new RowMapper<Users>(){
    	 @Override
        public Users mapRow(ResultSet resrultSet, int row) throws SQLException {    
    		 Users users=new Users();    
    		 users.setUserId(resrultSet.getInt("userId")); 
    		 users.setName(resrultSet.getString("name"));    
    		 users.setAddress(resrultSet.getString("address"));    
    		 users.setPhone(resrultSet.getString("phone"));    
    		 users.setEmail(resrultSet.getString("email")); 
            return users;    
        }    
    });  
	}
public List<Users> viewdealers() {
	String query="select userId,name,address,phone,email from users where role='dealer'";
    return jdbcTemplate.query(query,new RowMapper<Users>(){
    	 @Override
        public Users mapRow(ResultSet resrultSet, int row) throws SQLException {    
    		 Users users=new Users();    
    		 users.setUserId(resrultSet.getInt("userId")); 
    		 users.setName(resrultSet.getString("name"));    
    		 users.setAddress(resrultSet.getString("address"));    
    		 users.setPhone(resrultSet.getString("phone"));    
    		 users.setEmail(resrultSet.getString("email")); 
            return users;    
        }    
    });  
	}
public Boolean insertDealer(Users users) {
	String query="insert into users (name,address,phone,email,username,password,role)values(?,?,?,?,?,?,?)";  
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
public int deleteDealer(int userId) {
	String query="delete from users where userId='"+userId+"'";    
    return jdbcTemplate.update(query); 
}
}