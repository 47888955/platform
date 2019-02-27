package com.yaoyong.demo.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaoyong.demo.sys.entity.Dictionary;
import com.yaoyong.demo.sys.mapper.DictionaryMapper;
import com.yaoyong.demo.sys.service.IDictionaryService;

import com.yaoyong.demo.sys.entity.Dictionary;
import com.yaoyong.demo.sys.mapper.DictionaryMapper;
import com.yaoyong.demo.sys.service.IDictionaryService;


/**
*
* @ClassName: DictionaryService
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Service
public class DictionaryService extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {

	@Override
	public Page<Dictionary> selectDictionaryPage(Page<Dictionary> page, String name) {
		page.setRecords(baseMapper.selectDictionaryPage(page, name));
		return page;
	}
	@Override
	public Page<Dictionary> selectDictionaryWrapperPage(Page<Dictionary> page, Wrapper<Dictionary> wrapper) {
		page.setRecords(baseMapper.selectDictionaryWrapperPage(page, wrapper));
		return page;
	}

}