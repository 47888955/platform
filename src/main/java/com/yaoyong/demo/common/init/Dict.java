package com.yaoyong.demo.common.init;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字典VO
 *
 * @ClassName: Dict
 * @Description:
 * @author: yaoyong
 * @date: 2018年12月19日 下午4:31:36
 *
 */
@ApiModel(description = "Dict")
public class Dict implements Comparable<Dict> {

	public Dict() {
	}

	@ApiModelProperty("字典名称")
	private String name;

	@ApiModelProperty("字典CODE")
	private String code;

	@ApiModelProperty("排序")
	private Integer sort;

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int compareTo(Dict o) {
		if (sort < o.sort) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "dict[name=" + name + "code=" + code + "sort=" + sort + "]";
	}

}
