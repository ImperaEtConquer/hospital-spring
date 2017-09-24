package eu.lucid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.repositories.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;
}
