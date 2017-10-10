package eu.lucid.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.domain.Staff;
import eu.lucid.repositories.StaffRepository;
import eu.lucid.rest.ProfileDTO;
import eu.lucid.rest.StaffDTO;

@Service
public class StaffService {

	private final StaffRepository staffRepository;

	private final ConverterService converterService;

	@Autowired
	public StaffService(StaffRepository staffRepository, ConverterService converterService) {
		this.staffRepository = staffRepository;
		this.converterService = converterService;
	}

	public void updateProfile(ProfileDTO profileDTO) {
		Staff staff = staffRepository.findOne(profileDTO.getStaffId());
		staff.setFirstName(profileDTO.getFirstName());
		staff.setLastName(profileDTO.getLastName());
		staff.setBirthDate(converterService.stringToDate(profileDTO.getBirthDate()));
		staff.setSpeciality(converterService.specialityAsEnum(profileDTO.getSpeciality()));
		staffRepository.save(staff);
	}

	public void deleteProfile(StaffDTO staffDTO) {
		staffRepository.delete(staffDTO.getStaffId());
	}
	
	public ProfileDTO findOne(Long id) {
		Staff staff = staffRepository.findOne(id);
		return converterService.convertStaffToProfileDTO(staff);
	}
	
	public List<ProfileDTO> findAll(){
		List<Staff> staffList = staffRepository.findAll();
		List<ProfileDTO> profileDTOlist = staffList.stream()
				.map(e -> converterService.convertStaffToProfileDTO(e))
				.collect(Collectors.toList());
		return profileDTOlist;
	}
}
