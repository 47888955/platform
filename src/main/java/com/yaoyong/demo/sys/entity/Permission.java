package com.yaoyong.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yaoyong.demo.sys.entity.Permission;

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
@TableName("permission")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "Permission")
public class Permission  {
	
	 	@ApiModelProperty("物理ID")
		@TableId(value = "id", type = IdType.AUTO)
		private Long id;
		
	 @ApiModelProperty("双亲ID")
	 	private Long pid;

	 @ApiModelProperty("平台类型（0后台 1前台）")
	 	private Integer platType;

	 @ApiModelProperty("所在层级")
	 	private Integer layer;

	 @ApiModelProperty("是否叶子(0权限目录 1权限点)")
	 	private Integer isLeaf;

	 @ApiModelProperty("权限名")
	 	private String name;

	 @ApiModelProperty("权限号、功能唯一性")
	 	private String permCode;

	 @ApiModelProperty("权限URL")
	 	private String permUrl;

	 @ApiModelProperty("请求方法Get Post   Put   Head  Delete  (大写)")
	 	private String httpMethod;

	 @ApiModelProperty("权限描述")
	 	private String content;

	 @ApiModelProperty("是否启动")
	 	private Integer isEnable;

	 @ApiModelProperty("是否删除")
	 	private Integer isDelete;

	 @ApiModelProperty("乐观锁版本")
	 	private Long version;

	 @ApiModelProperty("商户ID")
	 	private String appid;

	 @ApiModelProperty("创建时间")
	 	private Long createTime;

	 @ApiModelProperty("更新时间")
	 	private Long updateTime;

	
}

