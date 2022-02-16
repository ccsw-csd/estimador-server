package com.capgemini.ccsw.estimador.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.user.UserService;

@RequestMapping(value = "/security/")
@RestController
public class SecurityController {

   @Autowired
   UserService userService;
	
   @RequestMapping(path = "/user/", method = RequestMethod.GET)
   public UserInfoAppDto get() {
	   
	  UserInfoAppDto userInfoAppDto = UserUtils.getUserDetails();
	  
	  if( userService.getByUsername(userInfoAppDto.getUsername()) == null ) {
		  userInfoAppDto.setRole("2"); 
		  userService.save(userInfoAppDto);
	  }
		   
      return userInfoAppDto;

   }
}
