package com.yaoyong.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
*
* @ClassName:  Dictionary
* @Description:
* @author: yaoyong
* @date:   2018年12月5日 下午12:37:17
*
*/

@Data
@TableName("role_perm")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "RolePerm")
public class RolePerm  {

	 	@ApiModelProperty("物理ID")
		@TableId(value = "id", type = IdType.AUTO)
		private Long id;

	 @ApiModelProperty("roleId")
	 	private Long roleId;

	 @ApiModelProperty("permId")
	 	private Long permId;

	 @ApiModelProperty("权限号、功能唯一性")
	 	private String permCode;

	 @ApiModelProperty("权限URL")
	 	private String permUrl;

	 @ApiModelProperty("请求方法Get Post   Put   Head  Delete  (大写)")
	 	private String httpMethod;


}

