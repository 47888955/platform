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


@ApiModel(description = "RolePerm")
public class RolePermVO implements Serializable {
	
	 @ApiModelProperty("物理ID")
	 @Max(9223372036854775807L)
	private Long id;
	
	 @ApiModelProperty("roleId")
	 @Max(9223372036854775807L)
	private Long roleId;
	
	 @ApiModelProperty("perId")
	 @Max(9223372036854775807L)
	private Long perId;
	
	 @ApiModelProperty("权限号、功能唯一性")
	 @Length(max=64)
	private String permCode;
	
	 @ApiModelProperty("权限URL")
	 @Length(max=128)
	private String permUrl;
	
	 @ApiModelProperty("请求方法Get Post   Put   Head  Delete  (大写)")
	 @Length(max=32)
	private String httpMethod;
	

	public void setId(Long value) {
		this.id = value ;
	}
	public Long getId() {
		return id;
	}

	public void setRoleId(Long value) {
		this.roleId = value ;
	}
	public Long getRoleId() {
		return roleId;
	}

	public void setPerId(Long value) {
		this.perId = value ;
	}
	public Long getPerId() {
		return perId;
	}

	public void setPermCode(String value) {
		this.permCode = value ;
	}
	public String getPermCode() {
		return permCode;
	}

	public void setPermUrl(String value) {
		this.permUrl = value ;
	}
	public String getPermUrl() {
		return permUrl;
	}

	public void setHttpMethod(String value) {
		this.httpMethod = value ;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	@Override
    public String toString() {  
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)  
            .append("Id",getId())  
            .append("RoleId",getRoleId())  
            .append("PerId",getPerId())  
            .append("PermCode",getPermCode())  
            .append("PermUrl",getPermUrl())  
            .append("HttpMethod",getHttpMethod())  
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
        if(obj instanceof RolePermVO == false) {return false; }
        if(this == obj) { return true; }
        RolePermVO other = (RolePermVO)obj;
        return new EqualsBuilder()  
            .append(getId(),other.getId())  
            .isEquals();  
    }  

    
}

