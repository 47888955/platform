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
import com.yaoyong.demo.sys.entity.UserInfo;
import com.yaoyong.demo.sys.service.IUserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
*
* @ClassName: UserInfoController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Api(tags = "UserInfo类", value = "UserInfo管理")
@RestController
@RequestMapping(value = "v1/userInfo")
public class UserInfoController {

	private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    IUserInfoService userInfoService;


	@ApiOperation(value = "创建实体", notes = "创建UserInfo实体")
	@PostMapping(value = "")
	public RestModel<?> userInfoSave(@Valid @RequestBody UserInfo userInfo, BindingResult result) {
		Boolean issave = userInfoService.save(userInfo);
		if (issave) {
			return RestModel.status(HttpEnumStatus.INSERT_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.INSERT_FAILURE);
		}
	}

	@ApiOperation(value = "更新实体", notes = "更新UserInfo实体")
	@PutMapping(value = "")
	public RestModel<?> userInfoUpdate(@RequestBody UserInfo userInfo) {
		Boolean isupdate = userInfoService.updateById(userInfo);
		if (isupdate) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看UserInfo实体")
	@GetMapping(value = "")
	public RestModel<?> userInfoView(@RequestParam Long id) {
		UserInfo userInfo = userInfoService.getById(id);
		if (null ==  userInfo) {
			return RestModel.status(HttpEnumStatus.NO_DATA);
		}else{
			return RestModel.data( userInfo);
		}
	}

	@ApiOperation(value = "删除实体", notes = "删除UserInfo实体")
	@DeleteMapping(value = "{id}")
	public RestModel<?> userInfoDelete(@PathVariable(value = "id") Long id) {
		Boolean isdelete = userInfoService.removeById(id);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.DELETE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.DELETE_FAILURE);
		}
	}

	@ApiOperation(value = "实体列表", notes = "UserInfo实体列表")
	@GetMapping(value = "pagelist")
	public RestModel<?> userInfoList(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, UserInfo userInfo) {
		Page<UserInfo> page = new Page<UserInfo>(pageNum, pageSize);
		QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>();
		//queryWrapper.eq("name", userInfo.getName());
		userInfoService.page(page, queryWrapper);
		return RestModel.data(page);
	}

	@ApiOperation(value = "是否启用", notes = "是否启用is_enable")
	@PutMapping(value = "enable")
	public RestModel<?> isEnable(@RequestParam Long id, @RequestParam int status) {
		if (status > 0) {
			status = 1;
		}
		UserInfo userInfo = new UserInfo();
		//userInfo.setId(id);
		//userInfo.setIsEnable(status);
		Boolean isdelete = userInfoService.updateById(userInfo);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "自定义实体分页列表", notes = "自定义实体UserInfo实体分页列表")
	@GetMapping(value = "selectUserInfoPage")
	public RestModel<?> selectUserInfoPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam String name) {
		Page<UserInfo> page = new Page<UserInfo>(pageNum, pageSize);
		userInfoService.selectUserInfoPage(page, name);
		return RestModel.data(page);
	}

	@ApiOperation(value = "自定义条件分页列表", notes = "自定义条件UserInfo实体分页列表")
	@GetMapping(value = "selectUserInfoWrapperPage")
	public RestModel<?> selectUserInfoWrapperPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, UserInfo userInfo) {
		Page<UserInfo> page = new Page<UserInfo>(pageNum, pageSize);
		QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>();
		queryWrapper.eq("name", "yaoyong");
		userInfoService.selectUserInfoWrapperPage(page, queryWrapper);
		return RestModel.data(page);
	}


        }
