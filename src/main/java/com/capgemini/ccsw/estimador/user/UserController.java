package com.capgemini.ccsw.estimador.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.user.model.UserDto;

/**
 * @author asolerpa
 *
 *         Controllador que expone las operaciones de negocio de la entidad User
 *
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    BeanMapper beanMapper;

    @Autowired
    UserService userService;

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public UserDto getEstimation(@PathVariable String username) {

        return this.beanMapper.map(this.userService.getByUsername(username), UserDto.class);
    }

    @RequestMapping(path = "/filter", method = RequestMethod.POST)
    public List<UserDto> findByFilter(@RequestBody String filter) {

        return this.beanMapper.mapList(this.userService.findByFilter(filter), UserDto.class);
    }
}
