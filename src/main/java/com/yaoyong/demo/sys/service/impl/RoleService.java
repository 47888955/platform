package com.yaoyong.demo.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaoyong.demo.sys.entity.Role;
import com.yaoyong.demo.sys.mapper.RoleMapper;
import com.yaoyong.demo.sys.service.IDictionaryService;

import com.yaoyong.demo.sys.entity.Role;
import com.yaoyong.demo.sys.mapper.RoleMapper;
import com.yaoyong.demo.sys.service.IRoleService;


/**
*
* @ClassName: RoleService
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

	@Override
	public Page<Role> selectRolePage(Page<Role> page, String name) {
		page.setRecords(baseMapper.selectRolePage(page, name));
		return page;
	}
	@Override
	public Page<Role> selectRoleWrapperPage(Page<Role> page, Wrapper<Role> wrapper) {
		page.setRecords(baseMapper.selectRoleWrapperPage(page, wrapper));
		return page;
	}

}