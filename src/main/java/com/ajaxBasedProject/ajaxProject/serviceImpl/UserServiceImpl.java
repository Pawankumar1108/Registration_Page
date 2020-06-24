package com.ajaxBasedProject.ajaxProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajaxBasedProject.ajaxProject.dao.UserEntity;
import com.ajaxBasedProject.ajaxProject.repository.UserRepositry;
import com.ajaxBasedProject.ajaxProject.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepositry userRepositry;

	@Override
	public List<UserEntity> getAllUserList() throws Exception {
		
		return userRepositry.getAllUserList() ;
	}

	@Override
	public boolean getNewRegistration(int userId, String fName, String mName, String lName, String addr, long contactNumber,
			String dept) throws Exception {
		
		return userRepositry.getNewRegistration(userId,fName,mName,lName,addr,contactNumber,dept);
	}

	@Override
	public void getNewUser(UserEntity userEentity) throws Exception {
		
		userRepositry.getNewUser(userEentity);
	}
	
	

}
