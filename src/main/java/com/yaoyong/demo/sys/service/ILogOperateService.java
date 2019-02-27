package com.yaoyong.demo.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.yaoyong.demo.sys.entity.LogOperate;

/**
*
* @ClassName: LogOperateController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

public interface ILogOperateService extends IService<LogOperate> {
	
	Page<LogOperate> selectLogOperatePage(Page<LogOperate> page, String name);
	Page<LogOperate> selectLogOperateWrapperPage(Page<LogOperate> page, Wrapper<LogOperate> wrapper);

}
