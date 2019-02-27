package com.yaoyong.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.sys.entity.Dictionary;

@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {
	@Select("selectDictionaryPage")
	List<Dictionary> selectDictionaryPage(Page<Dictionary> page, @Param("name") String name);

	@Select("selectDictionaryWrapperPage")
	List<Dictionary> selectDictionaryWrapperPage(Page<Dictionary> page, @Param("ew") Wrapper<Dictionary> wrapper);
}
