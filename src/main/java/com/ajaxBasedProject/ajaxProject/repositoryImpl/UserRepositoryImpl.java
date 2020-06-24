package com.ajaxBasedProject.ajaxProject.repositoryImpl;
import static com.ajaxBasedProject.ajaxProject.sqlQueries.SqlQuery.GET_ALL_USER_LIST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ajaxBasedProject.ajaxProject.dao.UserEntity;
import com.ajaxBasedProject.ajaxProject.repository.UserRepositry;
import com.ajaxBasedProject.ajaxProject.userMapper.UserMapper;
import static com.ajaxBasedProject.ajaxProject.sqlQueries.SqlQuery.NEW_USER_REGISTRATION;



/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/

@Repository("UserRepository")
public class UserRepositoryImpl implements UserRepositry{

	@Autowired
	NamedParameterJdbcTemplate  namedParameterJdbcTemplate;

	//private static final Logger LOGGER = LogManager.getLogger(UserRepositoryImpl.class); 

	@Override
	public List<UserEntity> getAllUserList() {

		Map<String , String> paramMap =new HashMap<>();

		List<UserEntity> userList = namedParameterJdbcTemplate.query(GET_ALL_USER_LIST,paramMap, new UserMapper());


		return userList;

	}

	@Override
	public boolean getNewRegistration(int userId, String fName, String mName, String lName, String addr,
			long contactNumber, String dept) {

		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("userId", userId);
		paramMap.put("fName", fName);
		paramMap.put("mName",mName);
		paramMap.put("lName", lName);
		paramMap.put("addr", addr);
		paramMap.put("contactNumber",contactNumber );
		paramMap.put("dept", dept);

		
		 int newUser = namedParameterJdbcTemplate.update(NEW_USER_REGISTRATION, (SqlParameterSource)paramMap); 
		
		if(newUser !=0) {
		return true;
		}else {
			throw new ClassCastException("Unable to Feed the New Registration At this Moment");
		}
	}
	
	
	@Override
	public void getNewUser(UserEntity userEentity) {
		
	    KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
    
        		.addValue("userId",userEentity.getUserId())
        		.addValue("fName",userEentity.getfName())
        		.addValue("mName",userEentity.getmName())
        		.addValue("lName",userEentity.getlName())
        		.addValue("addr",userEentity.getAddr())
        		.addValue("contactNumber",userEentity.getContactNumber())
        		.addValue("department",userEentity.getDepartment());
        		.addValue("password",userEentity.getPassword());
        namedParameterJdbcTemplate.update(NEW_USER_REGISTRATION,param,holder);
	}

}	
