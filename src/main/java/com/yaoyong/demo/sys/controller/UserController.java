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
import com.yaoyong.demo.sys.entity.User;
import com.yaoyong.demo.sys.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
*
* @ClassName: UserController
* @Description: 密码加密 Encryption.md5("123456","yaoyong"))
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Api(tags = "User类", value = "User管理")
@RestController
@RequestMapping(value = "v1/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;


	@ApiOperation(value = "创建实体", notes = "创建User实体")
	@PostMapping(value = "")
	public RestModel<?> userSave(@Valid @RequestBody User user, BindingResult result) {
		Boolean issave = userService.save(user);
		if (issave) {
			return RestModel.status(HttpEnumStatus.INSERT_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.INSERT_FAILURE);
		}
	}

	@ApiOperation(value = "更新实体", notes = "更新User实体")
	@PutMapping(value = "")
	public RestModel<?> userUpdate(@RequestBody User user) {
		Boolean isupdate = userService.updateById(user);
		if (isupdate) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看User实体")
	@GetMapping(value = "")
	public RestModel<?> userView(@RequestParam Long id) {
		User user = userService.getById(id);
		if (null ==  user) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		}else{
			return RestModel.data( user);
		}
	}

	@ApiOperation(value = "删除实体", notes = "删除User实体")
	@DeleteMapping(value = "{id}")
	public RestModel<?> userDelete(@PathVariable(value = "id") Long id) {
		Boolean isdelete = userService.removeById(id);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.DELETE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.DELETE_FAILURE);
		}
	}

	@ApiOperation(value = "实体列表", notes = "User实体列表")
	@GetMapping(value = "pagelist")
	public RestModel<?> userList(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, User user) {
		Page<User> page = new Page<User>(pageNum, pageSize);
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		//queryWrapper.eq("name", user.getName());
		userService.page(page, queryWrapper);
		return RestModel.data(page);
	}

	@ApiOperation(value = "是否启用", notes = "是否启用is_enable")
	@PutMapping(value = "enable")
	public RestModel<?> isEnable(@RequestParam Long id, @RequestParam int status) {
		if (status > 0) {
			status = 1;
		}
		User user = new User();
		//user.setId(id);
		//user.setIsEnable(status);
		Boolean isdelete = userService.updateById(user);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "自定义实体分页列表", notes = "自定义实体User实体分页列表")
	@GetMapping(value = "selectUserPage")
	public RestModel<?> selectUserPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam String name) {
		Page<User> page = new Page<User>(pageNum, pageSize);
		userService.selectUserPage(page, name);
		return RestModel.data(page);
	}

	@ApiOperation(value = "自定义条件分页列表", notes = "自定义条件User实体分页列表")
	@GetMapping(value = "selectUserWrapperPage")
	public RestModel<?> selectUserWrapperPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, User user) {
		Page<User> page = new Page<User>(pageNum, pageSize);
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		queryWrapper.eq("name", "yaoyong");
		userService.selectUserWrapperPage(page, queryWrapper);
		return RestModel.data(page);
	}


        }
