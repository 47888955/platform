package com.yaoyong.demo.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.yaoyong.demo.sys.entity.UserInfo;

/**
*
* @ClassName: UserInfoController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

public interface IUserInfoService extends IService<UserInfo> {
	
	Page<UserInfo> selectUserInfoPage(Page<UserInfo> page, String name);
	Page<UserInfo> selectUserInfoWrapperPage(Page<UserInfo> page, Wrapper<UserInfo> wrapper);

}
