package eu.lucid.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptUtils {
	
	public static String encryptPassword(String password) {
		return DigestUtils.md5Hex(password);
	}
	
}
