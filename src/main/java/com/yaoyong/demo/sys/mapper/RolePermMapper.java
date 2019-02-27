package com.yaoyong.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.sys.entity.RolePerm;

@Mapper
public interface RolePermMapper extends BaseMapper<RolePerm> {
	@Select("selectRolePermPage")
	List<RolePerm> selectRolePermPage(Page<RolePerm> page, @Param("name") String name);

	@Select("selectRolePermWrapperPage")
	List<RolePerm> selectRolePermWrapperPage(Page<RolePerm> page, @Param("ew") Wrapper<RolePerm> wrapper);
}
