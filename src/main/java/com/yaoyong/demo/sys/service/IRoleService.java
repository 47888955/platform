package com.yaoyong.demo.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.yaoyong.demo.sys.entity.Role;

/**
*
* @ClassName: RoleController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

public interface IRoleService extends IService<Role> {
	
	Page<Role> selectRolePage(Page<Role> page, String name);
	Page<Role> selectRoleWrapperPage(Page<Role> page, Wrapper<Role> wrapper);

}
