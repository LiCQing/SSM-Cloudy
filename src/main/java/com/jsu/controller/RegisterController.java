package com.jsu.controller;

import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsu.pojo.TbUser;
import com.jsu.service.TbUserService;
import com.jsu.util.AESUtil;
import com.jsu.util.PhoneVerify;
import com.jsu.vo.YunResult;

@Controller
public class RegisterController {
	@Autowired
	TbUserService tbUserService;
	private boolean data;
	private static Map codeMap = new Hashtable<>();

	// 注册
	@RequestMapping("register")
	@ResponseBody
	public YunResult register(@RequestParam("phone") String phone, @RequestParam("pwd") String pwd) {
		System.out.println("进入注册");
		TbUser user = new TbUser();
		System.out.println(phone + "----" + pwd);
		user.setuPhone(phone);
		user.setuPwd(pwd);
		int a = tbUserService.userInsert(user);
		return YunResult.success(true);
	}

	// 校验手机号
	@RequestMapping("checkPhone")
	@ResponseBody
	public YunResult checPhone(@RequestParam("phone") String phone) {
		System.out.println("校验手机号");
		data = (TbUser) tbUserService.checkPhone(phone) == null ? true : false;
		return YunResult.success(data);
	}

	// 获取手机号验证码 //token
	@RequestMapping("phoneCode")
	@ResponseBody
	public YunResult phoneCode() {
		String token = "ISGETCODE" + UUID.randomUUID().toString().replaceAll("-", "");

		System.out.println("获取手机验证码");
		PhoneVerify phonecodes = new PhoneVerify();
		String phoneCode = phonecodes.getCode();
		codeMap.put(token, phoneCode);

		System.out.println(phoneCode);
		return YunResult.success(token);
	}

	// 校验手机验证码
	@RequestMapping("checkPhoneCode")
	@ResponseBody
	public YunResult checkPhoneCode(String code, String token) {
		System.out.println("校验手机验证码" + code + "  " + token);
		return YunResult.success(codeMap.get(token).equals(code) ? true : false);
	}

	// 登录验证
	@RequestMapping("login")
	@ResponseBody
	public YunResult checklogin(String phone, String pwd) {
		System.out.println("登录校验");
		// data=codeMap.get(token).equals(code)?true:false;
		// 通过手机号获取用户信息
		TbUser user = tbUserService.checkPhoneAndPwd(phone, pwd);

		if (user != null) {
			String newToken = AESUtil.ecodes(user.getuId() + "");
			System.out.println("用户的id" + user.getuId());
			return YunResult.success(newToken);
		} else {
			return YunResult.success(false);
		}
	}

	@RequestMapping("quikLogin")
	@ResponseBody
	public YunResult quikLogin(String phone, String code, String token) {
		System.out.println("登录校验");
		if(token == null)
			return YunResult.success(false);
		
			boolean result = codeMap.get(token).equals(code) ? true : false;
		if (!result) {
			return YunResult.success(false);
		}
		// 通过手机号获取用户信息
		TbUser user = tbUserService.checkPhone(phone);
		if (user != null) {
			String newToken = AESUtil.ecodes(user.getuId() + "");
			System.out.println("用户的id" + user.getuId());
			return YunResult.success(newToken);
		} else {
			return YunResult.success(false);
		}
	}

}
