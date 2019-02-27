package com.yaoyong.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.sys.entity.Role;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
	@Select("selectRolePage")
	List<Role> selectRolePage(Page<Role> page, @Param("name") String name);

	@Select("selectRoleWrapperPage")
	List<Role> selectRoleWrapperPage(Page<Role> page, @Param("ew") Wrapper<Role> wrapper);
}
