package com.jsu.util;

import java.util.Random;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 手机验证码工具类
 * @author !N
 *
 */
public class PhoneVerify {
	
	/**
	 * 获取6位随机数
	 * @return
	 */
	public static String getCode(){
		String num ="";
		Random random = new Random();
		 for(int i=0;i<6;i++){
			 int n = random.nextInt()%10;
			 num += n<0?n*-1:n; 
		 }
		return num;
	}
	
	/**
	 * 给指定手机发送指定验证码
	 * @param phone
	 * @param code
	 * @return
	 */
	public static boolean sendMsg(String phone,String code){
		 DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIZbEhlh2N8l6s", "HcYXmn06b9jZmTgnpawJsKHXBk0unO");
	        IAcsClient client = new DefaultAcsClient(profile);

	        CommonRequest request = new CommonRequest();
	        request.setMethod(MethodType.POST);
	        request.setDomain("dysmsapi.aliyuncs.com");
	        request.setVersion("2017-05-25");
	        request.setAction("SendSms");
	        request.putQueryParameter("RegionId", "cn-hangzhou");
	        request.putQueryParameter("PhoneNumbers", phone);
	        request.putQueryParameter("SignName", "前程堪忧");
	        request.putQueryParameter("TemplateCode", "SMS_171858981");
	        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code +"\"}");
	        try {
	            CommonResponse response = client.getCommonResponse(request);
	            System.out.println(response.getData());
	        	return true;
	        } catch (ServerException e) {
	            e.printStackTrace();
	        } catch (ClientException e) {
	            e.printStackTrace();
	        }
	    	return false;
	}
}