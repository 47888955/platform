package com.yaoyong.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yaoyong.demo.sys.entity.UserAdmin;

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
@TableName("user_admin")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "UserAdmin")
public class UserAdmin  {
	
	 	@ApiModelProperty("物理ID")
		@TableId(value = "id", type = IdType.AUTO)
		private Long id;
		
	 @ApiModelProperty("UUID")
	 	private String userId;

	 @ApiModelProperty("realName")
	 	private String realName;

	 @ApiModelProperty("loginName")
	 	private String loginName;

	 @ApiModelProperty("加密后的密码")
	 	private String password;

	 @ApiModelProperty("联系电话（多个）")
	 	private String mobile;

	 @ApiModelProperty("电子邮箱")
	 	private String email;

	 @ApiModelProperty("审批流程  0 审批  1 审批通过")
	 	private Integer approve;

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

