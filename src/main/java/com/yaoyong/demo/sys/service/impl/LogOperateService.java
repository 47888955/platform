package com.yaoyong.demo.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaoyong.demo.sys.entity.LogOperate;
import com.yaoyong.demo.sys.mapper.LogOperateMapper;
import com.yaoyong.demo.sys.service.IDictionaryService;

import com.yaoyong.demo.sys.entity.LogOperate;
import com.yaoyong.demo.sys.mapper.LogOperateMapper;
import com.yaoyong.demo.sys.service.ILogOperateService;


/**
*
* @ClassName: LogOperateService
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Service
public class LogOperateService extends ServiceImpl<LogOperateMapper, LogOperate> implements ILogOperateService {

	@Override
	public Page<LogOperate> selectLogOperatePage(Page<LogOperate> page, String name) {
		page.setRecords(baseMapper.selectLogOperatePage(page, name));
		return page;
	}
	@Override
	public Page<LogOperate> selectLogOperateWrapperPage(Page<LogOperate> page, Wrapper<LogOperate> wrapper) {
		page.setRecords(baseMapper.selectLogOperateWrapperPage(page, wrapper));
		return page;
	}

}