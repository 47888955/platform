package com.yaoyong.demo.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.yaoyong.demo.sys.entity.RolePerm;

/**
*
* @ClassName: RolePermController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

public interface IRolePermService extends IService<RolePerm> {
	
	Page<RolePerm> selectRolePermPage(Page<RolePerm> page, String name);
	Page<RolePerm> selectRolePermWrapperPage(Page<RolePerm> page, Wrapper<RolePerm> wrapper);

}
