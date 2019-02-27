package com.yaoyong.demo.sys.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;


@ApiModel(description = "LogOperate")
public class LogOperateVO implements Serializable {
	
	 @ApiModelProperty("日志标识")
	 @Max(9223372036854775807L)
	private Long logId;
	
	 @ApiModelProperty("商户ID")
	 @Length(max=32)
	private String appid;
	
	 @ApiModelProperty("operateId")
	 @Length(max=45)
	private String operateId;
	
	 @ApiModelProperty("operateName")
	 @Length(max=45)
	private String operateName;
	
	 @ApiModelProperty("平台类型（0后台 1前台）")
	 @Max(9999999999L)
	private Integer platType;
	
	 @ApiModelProperty("URL地址")
	 @Length(max=256)
	private String httpUrl;
	
	 @ApiModelProperty("操作内容 head+ body")
	 @Length(max=45)
	private String httpBody;
	
	 @ApiModelProperty("IP地址")
	 @Length(max=64)
	private String userIp;
	
	 @ApiModelProperty("创建时间")
	 @Max(9223372036854775807L)
	private Long createTime;
	

	public void setLogId(Long value) {
		this.logId = value ;
	}
	public Long getLogId() {
		return logId;
	}

	public void setAppid(String value) {
		this.appid = value ;
	}
	public String getAppid() {
		return appid;
	}

	public void setOperateId(String value) {
		this.operateId = value ;
	}
	public String getOperateId() {
		return operateId;
	}

	public void setOperateName(String value) {
		this.operateName = value ;
	}
	public String getOperateName() {
		return operateName;
	}

	public void setPlatType(Integer value) {
		this.platType = value ;
	}
	public Integer getPlatType() {
		return platType;
	}

	public void setHttpUrl(String value) {
		this.httpUrl = value ;
	}
	public String getHttpUrl() {
		return httpUrl;
	}

	public void setHttpBody(String value) {
		this.httpBody = value ;
	}
	public String getHttpBody() {
		return httpBody;
	}

	public void setUserIp(String value) {
		this.userIp = value ;
	}
	public String getUserIp() {
		return userIp;
	}

	public void setCreateTime(Long value) {
		this.createTime = value ;
	}
	public Long getCreateTime() {
		return createTime;
	}
	@Override
    public String toString() {  
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)  
            .append("LogId",getLogId())  
            .append("Appid",getAppid())  
            .append("OperateId",getOperateId())  
            .append("OperateName",getOperateName())  
            .append("PlatType",getPlatType())  
            .append("HttpUrl",getHttpUrl())  
            .append("HttpBody",getHttpBody())  
            .append("UserIp",getUserIp())  
            .append("CreateTime",getCreateTime())  
            .toString();  
    }  
	@Override
    public int hashCode() {  
        return new HashCodeBuilder()  
            .append(getLogId())  
            .toHashCode();  
    }  
	@Override
    public boolean equals(Object obj) {  
        if(obj instanceof LogOperateVO == false) {return false; }
        if(this == obj) { return true; }
        LogOperateVO other = (LogOperateVO)obj;
        return new EqualsBuilder()  
            .append(getLogId(),other.getLogId())  
            .isEquals();  
    }  

    
}

