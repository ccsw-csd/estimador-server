package com.capgemini.ccsw.estimador.config.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/security/")
@RestController
public class SecurityController {

   @RequestMapping(path = "/user/", method = RequestMethod.GET)
   public UserInfoAppDto get() {

      //TODO: Aquí se debería crear el usuario si no existe
      return UserUtils.getUserDetails();

   }
}
