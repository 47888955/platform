package com.yaoyong.demo.sys.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *
 * @ClassName: Dictionary
 * @Description:
 * @author: yaoyong
 * @date: 2018年12月5日 下午12:37:17
 *
 */

@Data
@TableName("user")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "User")
public class User {

	@ApiModelProperty("用户物理ID")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty("用户UUID")
	private String userId;

	@ApiModelProperty("角色ID")
	private Long roleId;

	@ApiModelProperty("用户类型")
	private Integer userType;

	@ApiModelProperty("商家ID")
	private String merchantId;

	@ApiModelProperty("用户状态0正常、1冻结")
	private Integer userStatus;

	@ApiModelProperty("loginName")
	private String loginName;

	@ApiModelProperty("登录匿称")
	private String userName;

	@ApiModelProperty("真是姓名")
	private String realName;

	@ApiModelProperty("加密后密码")
	private String password;

	@ApiModelProperty("盐值")
	private String userSalt;

	@ApiModelProperty("电子邮件")
	private String email;

	@ApiModelProperty("联系电话、多个")
	private String mobile;

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

	@ApiModelProperty("角色")
	@TableField(exist = false)
	private List<String> roleList;

	@ApiModelProperty("权限")
	@TableField(exist = false)
	private List<String> permList;

}
