package com.jsu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsu.dao.TbUserMapper;
import com.jsu.pojo.TbUser;
import com.jsu.pojo.TbUserExample;
import com.jsu.pojo.TbUserExample.Criteria;

@Service
public class TbUserService {
	@Autowired
	TbUserMapper   tbUserMapperMapper;
	/**
	 * 添加一个用户
	 * @param expample
	 * @return
	 */
	public int userInsert(TbUser expample){
		return tbUserMapperMapper.insertSelective(expample);
		
	}
	//校验手机号是否注册过
	public  TbUser  checkPhone(String phone){
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUPhoneEqualTo(phone);
		List<TbUser> list = tbUserMapperMapper.selectByExample(example);
		return list.size()>0?list.get(0):null;
	}
	
	//登录校验
	public  TbUser  checklogin(String phone,String pwd){
		//return tbUserMapperMapper.checklogin(phone,pwd);
		return null;
	}
	/**
	 * 用户信息更新
	 * @param expample
	 * @return
	 */
	public int userUpdate(TbUser expample){
		return tbUserMapperMapper.updateByPrimaryKeySelective(expample);
	}
	
    /**
     * 按id查询用户信息
     * @param uid
     * @return
     */
	public  TbUser findUserListById(int uid){
		return tbUserMapperMapper.selectByPrimaryKey(uid);
	}
	/**
	 * 查询所有用户信息
	 * @param expample
	 * @return
	 */
	public  List<TbUser>  findUserListAll(TbUserExample expample){
		return tbUserMapperMapper.selectByExample(expample);
	}
	/**
	 * 删除用户
	 * @param uid
	 * @return
	 */
	public int deleteUser(int uid){
		return  tbUserMapperMapper.deleteByPrimaryKey(uid);
	}
	public TbUser checkPhoneAndPwd(String phone, String pwd) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUPhoneEqualTo(phone);
		criteria.andUPwdEqualTo(pwd);
		List<TbUser> list = tbUserMapperMapper.selectByExample(example);
		return list.size()>0?list.get(0):null;
	}

}
