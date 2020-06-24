package com.ajaxBasedProject.ajaxProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajaxBasedProject.ajaxProject.dao.UserEntity;
import com.ajaxBasedProject.ajaxProject.responseMessage.Response;
import com.ajaxBasedProject.ajaxProject.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.Logger;


@RestController("UserController")
public class UserController {

	@Autowired
	UserService userService;

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	//Geting Object of UserEntity Class for the Adding record from the UI side
	
	 List<UserEntity> userEnty = new ArrayList<UserEntity>();

	@GetMapping("/registeredUser")
	public List<UserEntity> getAllUser() throws Exception{

		LOGGER.info("All the Registered User List..");
		return userService.getAllUserList();
	}

	@PostMapping("/registration")
	public boolean getNewRegistration(@RequestBody String jsonRequest) throws Exception {
		LOGGER.info("New Registration is Processing..");

		ObjectMapper objectMapper = new ObjectMapper();
		UserEntity UserEntity = objectMapper.readValue(jsonRequest, UserEntity.class);

		return userService.getNewRegistration(UserEntity.getUserId(),UserEntity.getfName(),UserEntity.getmName(),
				UserEntity.getlName(),UserEntity.getAddr(),UserEntity.getContactNumber(),UserEntity.getDepartment());

	}
	
	@PostMapping("/userRegister")
	public Response getNewUser(@RequestBody UserEntity userEentity)throws Exception {
	
		
		LOGGER.info("New User Been Registered..");
		userEnty.add(userEentity);
		userService.getNewUser(userEentity);
		
	
		 // Create Response Object
	    Response response = new Response("Done", userEentity);
		
	    return response;
		
		
	}


}
