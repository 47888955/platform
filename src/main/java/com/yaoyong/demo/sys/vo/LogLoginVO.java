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


@ApiModel(description = "LogLogin")
public class LogLoginVO implements Serializable {
	
	 @ApiModelProperty("物理ID")
	 @Max(9223372036854775807L)
	private Long id;
	
	 @ApiModelProperty("平台类型（0后台 1前台）")
	 @Max(9999999999L)
	private Integer platType;
	
	 @ApiModelProperty("operateId")
	 @Length(max=45)
	private String operateId;
	
	 @ApiModelProperty("operateName")
	 @Length(max=45)
	private String operateName;
	
	 @ApiModelProperty("IP地址")
	 @Length(max=64)
	private String userIp;
	
	 @ApiModelProperty("创建时间")
	 @Max(9223372036854775807L)
	private Long createTime;
	
	 @ApiModelProperty("商户ID")
	 @Length(max=32)
	private String appid;
	

	public void setId(Long value) {
		this.id = value ;
	}
	public Long getId() {
		return id;
	}

	public void setPlatType(Integer value) {
		this.platType = value ;
	}
	public Integer getPlatType() {
		return platType;
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

	public void setAppid(String value) {
		this.appid = value ;
	}
	public String getAppid() {
		return appid;
	}
	@Override
    public String toString() {  
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)  
            .append("Id",getId())  
            .append("PlatType",getPlatType())  
            .append("OperateId",getOperateId())  
            .append("OperateName",getOperateName())  
            .append("UserIp",getUserIp())  
            .append("CreateTime",getCreateTime())  
            .append("Appid",getAppid())  
            .toString();  
    }  
	@Override
    public int hashCode() {  
        return new HashCodeBuilder()  
            .append(getId())  
            .toHashCode();  
    }  
	@Override
    public boolean equals(Object obj) {  
        if(obj instanceof LogLoginVO == false) {return false; }
        if(this == obj) { return true; }
        LogLoginVO other = (LogLoginVO)obj;
        return new EqualsBuilder()  
            .append(getId(),other.getId())  
            .isEquals();  
    }  

    
}

