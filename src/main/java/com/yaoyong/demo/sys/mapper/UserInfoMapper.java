package com.yaoyong.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.sys.entity.UserInfo;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
	@Select("selectUserInfoPage")
	List<UserInfo> selectUserInfoPage(Page<UserInfo> page, @Param("name") String name);

	@Select("selectUserInfoWrapperPage")
	List<UserInfo> selectUserInfoWrapperPage(Page<UserInfo> page, @Param("ew") Wrapper<UserInfo> wrapper);
}
