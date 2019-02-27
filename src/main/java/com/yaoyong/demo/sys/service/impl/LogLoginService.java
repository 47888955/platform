package com.yaoyong.demo.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaoyong.demo.sys.entity.LogLogin;
import com.yaoyong.demo.sys.mapper.LogLoginMapper;
import com.yaoyong.demo.sys.service.IDictionaryService;

import com.yaoyong.demo.sys.entity.LogLogin;
import com.yaoyong.demo.sys.mapper.LogLoginMapper;
import com.yaoyong.demo.sys.service.ILogLoginService;


/**
*
* @ClassName: LogLoginService
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Service
public class LogLoginService extends ServiceImpl<LogLoginMapper, LogLogin> implements ILogLoginService {

	@Override
	public Page<LogLogin> selectLogLoginPage(Page<LogLogin> page, String name) {
		page.setRecords(baseMapper.selectLogLoginPage(page, name));
		return page;
	}
	@Override
	public Page<LogLogin> selectLogLoginWrapperPage(Page<LogLogin> page, Wrapper<LogLogin> wrapper) {
		page.setRecords(baseMapper.selectLogLoginWrapperPage(page, wrapper));
		return page;
	}

}