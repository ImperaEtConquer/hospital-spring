package eu.lucid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.repositories.StaffRepository;
import eu.lucid.repositories.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private UserRepository userRepository;
}
