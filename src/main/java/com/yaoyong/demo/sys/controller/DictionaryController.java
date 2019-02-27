package com.yaoyong.demo.sys.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.yaoyong.demo.common.init.Dict;
import com.yaoyong.demo.common.init.DictionaryUtil;
import com.yaoyong.demo.sys.entity.Dictionary;
import com.yaoyong.demo.sys.service.IDictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @ClassName: DictionaryController
 * @Description:
 * @author: yaoyong
 * @date: 2018年12月4日 下午6:34:32
 *
 */

@Api(tags = "Dictionary类", value = "Dictionary管理")
@RestController
@RequestMapping(value = "v1/dictionary")
public class DictionaryController {

	private static final Logger log = LoggerFactory.getLogger(DictionaryController.class);

	@Autowired
	IDictionaryService dictionaryService;

	@Autowired
	DictionaryUtil dictionaryUtil;

	@ApiOperation(value = "创建实体", notes = "创建Dictionary实体")
	@PostMapping(value = "")
	public RestModel<?> dictionarySave(@Valid @RequestBody Dictionary dictionary, BindingResult result) {
		Boolean issave = dictionaryService.save(dictionary);
		if (issave) {
			return RestModel.status(HttpEnumStatus.INSERT_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.INSERT_FAILURE);
		}
	}

	@ApiOperation(value = "更新实体", notes = "更新Dictionary实体")
	@PutMapping(value = "")
	public RestModel<?> dictionaryUpdate(@RequestBody Dictionary dictionary) {
		Boolean isupdate = dictionaryService.updateById(dictionary);
		if (isupdate) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}
/**
 *
 * @Title: getDictList
 * @Description:表名+字段（小写）
 * @param code
 * @return RestModel<?>
 * @throws
 *
 */
	@ApiOperation(value = "字典KV调用", notes = "字典KV列表")
	@GetMapping(value = "dictList")
	@RequiresPermissions(value = { "dictionary:dictlist" })
	public RestModel<?> getDictList(@RequestParam String code) {

		// dictionaryUtil.getDictName("string1");
		// dictionaryUtil.getDictNames("string1,string2");
		List<Dict> dictList = dictionaryUtil.getDictList(code);
		if (null == dictList) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		} else {
			return RestModel.data(dictList);
		}
	}

	@ApiOperation(value = "查看实体", notes = "查看Dictionary实体")
	@GetMapping(value = "")
	// @RequiresPermissions("dictionary:view")
	@RequiresPermissions(value = { "dictionary:view" })
	public RestModel<?> dictionaryView(@RequestParam Long id) {

		Dictionary dictionary = dictionaryService.getById(id);
		if (null == dictionary) {
			return RestModel.data(HttpEnumStatus.NO_DATA);
		} else {
			return RestModel.data(dictionary);
		}
	}

	@ApiOperation(value = "删除实体", notes = "删除Dictionary实体")
	@DeleteMapping(value = "{id}")
	public RestModel<?> dictionaryDelete(@PathVariable(value = "id") Long id) {
		Boolean isdelete = dictionaryService.removeById(id);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.DELETE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.DELETE_FAILURE);
		}
	}

	@ApiOperation(value = "实体列表", notes = "Dictionary实体列表")
	@GetMapping(value = "pagelist")
	public RestModel<?> dictionaryList(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, Dictionary dictionary) {
		Page<Dictionary> page = new Page<Dictionary>(pageNum, pageSize);
		QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<Dictionary>();
		// queryWrapper.eq("name", dictionary.getName());
		dictionaryService.page(page, queryWrapper);
		return RestModel.data(page);
	}

	@ApiOperation(value = "是否启用", notes = "是否启用is_enable")
	@PutMapping(value = "enable")
	public RestModel<?> isEnable(@RequestParam Long id, @RequestParam int status) {
		if (status > 0) {
			status = 1;
		}
		Dictionary dictionary = new Dictionary();
		// dictionary.setId(id);
		// dictionary.setIsEnable(status);
		Boolean isdelete = dictionaryService.updateById(dictionary);
		if (isdelete) {
			return RestModel.status(HttpEnumStatus.UPDATE_SUCCESS);
		} else {
			return RestModel.status(HttpEnumStatus.UPDATE_FAIURE);
		}
	}

	@ApiOperation(value = "自定义实体分页列表", notes = "自定义实体Dictionary实体分页列表")
	@GetMapping(value = "selectDictionaryPage")
	public RestModel<?> selectDictionaryPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam String name) {
		Page<Dictionary> page = new Page<Dictionary>(pageNum, pageSize);
		dictionaryService.selectDictionaryPage(page, name);
		return RestModel.data(page);
	}

	@ApiOperation(value = "自定义条件分页列表", notes = "自定义条件Dictionary实体分页列表")
	@GetMapping(value = "selectDictionaryWrapperPage")
	public RestModel<?> selectDictionaryWrapperPage(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, Dictionary dictionary) {
		Page<Dictionary> page = new Page<Dictionary>(pageNum, pageSize);
		QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<Dictionary>();
		queryWrapper.eq("name", "yaoyong");
		dictionaryService.selectDictionaryWrapperPage(page, queryWrapper);
		return RestModel.data(page);
	}

}
