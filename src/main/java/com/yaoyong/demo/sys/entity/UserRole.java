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
 * @ClassName: Dictionary
 * @Description:
 * @author: yaoyong
 * @date: 2018年12月5日 下午12:37:17
 *
 */
@Data
@TableName("user_role")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "UserRole")
public class UserRole {

	@ApiModelProperty("id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty("userId")
	private String userId;

	@ApiModelProperty("roleId")
	private Long roleId;

}
