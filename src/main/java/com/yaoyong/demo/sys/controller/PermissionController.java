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
import com.yaoyong.demo.sys.controller.PermissionController;
import com.yaoyong.demo.sys.entity.Permission;
import com.yaoyong.demo.sys.service.IPermissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
*
* @ClassName: PermissionController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Api(tags = "Permission类", value = "Permission管理")
@RestController
@RequestMapping(value = "v1/permission")
public class PermissionController {

	private static final Logger log = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    IPermissionService permissionService;


	@ApiOperation(value = "创建实体", notes = "创建Permission实体")
	@PostMapping(value = "")
	public RestModel<?> permissionSave(@Valid @RequestBody Permission permission, BindingResult result) {
		Boolean issave = permissionService.save(permission);
		if (issave) {
			return RestModel.status(HttpEnumStatus.INSERT_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.INSERT_FAILURE);
		}
	}

	@ApiOperation(value = "更新实体", notes = "更新Permission实体")
	@PutMapping(value = "")
	public RestModel<?> permissionUpdate(@RequestBody Permission permission) {
		Boolean isupdate = permissionService.updateById(permission);
		if (isupdate) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看Permission实体")
	@GetMapping(value = "")
	public RestModel<?> permissionView(@RequestParam Long id) {
		Permission permission = permissionService.getById(id);
		if (null ==  permission) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		}else{
			return RestModel.data( permission);
		}
	}

	@ApiOperation(value = "删除实体", notes = "删除Permission实体")
	@DeleteMapping(value = "{id}")
	public RestModel<?> permissionDelete(@PathVariable(value = "id") Long id) {
		Boolean isdelete = permissionService.removeById(id);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.DELETE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.DELETE_FAILURE);
		}
	}

	@ApiOperation(value = "实体列表", notes = "Permission实体列表")
	@GetMapping(value = "pagelist")
	public RestModel<?> permissionList(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, Permission permission) {
		Page<Permission> page = new Page<Permission>(pageNum, pageSize);
		QueryWrapper<Permission> queryWrapper = new QueryWrapper<Permission>();
		//queryWrapper.eq("name", permission.getName());
		permissionService.page(page, queryWrapper);
		return RestModel.data(page);
	}

	@ApiOperation(value = "是否启用", notes = "是否启用is_enable")
	@PutMapping(value = "enable")
	public RestModel<?> isEnable(@RequestParam Long id, @RequestParam int status) {
		if (status > 0) {
			status = 1;
		}
		Permission permission = new Permission();
		//permission.setId(id);
		//permission.setIsEnable(status);
		Boolean isdelete = permissionService.updateById(permission);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "自定义实体分页列表", notes = "自定义实体Permission实体分页列表")
	@GetMapping(value = "selectPermissionPage")
	public RestModel<?> selectPermissionPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam String name) {
		Page<Permission> page = new Page<Permission>(pageNum, pageSize);
		permissionService.selectPermissionPage(page, name);
		return RestModel.data(page);
	}

	@ApiOperation(value = "自定义条件分页列表", notes = "自定义条件Permission实体分页列表")
	@GetMapping(value = "selectPermissionWrapperPage")
	public RestModel<?> selectPermissionWrapperPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, Permission permission) {
		Page<Permission> page = new Page<Permission>(pageNum, pageSize);
		QueryWrapper<Permission> queryWrapper = new QueryWrapper<Permission>();
		queryWrapper.eq("name", "yaoyong");
		permissionService.selectPermissionWrapperPage(page, queryWrapper);
		return RestModel.data(page);
	}

    
        }
