package com.RestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.RestAPI.dao.userDetailDao;
import com.RestAPI.model.UserDetails;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RestApiApplication.class, args);

		/* userDetailDao userDetailDao = context.getBean(userDetailDao.class); */

		/*
		 * UserDetails details = new UserDetails(); details.setFull_name("abhinav");
		 * details.decodePassword("1234"); details.setStatus(1);
		 * details.setUser_email("abhinav@gmail.com");
		 * details.setUserimage("user_image"); //
		 * details.setUserImageb64(Config.upload_directory + //
		 * rs.getString("user_image")); details.setRole_name("SUPADM");
		 * details.setUsername("Supervisor"); details.setUserID(4);
		 * details.setState("mumbai"); details.setCity("delhi");
		 * details.setZone("North"); details.setMobile_number("7710903455");
		 * 
		 * System.out.println(userDetailDao.save(details));
		 */
	}

}
