package com.yaoyong.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.sys.entity.UserRole;

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
	@Select("selectUserRolePage")
	List<UserRole> selectUserRolePage(Page<UserRole> page, @Param("name") String name);

	@Select("selectUserRoleWrapperPage")
	List<UserRole> selectUserRoleWrapperPage(Page<UserRole> page, @Param("ew") Wrapper<UserRole> wrapper);
}
