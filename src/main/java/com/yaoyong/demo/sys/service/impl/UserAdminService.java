package com.yaoyong.demo.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaoyong.demo.sys.entity.UserAdmin;
import com.yaoyong.demo.sys.mapper.UserAdminMapper;
import com.yaoyong.demo.sys.service.IDictionaryService;

import com.yaoyong.demo.sys.entity.UserAdmin;
import com.yaoyong.demo.sys.mapper.UserAdminMapper;
import com.yaoyong.demo.sys.service.IUserAdminService;


/**
*
* @ClassName: UserAdminService
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Service
public class UserAdminService extends ServiceImpl<UserAdminMapper, UserAdmin> implements IUserAdminService {

	@Override
	public Page<UserAdmin> selectUserAdminPage(Page<UserAdmin> page, String name) {
		page.setRecords(baseMapper.selectUserAdminPage(page, name));
		return page;
	}
	@Override
	public Page<UserAdmin> selectUserAdminWrapperPage(Page<UserAdmin> page, Wrapper<UserAdmin> wrapper) {
		page.setRecords(baseMapper.selectUserAdminWrapperPage(page, wrapper));
		return page;
	}

}