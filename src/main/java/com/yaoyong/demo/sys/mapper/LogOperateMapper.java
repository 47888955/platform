package com.yaoyong.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.sys.entity.LogOperate;

@Mapper
public interface LogOperateMapper extends BaseMapper<LogOperate> {
	@Select("selectLogOperatePage")
	List<LogOperate> selectLogOperatePage(Page<LogOperate> page, @Param("name") String name);

	@Select("selectLogOperateWrapperPage")
	List<LogOperate> selectLogOperateWrapperPage(Page<LogOperate> page, @Param("ew") Wrapper<LogOperate> wrapper);
}
