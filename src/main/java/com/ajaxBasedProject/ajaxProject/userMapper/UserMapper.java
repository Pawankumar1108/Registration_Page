package com.ajaxBasedProject.ajaxProject.userMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ajaxBasedProject.ajaxProject.dao.UserEntity;


public class UserMapper implements RowMapper<UserEntity> {


	
	public UserEntity mapRow(ResultSet resultSet, int rowNum ) throws SQLException {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(resultSet.getInt("USERID"));
		userEntity.setfName(resultSet.getString("FNAME"));
		userEntity.setmName(resultSet.getString("MNAME"));
		userEntity.setlName(resultSet.getString("LNAME"));
		userEntity.setAddr(resultSet.getString("ADDR"));
		userEntity.setContactNumber(resultSet.getLong("CONTACTNUMBER"));
		userEntity.setDepartment(resultSet.getString("DEPARTMENT"));
		
		return userEntity;
		
	}
	
	
	
	

}
