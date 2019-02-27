package com.yaoyong.demo.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.yaoyong.demo.sys.entity.UserRole;

/**
*
* @ClassName: UserRoleController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

public interface IUserRoleService extends IService<UserRole> {
	
	Page<UserRole> selectUserRolePage(Page<UserRole> page, String name);
	Page<UserRole> selectUserRoleWrapperPage(Page<UserRole> page, Wrapper<UserRole> wrapper);

}
