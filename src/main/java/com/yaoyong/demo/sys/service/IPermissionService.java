package com.yaoyong.demo.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.yaoyong.demo.sys.entity.Permission;

/**
*
* @ClassName: PermissionController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

public interface IPermissionService extends IService<Permission> {
	
	Page<Permission> selectPermissionPage(Page<Permission> page, String name);
	Page<Permission> selectPermissionWrapperPage(Page<Permission> page, Wrapper<Permission> wrapper);

}
