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
import com.yaoyong.demo.sys.controller.LogLoginController;
import com.yaoyong.demo.sys.entity.LogLogin;
import com.yaoyong.demo.sys.service.ILogLoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
*
* @ClassName: LogLoginController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Api(tags = "LogLogin类", value = "LogLogin管理")
@RestController
@RequestMapping(value = "v1/logLogin")
public class LogLoginController {

	private static final Logger log = LoggerFactory.getLogger(LogLoginController.class);

    @Autowired
    ILogLoginService logLoginService;


	@ApiOperation(value = "创建实体", notes = "创建LogLogin实体")
	@PostMapping(value = "")
	public RestModel<?> logLoginSave(@Valid @RequestBody LogLogin logLogin, BindingResult result) {
		Boolean issave = logLoginService.save(logLogin);
		if (issave) {
			return RestModel.status(HttpEnumStatus.INSERT_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.INSERT_FAILURE);
		}
	}

	@ApiOperation(value = "更新实体", notes = "更新LogLogin实体")
	@PutMapping(value = "")
	public RestModel<?> logLoginUpdate(@RequestBody LogLogin logLogin) {
		Boolean isupdate = logLoginService.updateById(logLogin);
		if (isupdate) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看LogLogin实体")
	@GetMapping(value = "")
	public RestModel<?> logLoginView(@RequestParam Long id) {
		LogLogin logLogin = logLoginService.getById(id);
		if (null ==  logLogin) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		}else{
			return RestModel.data( logLogin);
		}
	}

	@ApiOperation(value = "删除实体", notes = "删除LogLogin实体")
	@DeleteMapping(value = "{id}")
	public RestModel<?> logLoginDelete(@PathVariable(value = "id") Long id) {
		Boolean isdelete = logLoginService.removeById(id);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.DELETE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.DELETE_FAILURE);
		}
	}

	@ApiOperation(value = "实体列表", notes = "LogLogin实体列表")
	@GetMapping(value = "pagelist")
	public RestModel<?> logLoginList(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, LogLogin logLogin) {
		Page<LogLogin> page = new Page<LogLogin>(pageNum, pageSize);
		QueryWrapper<LogLogin> queryWrapper = new QueryWrapper<LogLogin>();
		//queryWrapper.eq("name", logLogin.getName());
		logLoginService.page(page, queryWrapper);
		return RestModel.data(page);
	}

	@ApiOperation(value = "是否启用", notes = "是否启用is_enable")
	@PutMapping(value = "enable")
	public RestModel<?> isEnable(@RequestParam Long id, @RequestParam int status) {
		if (status > 0) {
			status = 1;
		}
		LogLogin logLogin = new LogLogin();
		//logLogin.setId(id);
		//logLogin.setIsEnable(status);
		Boolean isdelete = logLoginService.updateById(logLogin);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "自定义实体分页列表", notes = "自定义实体LogLogin实体分页列表")
	@GetMapping(value = "selectLogLoginPage")
	public RestModel<?> selectLogLoginPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam String name) {
		Page<LogLogin> page = new Page<LogLogin>(pageNum, pageSize);
		logLoginService.selectLogLoginPage(page, name);
		return RestModel.data(page);
	}

	@ApiOperation(value = "自定义条件分页列表", notes = "自定义条件LogLogin实体分页列表")
	@GetMapping(value = "selectLogLoginWrapperPage")
	public RestModel<?> selectLogLoginWrapperPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, LogLogin logLogin) {
		Page<LogLogin> page = new Page<LogLogin>(pageNum, pageSize);
		QueryWrapper<LogLogin> queryWrapper = new QueryWrapper<LogLogin>();
		queryWrapper.eq("name", "yaoyong");
		logLoginService.selectLogLoginWrapperPage(page, queryWrapper);
		return RestModel.data(page);
	}

    
        }
