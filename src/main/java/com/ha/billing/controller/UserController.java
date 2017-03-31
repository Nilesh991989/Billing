package com.ha.billing.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ha.billing.entity.User;
import com.ha.billing.model.request.UserLoginRequest;
import com.ha.billing.model.response.LoginResponse;
import com.ha.billing.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody final UserLoginRequest loginrequest)
        throws ServletException {
    	
    	User user = userRepository.findByUsername(loginrequest.getName().trim().toLowerCase());
    	
    	if(user == null) 
    		throw new ServletException("Invalid user name or password");
        
        if (!user.getPassword().equals(loginrequest.getPassword()))         		
            throw new ServletException("Invalid user name password");
        
        if (user.getActive().equals("N"))
            throw new ServletException("User is not active");
        
        
        Map<String,Object> claim = new HashMap<>();
        claim.put("billingid", "9960049799");
        
        return new LoginResponse(Jwts.builder().setSubject(loginrequest.getName())
            .setIssuedAt(new Date())
            .setExpiration(new Date())
            .setClaims(claim)
            .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void registerUser(@RequestBody final User user){
         userRepository.save(user);
    }
    
    @RequestMapping(value = "/register/{username}/{password}", method = RequestMethod.GET)
    public void registerUser(@PathVariable(value="username") final String user, @PathVariable(value="password") final String password){
    	User userdetails = new User();
    	userdetails.setUsername(user);
    	userdetails.setPassword(password);
    	userdetails.setRole("User");
    	userdetails.setActive("Y");
    	userRepository.save(userdetails);
    }
}
