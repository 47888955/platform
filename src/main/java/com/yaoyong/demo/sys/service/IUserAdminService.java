package com.yaoyong.demo.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.yaoyong.demo.sys.entity.UserAdmin;

/**
*
* @ClassName: UserAdminController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

public interface IUserAdminService extends IService<UserAdmin> {
	
	Page<UserAdmin> selectUserAdminPage(Page<UserAdmin> page, String name);
	Page<UserAdmin> selectUserAdminWrapperPage(Page<UserAdmin> page, Wrapper<UserAdmin> wrapper);

}
