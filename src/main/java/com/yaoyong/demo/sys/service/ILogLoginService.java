package com.yaoyong.demo.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.yaoyong.demo.sys.entity.LogLogin;

/**
*
* @ClassName: LogLoginController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

public interface ILogLoginService extends IService<LogLogin> {
	
	Page<LogLogin> selectLogLoginPage(Page<LogLogin> page, String name);
	Page<LogLogin> selectLogLoginWrapperPage(Page<LogLogin> page, Wrapper<LogLogin> wrapper);

}
