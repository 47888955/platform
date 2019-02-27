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


@ApiModel(description = "UserInfo")
public class UserInfoVO implements Serializable {
	
	 @ApiModelProperty("userId")
	 @Max(9223372036854775807L)
	private Long userId;
	
	 @ApiModelProperty("个人名称")
	 @NotBlank @Length(max=100)
	private String userName;
	
	 @ApiModelProperty("createTime")
	 @NotNull @Max(9223372036854775807L)
	private Long createTime;
	
	 @ApiModelProperty("updateTime")
	 @NotNull @Max(9223372036854775807L)
	private Long updateTime;
	
	 @ApiModelProperty("是否删除0-未删除，1-已删除")
	 @NotNull 
	private Integer isDelete;
	

	public void setUserId(Long value) {
		this.userId = value ;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserName(String value) {
		this.userName = value ;
	}
	public String getUserName() {
		return userName;
	}

	public void setCreateTime(Long value) {
		this.createTime = value ;
	}
	public Long getCreateTime() {
		return createTime;
	}

	public void setUpdateTime(Long value) {
		this.updateTime = value ;
	}
	public Long getUpdateTime() {
		return updateTime;
	}

	public void setIsDelete(Integer value) {
		this.isDelete = value ;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	@Override
    public String toString() {  
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)  
            .append("UserId",getUserId())  
            .append("UserName",getUserName())  
            .append("CreateTime",getCreateTime())  
            .append("UpdateTime",getUpdateTime())  
            .append("IsDelete",getIsDelete())  
            .toString();  
    }  
	@Override
    public int hashCode() {  
        return new HashCodeBuilder()  
            .append(getUserId())  
            .toHashCode();  
    }  
	@Override
    public boolean equals(Object obj) {  
        if(obj instanceof UserInfoVO == false) {return false; }
        if(this == obj) { return true; }
        UserInfoVO other = (UserInfoVO)obj;
        return new EqualsBuilder()  
            .append(getUserId(),other.getUserId())  
            .isEquals();  
    }  

    
}

