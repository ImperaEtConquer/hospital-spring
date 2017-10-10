package eu.lucid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.domain.Staff;
import eu.lucid.repositories.StaffRepository;
import eu.lucid.rest.StaffDTO;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private ConverterService converterService;

	public void updateProfile(StaffDTO staffDTO) {
		Staff staff = staffRepository.findOne(staffDTO.getStaffId());
		staff.setFirstName(staffDTO.getFirstName());
		staff.setLastName(staffDTO.getLastName());
		staff.setBirthDate(converterService.stringToDate(staffDTO.getBirthDate()));
		staff.setSpeciality(converterService.specialityAsEnum(staffDTO.getSpeciality()));
		staffRepository.save(staff);
	}

	public void deleteProfile(StaffDTO staffDTO) {
		staffRepository.delete(staffDTO.getStaffId());
	}
}
