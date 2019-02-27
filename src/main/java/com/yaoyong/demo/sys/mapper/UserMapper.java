package com.yaoyong.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.sys.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
	@Select("selectUserPage")
	List<User> selectUserPage(Page<User> page, @Param("name") String name);

	@Select("selectUserWrapperPage")
	List<User> selectUserWrapperPage(Page<User> page, @Param("ew") Wrapper<User> wrapper);
}
