package com.ajaxBasedProject.ajaxProject.service;

import java.util.List;
import com.ajaxBasedProject.ajaxProject.dao.UserEntity;


public interface  UserService {
	
	public List<UserEntity> getAllUserList() throws Exception;

	public boolean getNewRegistration(int i, String string, String string2, String string3, String string4, long l, String string5)throws Exception;

	public void getNewUser(UserEntity userEentity) throws Exception;

}
