package com.ajaxBasedProject.ajaxProject.repository;

import java.util.List;
import com.ajaxBasedProject.ajaxProject.dao.UserEntity;


public interface UserRepositry {
	
	public List<UserEntity> getAllUserList();

	public boolean getNewRegistration(int userId, String fName, String mName, String lName, String addr,
			long contactNumber, String dept);

	

	public void getNewUser(UserEntity userEentity);

}
