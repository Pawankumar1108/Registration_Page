package com.ajaxBasedProject.ajaxProject.sqlQueries;

public class SqlQuery {
	
	public static final String GET_ALL_USER_LIST = "SELECT * FROM USER_REGISTRATION";
	
	public static final String NEW_USER_REGISTRATION = "INSERT INTO USER_REGISTRATION(userId,fName,mName,lName,addr,contactNumber,department)VALUES(:userId,:fName,:mName,:lName,:addr,:contactNumber,:department)";

}
