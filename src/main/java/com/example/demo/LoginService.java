package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OtpRepository otpRepository;
	
	   @Autowired
		 JavaMailSender javaMailSender;
	   
	   @Autowired
	   EmailSenderService emailSenderService;
	
	public  boolean checkUsername(String username) {
	
		return userRepository.existsByUsername(username);
	}

	public UserDocument createUser(UserDocument user) {
		
			user.setRole("ROLE_USER");
			
			OtpDocument otpDocument=new OtpDocument();
			try {
				int randomPIN = (int) (Math.random() * 9000) + 1000;
				otpDocument.setOtp(randomPIN);
				otpRepository.save(otpDocument);
				user.setOtpvalue(randomPIN);
				userRepository.save(user);
				String body="Hello \n\n" +"Your Login OTP :" + randomPIN + ".Please Verify. \n\n"+"Regards \n"+"ABC";
				emailSenderService.sendEmail(user.getEmail(), body);
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("coulf not send otp");
			}
			return userRepository.findByUsername(user.getUsername());
	}

	
	  public UserDocument checkUserPassword(UserDocument userDocument) {
	  logger.info("into service");
	  UserDocument userDocument2=userRepository.findByUsername(userDocument.getUsername());
	  System.out.println("service"+userDocument2);
	  logger.info("exit from service");
	  return userDocument2;
	   
	  }

	public UserDocument findByOtp(Integer otp) {
		return userRepository.findByOtpvalue(otp);
	}
}
