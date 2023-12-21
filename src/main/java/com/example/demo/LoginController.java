package com.example.demo;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
    @Autowired
	LoginService loginService;

	@RequestMapping("/")
	public String login() {
		return "login";
	}

@RequestMapping("/register")
public String registerPage() {
	return "register";
}

@RequestMapping("/logout")
public String logoutPage() {
	return "logout";
}


@PostMapping("createUser")
public String createuser(@ModelAttribute UserDocument user, Model session) {

	 System.out.println(user);

	boolean f = loginService.checkUsername(user.getUsername());

	if (f) {
		session.addAttribute("msg", "Email Id alreday exists");
		return "redirect:/register";
	}

	else {
		UserDocument userDtls =loginService.createUser(user);
		
		if (userDtls != null) {
			return "otpVerfication";
		}
//			session.addAttribute("msg", "Register Sucessfully Please login");
//			return "login";
	  else {
		session.addAttribute("msg", "Something wrong on server");
		return "register";
		}
	}
}


  @PostMapping("login") 
  public String signUp(@ModelAttribute UserDocument userDocument,Model model) {
	  
	  System.out.println(userDocument); 
	  logger.info("into contoller");
	  UserDocument userDocument2=loginService.checkUserPassword(userDocument);
	  if(userDocument2!=null) {
		  logger.info("into if");
		  if(userDocument2.getPassword().equalsIgnoreCase(userDocument.getPassword())) {
			  model.addAttribute("msg","successfully registered");
			  model.addAttribute("user",userDocument2);
			  logger.info("success");
			  return "dashboard";
		  }
		  if(userDocument2==null || !userDocument2.getPassword().equalsIgnoreCase(userDocument.getPassword())) {
			  logger.info("failed");
			  model.addAttribute("msg","invalid username or password");
			  System.out.println("invalid username");
			  return "login";
		  }
	  }
	return "login";
  
  }
  @PostMapping("otpVerification")
  public String otpVerification(@ModelAttribute OtpDocument otpDocument,Model session) {
	logger.info("into verification process");  
	  UserDocument userDocument=loginService.findByOtp(otpDocument.getOtp());
	  
	  if (userDocument != null) {
		  session.addAttribute("msg", "Register Sucessfully Please login");
		  logger.info("verification success "); 
			return "login";
			
		}else {
			session.addAttribute("msg", "invalid OTP please enter valid OTP");
			logger.info("verification failed "); 
			return "otpVerfication";
		}


	  
  }
}
