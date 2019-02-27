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
import com.yaoyong.demo.sys.controller.UserAdminController;
import com.yaoyong.demo.sys.entity.UserAdmin;
import com.yaoyong.demo.sys.service.IUserAdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
*
* @ClassName: UserAdminController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Api(tags = "UserAdmin类", value = "UserAdmin管理")
@RestController
@RequestMapping(value = "v1/userAdmin")
public class UserAdminController {

	private static final Logger log = LoggerFactory.getLogger(UserAdminController.class);

    @Autowired
    IUserAdminService userAdminService;


	@ApiOperation(value = "创建实体", notes = "创建UserAdmin实体")
	@PostMapping(value = "")
	public RestModel<?> userAdminSave(@Valid @RequestBody UserAdmin userAdmin, BindingResult result) {
		Boolean issave = userAdminService.save(userAdmin);
		if (issave) {
			return RestModel.status(HttpEnumStatus.INSERT_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.INSERT_FAILURE);
		}
	}

	@ApiOperation(value = "更新实体", notes = "更新UserAdmin实体")
	@PutMapping(value = "")
	public RestModel<?> userAdminUpdate(@RequestBody UserAdmin userAdmin) {
		Boolean isupdate = userAdminService.updateById(userAdmin);
		if (isupdate) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看UserAdmin实体")
	@GetMapping(value = "")
	public RestModel<?> userAdminView(@RequestParam Long id) {
		UserAdmin userAdmin = userAdminService.getById(id);
		if (null ==  userAdmin) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		}else{
			return RestModel.data( userAdmin);
		}
	}

	@ApiOperation(value = "删除实体", notes = "删除UserAdmin实体")
	@DeleteMapping(value = "{id}")
	public RestModel<?> userAdminDelete(@PathVariable(value = "id") Long id) {
		Boolean isdelete = userAdminService.removeById(id);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.DELETE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.DELETE_FAILURE);
		}
	}

	@ApiOperation(value = "实体列表", notes = "UserAdmin实体列表")
	@GetMapping(value = "pagelist")
	public RestModel<?> userAdminList(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, UserAdmin userAdmin) {
		Page<UserAdmin> page = new Page<UserAdmin>(pageNum, pageSize);
		QueryWrapper<UserAdmin> queryWrapper = new QueryWrapper<UserAdmin>();
		//queryWrapper.eq("name", userAdmin.getName());
		userAdminService.page(page, queryWrapper);
		return RestModel.data(page);
	}

	@ApiOperation(value = "是否启用", notes = "是否启用is_enable")
	@PutMapping(value = "enable")
	public RestModel<?> isEnable(@RequestParam Long id, @RequestParam int status) {
		if (status > 0) {
			status = 1;
		}
		UserAdmin userAdmin = new UserAdmin();
		//userAdmin.setId(id);
		//userAdmin.setIsEnable(status);
		Boolean isdelete = userAdminService.updateById(userAdmin);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "自定义实体分页列表", notes = "自定义实体UserAdmin实体分页列表")
	@GetMapping(value = "selectUserAdminPage")
	public RestModel<?> selectUserAdminPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam String name) {
		Page<UserAdmin> page = new Page<UserAdmin>(pageNum, pageSize);
		userAdminService.selectUserAdminPage(page, name);
		return RestModel.data(page);
	}

	@ApiOperation(value = "自定义条件分页列表", notes = "自定义条件UserAdmin实体分页列表")
	@GetMapping(value = "selectUserAdminWrapperPage")
	public RestModel<?> selectUserAdminWrapperPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, UserAdmin userAdmin) {
		Page<UserAdmin> page = new Page<UserAdmin>(pageNum, pageSize);
		QueryWrapper<UserAdmin> queryWrapper = new QueryWrapper<UserAdmin>();
		queryWrapper.eq("name", "yaoyong");
		userAdminService.selectUserAdminWrapperPage(page, queryWrapper);
		return RestModel.data(page);
	}

    
        }
