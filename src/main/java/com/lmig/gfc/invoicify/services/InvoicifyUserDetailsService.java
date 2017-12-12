package com.lmig.gfc.invoicify.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lmig.gfc.invoicify.models.User;

@Service
public class InvoicifyUserDetailsService implements UserDetailsService {
	private UserRepository userRepo;

	public InvoicifyUserDetailsService(UserRepository ur) {
		userRepo = ur;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return user;
	}

}
