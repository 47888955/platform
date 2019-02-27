package com.yaoyong.demo.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaoyong.demo.sys.entity.UserRole;
import com.yaoyong.demo.sys.mapper.UserRoleMapper;
import com.yaoyong.demo.sys.service.IDictionaryService;

import com.yaoyong.demo.sys.entity.UserRole;
import com.yaoyong.demo.sys.mapper.UserRoleMapper;
import com.yaoyong.demo.sys.service.IUserRoleService;


/**
*
* @ClassName: UserRoleService
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Service
public class UserRoleService extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

	@Override
	public Page<UserRole> selectUserRolePage(Page<UserRole> page, String name) {
		page.setRecords(baseMapper.selectUserRolePage(page, name));
		return page;
	}
	@Override
	public Page<UserRole> selectUserRoleWrapperPage(Page<UserRole> page, Wrapper<UserRole> wrapper) {
		page.setRecords(baseMapper.selectUserRoleWrapperPage(page, wrapper));
		return page;
	}

}