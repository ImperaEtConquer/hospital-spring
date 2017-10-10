package eu.lucid.services;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import eu.lucid.domain.Patient;
import eu.lucid.domain.Speciality;
import eu.lucid.domain.Staff;
import eu.lucid.domain.User;
import eu.lucid.rest.PatientDTO;
import eu.lucid.rest.ProfileDTO;
import eu.lucid.rest.StaffDTO;

@Service
public class ConverterService {
	
	public Staff convertStaffDTOtoStaff(StaffDTO staffDTO) {
		User user = new User.Builder()
				.login(staffDTO.getLogin())
				.password(encryptPassword(staffDTO.getPassword()))
				.registeredAt(Date.from(Instant.now()))
				.build();
		
		Staff staff = new Staff.Builder()
				.firstName(staffDTO.getFirstName())
				.lastName(staffDTO.getLastName())
				.birthDate(stringToDate(staffDTO.getBirthDate()))
				.speciality(specialityAsEnum(staffDTO.getSpeciality()))
				.user(user)
				.build();
		
		return staff;
	}
	
	public StaffDTO convertStaffToStaffDTO(Staff staff) {
		StaffDTO staffDTO = new StaffDTO.Builder()
				.staffId(staff.getId())
				.firstName(staff.getFirstName())
				.lastName(staff.getLastName())
				.birthDate(dateToString(staff.getBirthDate()))
				.speciality(staff.getSpeciality().toString())
				.login(staff.getUser().getLogin())
				.build();
		
		return staffDTO;
	}
	
	public Patient convertDTOtoPatient (PatientDTO patientDTO) {
		Patient patient = new Patient.Builder()
				.firstName(patientDTO.getFirstName())
				.lastName(patientDTO.getLastName())
				.birthDate(stringToDate(patientDTO.getBirthDate()))
				.build();
		return patient;
	}
	
	public ProfileDTO convertStaffToProfileDTO (Staff staff) {
		ProfileDTO profileDTO = new ProfileDTO.Builder()
				.staffId(staff.getId())
				.firstName(staff.getFirstName())
				.lastName(staff.getLastName())
				.birthDate(dateToString(staff.getBirthDate()))
				.speciality(staff.getSpeciality().toString())
				.build();
		return profileDTO;
	}

	public Speciality specialityAsEnum(String speciality) {
		return speciality.equals(Speciality.DOCTOR.toString()) ? Speciality.DOCTOR : Speciality.NURSE;
	}

	public String dateToString(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

	public Date stringToDate(String date) {
		String[] data = date.split("-");
		int year = Integer.valueOf(data[0]);
		int month = Integer.valueOf(data[1]);
		int day = Integer.valueOf(data[2]);
		return new GregorianCalendar(year, month - 1, day).getTime();
	}
	
	public String encryptPassword(String password) {
		return DigestUtils.md5Hex(password);
	}
}
