package com.yaoyong.demo.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaoyong.demo.sys.entity.UserInfo;
import com.yaoyong.demo.sys.mapper.UserInfoMapper;
import com.yaoyong.demo.sys.service.IDictionaryService;

import com.yaoyong.demo.sys.entity.UserInfo;
import com.yaoyong.demo.sys.mapper.UserInfoMapper;
import com.yaoyong.demo.sys.service.IUserInfoService;


/**
*
* @ClassName: UserInfoService
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Service
public class UserInfoService extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

	@Override
	public Page<UserInfo> selectUserInfoPage(Page<UserInfo> page, String name) {
		page.setRecords(baseMapper.selectUserInfoPage(page, name));
		return page;
	}
	@Override
	public Page<UserInfo> selectUserInfoWrapperPage(Page<UserInfo> page, Wrapper<UserInfo> wrapper) {
		page.setRecords(baseMapper.selectUserInfoWrapperPage(page, wrapper));
		return page;
	}

}