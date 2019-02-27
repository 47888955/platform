package com.yaoyong.demo.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaoyong.demo.sys.entity.RolePerm;
import com.yaoyong.demo.sys.entity.User;
import com.yaoyong.demo.sys.entity.UserRole;
import com.yaoyong.demo.sys.mapper.RoleMapper;
import com.yaoyong.demo.sys.mapper.RolePermMapper;
import com.yaoyong.demo.sys.mapper.UserMapper;
import com.yaoyong.demo.sys.mapper.UserRoleMapper;
import com.yaoyong.demo.sys.service.IUserService;

/**
 *
 * @ClassName: UserService
 * @Description:
 * @author: yaoyong
 * @date: 2018年12月4日 下午6:34:32
 *
 */

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	RoleMapper roleMapper;

	@Autowired
	UserRoleMapper userRoleMapper;

	@Autowired
	RolePermMapper rolePermMapper;

	@Override
	public Page<User> selectUserPage(Page<User> page, String name) {
		page.setRecords(baseMapper.selectUserPage(page, name));
		return page;
	}

	@Override
	public Page<User> selectUserWrapperPage(Page<User> page, Wrapper<User> wrapper) {
		page.setRecords(baseMapper.selectUserWrapperPage(page, wrapper));
		return page;
	}

	/**
	 *
	 * @Title: getRolesByUserId
	 * @Description: 获取用户的角色集合
	 * @param: @param userId
	 * @param: @return
	 * @return: List<String>
	 * @throws
	 */
	public List<String> getRolesByUserId(String userId) {
		Map<String, Object> userRole = new HashMap<String, Object>();
		userRole.put("user_id", userId);
		List<UserRole> userRoles = userRoleMapper.selectByMap(userRole);
		List<String> listRole = new ArrayList<String>();
		for (UserRole urRole : userRoles) {
			listRole.add(urRole.getRoleId().toString());
		}
		return listRole;
	}

	/**
	 *
	 * @Title: getPermissionByUserId
	 * @Description: 获得用户的所有权限集合
	 * @param: @param userId
	 * @param: @return
	 * @return: List<String>
	 * @throws
	 */
	public List<String> getPermissionByUserId(String userId) {
		List<String> listRole = getRolesByUserId(userId);
		List<String> permissionList = new ArrayList<String>();
		for (String roleId : listRole) {
			Map<String, Object> roleMap = new HashMap<String, Object>();
			roleMap.put("role_id", roleId);
			List<RolePerm> listRolePerm = rolePermMapper.selectByMap(roleMap);
			for (RolePerm rolePerm : listRolePerm) {
				// 注入权限
				permissionList.add(rolePerm.getPermCode());
			}
		}
		return permissionList;
	}

}