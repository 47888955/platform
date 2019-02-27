package com.yaoyong.demo.sys.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaoyong.demo.base.constant.HttpEnumStatus;
import com.yaoyong.demo.base.model.RestModel;
import com.yaoyong.demo.sys.controller.UserRoleController;
import com.yaoyong.demo.sys.entity.UserRole;
import com.yaoyong.demo.sys.service.IUserRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
*
* @ClassName: UserRoleController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Api(tags = "UserRole类", value = "UserRole管理")
@RestController
@RequestMapping(value = "v1/userRole")
public class UserRoleController {

	private static final Logger log = LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    IUserRoleService userRoleService;


	@ApiOperation(value = "创建实体", notes = "创建UserRole实体")
	@PostMapping(value = "")
	public RestModel<?> userRoleSave(@Valid @RequestBody UserRole userRole, BindingResult result) {
		Boolean issave = userRoleService.save(userRole);
		if (issave) {
			return RestModel.status(HttpEnumStatus.INSERT_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.INSERT_FAILURE);
		}
	}

	@ApiOperation(value = "更新实体", notes = "更新UserRole实体")
	@PutMapping(value = "")
	public RestModel<?> userRoleUpdate(@RequestBody UserRole userRole) {
		Boolean isupdate = userRoleService.updateById(userRole);
		if (isupdate) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看UserRole实体")
	@GetMapping(value = "")
	public RestModel<?> userRoleView(@RequestParam Long id) {
		UserRole userRole = userRoleService.getById(id);
		if (null ==  userRole) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		}else{
			return RestModel.data( userRole);
		}
	}

	@ApiOperation(value = "删除实体", notes = "删除UserRole实体")
	@DeleteMapping(value = "{id}")
	public RestModel<?> userRoleDelete(@PathVariable(value = "id") Long id) {
		Boolean isdelete = userRoleService.removeById(id);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.DELETE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.DELETE_FAILURE);
		}
	}

	@ApiOperation(value = "实体列表", notes = "UserRole实体列表")
	@GetMapping(value = "pagelist")
	public RestModel<?> userRoleList(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, UserRole userRole) {
		Page<UserRole> page = new Page<UserRole>(pageNum, pageSize);
		QueryWrapper<UserRole> queryWrapper = new QueryWrapper<UserRole>();
		//queryWrapper.eq("name", userRole.getName());
		userRoleService.page(page, queryWrapper);
		return RestModel.data(page);
	}

	@ApiOperation(value = "是否启用", notes = "是否启用is_enable")
	@PutMapping(value = "enable")
	public RestModel<?> isEnable(@RequestParam Long id, @RequestParam int status) {
		if (status > 0) {
			status = 1;
		}
		UserRole userRole = new UserRole();
		//userRole.setId(id);
		//userRole.setIsEnable(status);
		Boolean isdelete = userRoleService.updateById(userRole);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "自定义实体分页列表", notes = "自定义实体UserRole实体分页列表")
	@GetMapping(value = "selectUserRolePage")
	public RestModel<?> selectUserRolePage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam String name) {
		Page<UserRole> page = new Page<UserRole>(pageNum, pageSize);
		userRoleService.selectUserRolePage(page, name);
		return RestModel.data(page);
	}

	@ApiOperation(value = "自定义条件分页列表", notes = "自定义条件UserRole实体分页列表")
	@GetMapping(value = "selectUserRoleWrapperPage")
	public RestModel<?> selectUserRoleWrapperPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, UserRole userRole) {
		Page<UserRole> page = new Page<UserRole>(pageNum, pageSize);
		QueryWrapper<UserRole> queryWrapper = new QueryWrapper<UserRole>();
		queryWrapper.eq("name", "yaoyong");
		userRoleService.selectUserRoleWrapperPage(page, queryWrapper);
		return RestModel.data(page);
	}

    
        }
