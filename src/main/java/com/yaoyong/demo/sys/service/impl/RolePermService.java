package com.yaoyong.demo.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaoyong.demo.sys.entity.RolePerm;
import com.yaoyong.demo.sys.mapper.RolePermMapper;
import com.yaoyong.demo.sys.service.IDictionaryService;

import com.yaoyong.demo.sys.entity.RolePerm;
import com.yaoyong.demo.sys.mapper.RolePermMapper;
import com.yaoyong.demo.sys.service.IRolePermService;


/**
*
* @ClassName: RolePermService
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Service
public class RolePermService extends ServiceImpl<RolePermMapper, RolePerm> implements IRolePermService {

	@Override
	public Page<RolePerm> selectRolePermPage(Page<RolePerm> page, String name) {
		page.setRecords(baseMapper.selectRolePermPage(page, name));
		return page;
	}
	@Override
	public Page<RolePerm> selectRolePermWrapperPage(Page<RolePerm> page, Wrapper<RolePerm> wrapper) {
		page.setRecords(baseMapper.selectRolePermWrapperPage(page, wrapper));
		return page;
	}

}