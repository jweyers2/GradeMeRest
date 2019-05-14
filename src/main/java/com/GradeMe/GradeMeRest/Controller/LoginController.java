package com.GradeMe.GradeMeRest.Controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GradeMe.GradeMeRest.Domain.User;


@RestController
public class LoginController {
	
//	@PostMapping("/register")
//	public String register(){
//		return "register successfully called";
//	}
	
	@PostMapping("/register")
	public User register(@RequestBody Map<String, String> body){
		String firstname = body.get("firstname");
		String lastname = body.get("lastname");
		return new User(firstname,lastname);
	}
}
