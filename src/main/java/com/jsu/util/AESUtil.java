package com.jsu.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * token 加密解密
 * @author !N
 *
 */

public class AESUtil {
	
		private final static String key = "2b72cc3d1426554818da16e13f6a249c";
		
		
		public static String ecodes(String content){
			return ecodes(content,key);
		}
		
		
		/**
		 * <p>Discription:[加密]</p>
		 * Created on 2017年11月28日 下午4:16:30
		 * @param content 明文 用JSON.toJSONString(Map<String, String> map)转换的json字符串
		 * @param key 加解密规则 访客系统提供key
		 * @return String 密文
		 * @author:[全冉]
		 */
		public static String ecodes(String content, String key) {
			if (content == null || content.length() < 1) {
				return null;
			}
			try {
				KeyGenerator kgen = KeyGenerator.getInstance("AES");
				SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
				random.setSeed(key.getBytes());
				kgen.init(128, random);
				SecretKey secretKey = kgen.generateKey();
				byte[] enCodeFormat = secretKey.getEncoded();
				SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
				Cipher cipher = Cipher.getInstance("AES");
				byte[] byteContent = content.getBytes("utf-8");
				cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
				byte[] byteRresult = cipher.doFinal(byteContent);
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < byteRresult.length; i++) {
					String hex = Integer.toHexString(byteRresult[i] & 0xFF);
					if (hex.length() == 1) {
						hex = '0' + hex;
					}
					sb.append(hex.toUpperCase());
				}
				return sb.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public static String dcodes(String content) {
			return dcodes(content,key);
		}
	 
		/**
		 * <p>Discription:[解密]</p>WW
		 * Created on 2017年11月28日 下午4:17:49
		 * @param content 密文
		 * @param key 加解密规则
		 * @return String 明文
		 * @author:[全冉]
		 */
		public static String dcodes(String content, String key) {
			if (content == null || content.length() < 1) {
				return null;
			}
			if (content.trim().length() < 19) {
				return content;
			}
			byte[] byteRresult = new byte[content.length() / 2];
			for (int i = 0; i < content.length() / 2; i++) {
				int high = Integer.parseInt(content.substring(i * 2, i * 2 + 1), 16);
				int low = Integer.parseInt(content.substring(i * 2 + 1, i * 2 + 2), 16);
				byteRresult[i] = (byte) (high * 16 + low);
			}
			try {
				KeyGenerator kgen = KeyGenerator.getInstance("AES");
				SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
				random.setSeed(key.getBytes());
				kgen.init(128, random);
				SecretKey secretKey = kgen.generateKey();
				byte[] enCodeFormat = secretKey.getEncoded();
				SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
				Cipher cipher = Cipher.getInstance("AES");
				cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
				byte[] result = cipher.doFinal(byteRresult);
				return new String(result);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public static void main(String[] args) {
			try {
				//String content = "{loginStatus:false,uid:0}";
				String content = "1";
				String miwen = AESUtil.ecodes(content,key);
				System.out.println("miwen : " + miwen);
				
				String mingwen = AESUtil.dcodes(miwen,  key);
				System.out.println("mingwen : " + mingwen);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
}
