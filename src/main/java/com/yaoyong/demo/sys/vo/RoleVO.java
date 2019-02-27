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


@ApiModel(description = "Role")
public class RoleVO implements Serializable {
	
	 @ApiModelProperty("物理ID")
	 @Max(9223372036854775807L)
	private Long id;
	
	 @ApiModelProperty("平台类型（0后台 1前台）")
	 @Max(9999999999L)
	private Integer platType;
	
	 @ApiModelProperty("角色名称")
	 @Length(max=64)
	private String name;
	
	 @ApiModelProperty("详细描述")
	 @Length(max=512)
	private String content;
	
	 @ApiModelProperty("是否启动")
	 @Max(9999999999L)
	private Integer isEnable;
	
	 @ApiModelProperty("是否删除")
	 @Max(9999999999L)
	private Integer isDelete;
	
	 @ApiModelProperty("乐观锁版本")
	 @Max(9223372036854775807L)
	private Long version;
	
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

	public void setName(String value) {
		this.name = value ;
	}
	public String getName() {
		return name;
	}

	public void setContent(String value) {
		this.content = value ;
	}
	public String getContent() {
		return content;
	}

	public void setIsEnable(Integer value) {
		this.isEnable = value ;
	}
	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsDelete(Integer value) {
		this.isDelete = value ;
	}
	public Integer getIsDelete() {
		return isDelete;
	}

	public void setVersion(Long value) {
		this.version = value ;
	}
	public Long getVersion() {
		return version;
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
            .append("Name",getName())  
            .append("Content",getContent())  
            .append("IsEnable",getIsEnable())  
            .append("IsDelete",getIsDelete())  
            .append("Version",getVersion())  
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
        if(obj instanceof RoleVO == false) {return false; }
        if(this == obj) { return true; }
        RoleVO other = (RoleVO)obj;
        return new EqualsBuilder()  
            .append(getId(),other.getId())  
            .isEquals();  
    }  

    
}

