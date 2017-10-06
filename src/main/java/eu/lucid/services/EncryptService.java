package eu.lucid.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class EncryptService {

	public static String encryptPassword(String password) {
		return DigestUtils.md5Hex(password);
	}

}
