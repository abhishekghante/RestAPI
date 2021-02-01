package com.RestAPI.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.RestAPI.dao.userDetailDao;
import com.RestAPI.model.UserDetails;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	userDetailDao userDetailDao;
	
	@GetMapping(path = "/Login/{username},{password}")
	public Response getUSerDetail(@PathParam("username") String username, @PathParam("password") String password,HttpServletRequest request) {
		String userName = request.getParameter(username);
		String passWord = request.getParameter(password);

		List<UserDetails> user = userDetailDao.findByUsernameAndPassword(userName, passWord);

		return Response.status(200).entity(user).build();

	}
	
	@CrossOrigin
	
	
	 
	/* @RequestMapping(value = "/Login/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON) */
	  @GetMapping(path = "/Login/{username}")
	  public ResponseEntity<List<UserDetails>> getSingleDetail(@PathParam("username") String username, HttpServletRequest request) {
		String userName = request.getParameter(username);

		List<UserDetails> user = userDetailDao.findByUsername(userName);

		return ResponseEntity.status(200).build();

	}

}
