package com.yaoyong.demo.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.yaoyong.demo.sys.entity.User;

/**
*
* @ClassName: UserController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

public interface IUserService extends IService<User> {
	
	Page<User> selectUserPage(Page<User> page, String name);
	Page<User> selectUserWrapperPage(Page<User> page, Wrapper<User> wrapper);

}
