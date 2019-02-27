package com.yaoyong.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yaoyong.demo.sys.entity.Role;

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
@TableName("role")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "Role")
public class Role  {
	
	 	@ApiModelProperty("物理ID")
		@TableId(value = "id", type = IdType.AUTO)
		private Long id;
		
	 @ApiModelProperty("平台类型（0后台 1前台）")
	 	private Integer platType;

	 @ApiModelProperty("角色名称")
	 	private String name;

	 @ApiModelProperty("详细描述")
	 	private String content;

	 @ApiModelProperty("是否启动")
	 	private Integer isEnable;

	 @ApiModelProperty("是否删除")
	 	private Integer isDelete;

	 @ApiModelProperty("乐观锁版本")
	 	private Long version;

	 @ApiModelProperty("商户ID")
	 	private String appid;

	
}

