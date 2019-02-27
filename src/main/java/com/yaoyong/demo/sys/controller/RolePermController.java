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
import com.yaoyong.demo.sys.controller.RolePermController;
import com.yaoyong.demo.sys.entity.RolePerm;
import com.yaoyong.demo.sys.service.IRolePermService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
*
* @ClassName: RolePermController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Api(tags = "RolePerm类", value = "RolePerm管理")
@RestController
@RequestMapping(value = "v1/rolePerm")
public class RolePermController {

	private static final Logger log = LoggerFactory.getLogger(RolePermController.class);

    @Autowired
    IRolePermService rolePermService;


	@ApiOperation(value = "创建实体", notes = "创建RolePerm实体")
	@PostMapping(value = "")
	public RestModel<?> rolePermSave(@Valid @RequestBody RolePerm rolePerm, BindingResult result) {
		Boolean issave = rolePermService.save(rolePerm);
		if (issave) {
			return RestModel.status(HttpEnumStatus.INSERT_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.INSERT_FAILURE);
		}
	}

	@ApiOperation(value = "更新实体", notes = "更新RolePerm实体")
	@PutMapping(value = "")
	public RestModel<?> rolePermUpdate(@RequestBody RolePerm rolePerm) {
		Boolean isupdate = rolePermService.updateById(rolePerm);
		if (isupdate) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看RolePerm实体")
	@GetMapping(value = "")
	public RestModel<?> rolePermView(@RequestParam Long id) {
		RolePerm rolePerm = rolePermService.getById(id);
		if (null ==  rolePerm) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		}else{
			return RestModel.data( rolePerm);
		}
	}

	@ApiOperation(value = "删除实体", notes = "删除RolePerm实体")
	@DeleteMapping(value = "{id}")
	public RestModel<?> rolePermDelete(@PathVariable(value = "id") Long id) {
		Boolean isdelete = rolePermService.removeById(id);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.DELETE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.DELETE_FAILURE);
		}
	}

	@ApiOperation(value = "实体列表", notes = "RolePerm实体列表")
	@GetMapping(value = "pagelist")
	public RestModel<?> rolePermList(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, RolePerm rolePerm) {
		Page<RolePerm> page = new Page<RolePerm>(pageNum, pageSize);
		QueryWrapper<RolePerm> queryWrapper = new QueryWrapper<RolePerm>();
		//queryWrapper.eq("name", rolePerm.getName());
		rolePermService.page(page, queryWrapper);
		return RestModel.data(page);
	}

	@ApiOperation(value = "是否启用", notes = "是否启用is_enable")
	@PutMapping(value = "enable")
	public RestModel<?> isEnable(@RequestParam Long id, @RequestParam int status) {
		if (status > 0) {
			status = 1;
		}
		RolePerm rolePerm = new RolePerm();
		//rolePerm.setId(id);
		//rolePerm.setIsEnable(status);
		Boolean isdelete = rolePermService.updateById(rolePerm);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "自定义实体分页列表", notes = "自定义实体RolePerm实体分页列表")
	@GetMapping(value = "selectRolePermPage")
	public RestModel<?> selectRolePermPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam String name) {
		Page<RolePerm> page = new Page<RolePerm>(pageNum, pageSize);
		rolePermService.selectRolePermPage(page, name);
		return RestModel.data(page);
	}

	@ApiOperation(value = "自定义条件分页列表", notes = "自定义条件RolePerm实体分页列表")
	@GetMapping(value = "selectRolePermWrapperPage")
	public RestModel<?> selectRolePermWrapperPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, RolePerm rolePerm) {
		Page<RolePerm> page = new Page<RolePerm>(pageNum, pageSize);
		QueryWrapper<RolePerm> queryWrapper = new QueryWrapper<RolePerm>();
		queryWrapper.eq("name", "yaoyong");
		rolePermService.selectRolePermWrapperPage(page, queryWrapper);
		return RestModel.data(page);
	}

    
        }
