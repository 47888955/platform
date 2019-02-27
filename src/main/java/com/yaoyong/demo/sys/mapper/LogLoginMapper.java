package com.yaoyong.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.sys.entity.LogLogin;

@Mapper
public interface LogLoginMapper extends BaseMapper<LogLogin> {
	@Select("selectLogLoginPage")
	List<LogLogin> selectLogLoginPage(Page<LogLogin> page, @Param("name") String name);

	@Select("selectLogLoginWrapperPage")
	List<LogLogin> selectLogLoginWrapperPage(Page<LogLogin> page, @Param("ew") Wrapper<LogLogin> wrapper);
}
