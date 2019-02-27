package com.yaoyong.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yaoyong.demo.sys.entity.UserInfo;

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
@TableName("user_info")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "UserInfo")
public class UserInfo  {
	
	 	@ApiModelProperty("userId")
		@TableId(value = "user_id", type = IdType.AUTO)
		private Long userId;
		
	 @ApiModelProperty("个人名称")
	 	private String userName;

	 @ApiModelProperty("createTime")
	 	private Long createTime;

	 @ApiModelProperty("updateTime")
	 	private Long updateTime;

	 @ApiModelProperty("是否删除0-未删除，1-已删除")
	 	private Integer isDelete;

	
}

