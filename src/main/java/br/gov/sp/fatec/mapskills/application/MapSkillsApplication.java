/*
 * @(#)MapSkillsApplication.java 1.0 08/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.application;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MapSkillsApplication {
	
	static final PasswordEncoder encoder = new BCryptPasswordEncoder();
	static final PasswordEncoder encoder2 = new BCryptPasswordEncoder(5);
	static final String RAW_PASSWORD = "mudar@123";
	
	public static void main(final String[] args) {
		final String hashed01 = encode(RAW_PASSWORD);
		final String hashed02 = encode(RAW_PASSWORD);
		System.out.println("PASS CRYPTED 1: " + hashed01);
		System.out.println("PASS CRYPTED 2: " + hashed02);
		System.out.println("RESULT 1: " + hashVerify(RAW_PASSWORD, hashed01));
		System.out.println("RESULT 2: " + hashVerify(RAW_PASSWORD, hashed02));
	}
	
	static String encode(final String pass) {
		return encoder.encode(pass);
	}
	
	static boolean hashVerify(final String rawPassword, final String bcryptHash) {
		return encoder2.matches(rawPassword, bcryptHash);
	}
	
}
