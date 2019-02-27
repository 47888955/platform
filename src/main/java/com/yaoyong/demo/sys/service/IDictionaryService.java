package com.yaoyong.demo.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.yaoyong.demo.sys.entity.Dictionary;

/**
*
* @ClassName: DictionaryController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

public interface IDictionaryService extends IService<Dictionary> {
	
	Page<Dictionary> selectDictionaryPage(Page<Dictionary> page, String name);
	Page<Dictionary> selectDictionaryWrapperPage(Page<Dictionary> page, Wrapper<Dictionary> wrapper);

}
