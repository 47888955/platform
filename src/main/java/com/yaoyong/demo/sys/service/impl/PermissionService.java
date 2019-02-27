package com.yaoyong.demo.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaoyong.demo.sys.entity.Permission;
import com.yaoyong.demo.sys.mapper.PermissionMapper;
import com.yaoyong.demo.sys.service.IDictionaryService;

import com.yaoyong.demo.sys.entity.Permission;
import com.yaoyong.demo.sys.mapper.PermissionMapper;
import com.yaoyong.demo.sys.service.IPermissionService;


/**
*
* @ClassName: PermissionService
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Service
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

	@Override
	public Page<Permission> selectPermissionPage(Page<Permission> page, String name) {
		page.setRecords(baseMapper.selectPermissionPage(page, name));
		return page;
	}
	@Override
	public Page<Permission> selectPermissionWrapperPage(Page<Permission> page, Wrapper<Permission> wrapper) {
		page.setRecords(baseMapper.selectPermissionWrapperPage(page, wrapper));
		return page;
	}

}