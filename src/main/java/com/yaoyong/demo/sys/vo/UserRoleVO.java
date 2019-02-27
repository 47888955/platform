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


@ApiModel(description = "UserRole")
public class UserRoleVO implements Serializable {
	
	 @ApiModelProperty("id")
	 @Max(9223372036854775807L)
	private Long id;
	
	 @ApiModelProperty("userId")
	 @Length(max=64)
	private String userId;
	
	 @ApiModelProperty("roleId")
	 @Max(9223372036854775807L)
	private Long roleId;
	

	public void setId(Long value) {
		this.id = value ;
	}
	public Long getId() {
		return id;
	}

	public void setUserId(String value) {
		this.userId = value ;
	}
	public String getUserId() {
		return userId;
	}

	public void setRoleId(Long value) {
		this.roleId = value ;
	}
	public Long getRoleId() {
		return roleId;
	}
	@Override
    public String toString() {  
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)  
            .append("Id",getId())  
            .append("UserId",getUserId())  
            .append("RoleId",getRoleId())  
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
        if(obj instanceof UserRoleVO == false) {return false; }
        if(this == obj) { return true; }
        UserRoleVO other = (UserRoleVO)obj;
        return new EqualsBuilder()  
            .append(getId(),other.getId())  
            .isEquals();  
    }  

    
}

