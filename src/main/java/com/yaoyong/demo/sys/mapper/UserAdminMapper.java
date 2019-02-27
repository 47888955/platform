package com.yaoyong.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.sys.entity.UserAdmin;

@Mapper
public interface UserAdminMapper extends BaseMapper<UserAdmin> {
	@Select("selectUserAdminPage")
	List<UserAdmin> selectUserAdminPage(Page<UserAdmin> page, @Param("name") String name);

	@Select("selectUserAdminWrapperPage")
	List<UserAdmin> selectUserAdminWrapperPage(Page<UserAdmin> page, @Param("ew") Wrapper<UserAdmin> wrapper);
}
