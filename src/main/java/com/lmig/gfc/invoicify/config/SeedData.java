package com.lmig.gfc.invoicify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.UserRepository;

@Configuration
public class SeedData {

	public SeedData(UserRepository userRepo, PasswordEncoder pe) {
		String encodedPassword = pe.encode("password");
		User user = new User();
		user.setUsername("david");
		user.setPassword(encodedPassword);
		userRepo.save(user);

	}

}
