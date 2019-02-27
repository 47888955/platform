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
import com.yaoyong.demo.sys.controller.LogOperateController;
import com.yaoyong.demo.sys.entity.LogOperate;
import com.yaoyong.demo.sys.service.ILogOperateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
*
* @ClassName: LogOperateController
* @Description:
* @author: yaoyong
* @date: 2018年12月4日 下午6:34:32
*
*/

@Api(tags = "LogOperate类", value = "LogOperate管理")
@RestController
@RequestMapping(value = "v1/logOperate")
public class LogOperateController {

	private static final Logger log = LoggerFactory.getLogger(LogOperateController.class);

    @Autowired
    ILogOperateService logOperateService;


	@ApiOperation(value = "创建实体", notes = "创建LogOperate实体")
	@PostMapping(value = "")
	public RestModel<?> logOperateSave(@Valid @RequestBody LogOperate logOperate, BindingResult result) {
		Boolean issave = logOperateService.save(logOperate);
		if (issave) {
			return RestModel.status(HttpEnumStatus.INSERT_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.INSERT_FAILURE);
		}
	}

	@ApiOperation(value = "更新实体", notes = "更新LogOperate实体")
	@PutMapping(value = "")
	public RestModel<?> logOperateUpdate(@RequestBody LogOperate logOperate) {
		Boolean isupdate = logOperateService.updateById(logOperate);
		if (isupdate) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看LogOperate实体")
	@GetMapping(value = "")
	public RestModel<?> logOperateView(@RequestParam Long id) {
		LogOperate logOperate = logOperateService.getById(id);
		if (null ==  logOperate) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		}else{
			return RestModel.data( logOperate);
		}
	}

	@ApiOperation(value = "删除实体", notes = "删除LogOperate实体")
	@DeleteMapping(value = "{id}")
	public RestModel<?> logOperateDelete(@PathVariable(value = "id") Long id) {
		Boolean isdelete = logOperateService.removeById(id);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.DELETE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.DELETE_FAILURE);
		}
	}

	@ApiOperation(value = "实体列表", notes = "LogOperate实体列表")
	@GetMapping(value = "pagelist")
	public RestModel<?> logOperateList(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, LogOperate logOperate) {
		Page<LogOperate> page = new Page<LogOperate>(pageNum, pageSize);
		QueryWrapper<LogOperate> queryWrapper = new QueryWrapper<LogOperate>();
		//queryWrapper.eq("name", logOperate.getName());
		logOperateService.page(page, queryWrapper);
		return RestModel.data(page);
	}

	@ApiOperation(value = "是否启用", notes = "是否启用is_enable")
	@PutMapping(value = "enable")
	public RestModel<?> isEnable(@RequestParam Long id, @RequestParam int status) {
		if (status > 0) {
			status = 1;
		}
		LogOperate logOperate = new LogOperate();
		//logOperate.setId(id);
		//logOperate.setIsEnable(status);
		Boolean isdelete = logOperateService.updateById(logOperate);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "自定义实体分页列表", notes = "自定义实体LogOperate实体分页列表")
	@GetMapping(value = "selectLogOperatePage")
	public RestModel<?> selectLogOperatePage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam String name) {
		Page<LogOperate> page = new Page<LogOperate>(pageNum, pageSize);
		logOperateService.selectLogOperatePage(page, name);
		return RestModel.data(page);
	}

	@ApiOperation(value = "自定义条件分页列表", notes = "自定义条件LogOperate实体分页列表")
	@GetMapping(value = "selectLogOperateWrapperPage")
	public RestModel<?> selectLogOperateWrapperPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, LogOperate logOperate) {
		Page<LogOperate> page = new Page<LogOperate>(pageNum, pageSize);
		QueryWrapper<LogOperate> queryWrapper = new QueryWrapper<LogOperate>();
		queryWrapper.eq("name", "yaoyong");
		logOperateService.selectLogOperateWrapperPage(page, queryWrapper);
		return RestModel.data(page);
	}

    
        }
