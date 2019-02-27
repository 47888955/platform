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
import com.yaoyong.demo.sys.controller.RoleController;
import com.yaoyong.demo.sys.entity.Role;
import com.yaoyong.demo.sys.service.IRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
*
* @ClassName: RoleController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Api(tags = "Role类", value = "Role管理")
@RestController
@RequestMapping(value = "v1/role")
public class RoleController {

	private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    IRoleService roleService;


	@ApiOperation(value = "创建实体", notes = "创建Role实体")
	@PostMapping(value = "")
	public RestModel<?> roleSave(@Valid @RequestBody Role role, BindingResult result) {
		Boolean issave = roleService.save(role);
		if (issave) {
			return RestModel.status(HttpEnumStatus.INSERT_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.INSERT_FAILURE);
		}
	}

	@ApiOperation(value = "更新实体", notes = "更新Role实体")
	@PutMapping(value = "")
	public RestModel<?> roleUpdate(@RequestBody Role role) {
		Boolean isupdate = roleService.updateById(role);
		if (isupdate) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看Role实体")
	@GetMapping(value = "")
	public RestModel<?> roleView(@RequestParam Long id) {
		Role role = roleService.getById(id);
		if (null ==  role) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		}else{
			return RestModel.data( role);
		}
	}

	@ApiOperation(value = "删除实体", notes = "删除Role实体")
	@DeleteMapping(value = "{id}")
	public RestModel<?> roleDelete(@PathVariable(value = "id") Long id) {
		Boolean isdelete = roleService.removeById(id);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.DELETE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.DELETE_FAILURE);
		}
	}

	@ApiOperation(value = "实体列表", notes = "Role实体列表")
	@GetMapping(value = "pagelist")
	public RestModel<?> roleList(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, Role role) {
		Page<Role> page = new Page<Role>(pageNum, pageSize);
		QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>();
		//queryWrapper.eq("name", role.getName());
		roleService.page(page, queryWrapper);
		return RestModel.data(page);
	}

	@ApiOperation(value = "是否启用", notes = "是否启用is_enable")
	@PutMapping(value = "enable")
	public RestModel<?> isEnable(@RequestParam Long id, @RequestParam int status) {
		if (status > 0) {
			status = 1;
		}
		Role role = new Role();
		//role.setId(id);
		//role.setIsEnable(status);
		Boolean isdelete = roleService.updateById(role);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "自定义实体分页列表", notes = "自定义实体Role实体分页列表")
	@GetMapping(value = "selectRolePage")
	public RestModel<?> selectRolePage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam String name) {
		Page<Role> page = new Page<Role>(pageNum, pageSize);
		roleService.selectRolePage(page, name);
		return RestModel.data(page);
	}

	@ApiOperation(value = "自定义条件分页列表", notes = "自定义条件Role实体分页列表")
	@GetMapping(value = "selectRoleWrapperPage")
	public RestModel<?> selectRoleWrapperPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, Role role) {
		Page<Role> page = new Page<Role>(pageNum, pageSize);
		QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>();
		queryWrapper.eq("name", "yaoyong");
		roleService.selectRoleWrapperPage(page, queryWrapper);
		return RestModel.data(page);
	}

    
        }
