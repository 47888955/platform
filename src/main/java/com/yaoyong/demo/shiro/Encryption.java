package com.yaoyong.demo.shiro;

import java.security.SecureRandom;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yaoyong.demo.common.util.JWTUtil;

public class Encryption {
	private static final Logger logger = LoggerFactory.getLogger(Encryption.class);
	// 加密解密次数
	private static int number = 1024;

	public static String encode(String souce) {
		for (int i = 0; i < number; i++) {
			souce = encBase64(souce);
		}
		return souce;
	}

	public static String decode(String souce) {
		for (int i = 0; i < number; i++) {
			souce = decBase64(souce);
		}
		return souce;
	}

	/**
	 * shiro Base64加密
	 *
	 */
	public static String encBase64(String souce) {
		return Base64.encodeToString(souce.getBytes());
	}

	/**
	 * shiro Base64解密
	 *
	 */

	public static String decBase64(String souce) {
		return Base64.decodeToString(souce);
	}

	public static String md5(String souce, String salt) {
		return new Md5Hash(souce, salt).toString();
	}

	public static String getSalt() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[16];
		random.nextBytes(bytes);
		String salt = org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
		return salt;
	}

	public static void main(String args[]) {
		String loginName = "yaoyong";
		String pwd = "123456";
		String salt = Encryption.getSalt();
		String encrypPwd = Encryption.md5(pwd, salt);
		String jwt = JWTUtil.sign(loginName, encrypPwd);

		System.out.println("loginName:"+ loginName);
		System.out.println("password:"+ pwd);
		System.out.println("盐值:"+ salt);
		System.out.println("加密后密码:"+ encrypPwd);
		System.out.println("jwt格式:"+ jwt);
	}

}
