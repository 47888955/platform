package com.yaoyong.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.sys.entity.Permission;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
	@Select("selectPermissionPage")
	List<Permission> selectPermissionPage(Page<Permission> page, @Param("name") String name);

	@Select("selectPermissionWrapperPage")
	List<Permission> selectPermissionWrapperPage(Page<Permission> page, @Param("ew") Wrapper<Permission> wrapper);
}
