package com.yaoyong.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yaoyong.demo.sys.entity.LogOperate;

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
@TableName("log_operate")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "LogOperate")
public class LogOperate  {
	
	 	@ApiModelProperty("日志标识")
		@TableId(value = "log_id", type = IdType.AUTO)
		private Long logId;
		
	 @ApiModelProperty("商户ID")
	 	private String appid;

	 @ApiModelProperty("operateId")
	 	private String operateId;

	 @ApiModelProperty("operateName")
	 	private String operateName;

	 @ApiModelProperty("平台类型（0后台 1前台）")
	 	private Integer platType;

	 @ApiModelProperty("URL地址")
	 	private String httpUrl;

	 @ApiModelProperty("操作内容 head+ body")
	 	private String httpBody;

	 @ApiModelProperty("IP地址")
	 	private String userIp;

	 @ApiModelProperty("创建时间")
	 	private Long createTime;

	
}

