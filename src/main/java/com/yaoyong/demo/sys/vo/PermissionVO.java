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


@ApiModel(description = "Permission")
public class PermissionVO implements Serializable {
	
	 @ApiModelProperty("物理ID")
	 @Max(9223372036854775807L)
	private Long id;
	
	 @ApiModelProperty("双亲ID")
	 @Max(9223372036854775807L)
	private Long pid;
	
	 @ApiModelProperty("平台类型（0后台 1前台）")
	 @Max(9999999999L)
	private Integer platType;
	
	 @ApiModelProperty("所在层级")
	 @Max(9999999999L)
	private Integer layer;
	
	 @ApiModelProperty("是否叶子(0权限目录 1权限点)")
	 @Max(9999999999L)
	private Integer isLeaf;
	
	 @ApiModelProperty("权限名")
	 @Length(max=64)
	private String name;
	
	 @ApiModelProperty("权限号、功能唯一性")
	 @Length(max=64)
	private String permCode;
	
	 @ApiModelProperty("权限URL")
	 @Length(max=128)
	private String permUrl;
	
	 @ApiModelProperty("请求方法Get Post   Put   Head  Delete  (大写)")
	 @Length(max=32)
	private String httpMethod;
	
	 @ApiModelProperty("权限描述")
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
	
	 @ApiModelProperty("创建时间")
	 @Max(9223372036854775807L)
	private Long createTime;
	
	 @ApiModelProperty("更新时间")
	 @Max(9223372036854775807L)
	private Long updateTime;
	

	public void setId(Long value) {
		this.id = value ;
	}
	public Long getId() {
		return id;
	}

	public void setPid(Long value) {
		this.pid = value ;
	}
	public Long getPid() {
		return pid;
	}

	public void setPlatType(Integer value) {
		this.platType = value ;
	}
	public Integer getPlatType() {
		return platType;
	}

	public void setLayer(Integer value) {
		this.layer = value ;
	}
	public Integer getLayer() {
		return layer;
	}

	public void setIsLeaf(Integer value) {
		this.isLeaf = value ;
	}
	public Integer getIsLeaf() {
		return isLeaf;
	}

	public void setName(String value) {
		this.name = value ;
	}
	public String getName() {
		return name;
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
	@Override
    public String toString() {  
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)  
            .append("Id",getId())  
            .append("Pid",getPid())  
            .append("PlatType",getPlatType())  
            .append("Layer",getLayer())  
            .append("IsLeaf",getIsLeaf())  
            .append("Name",getName())  
            .append("PermCode",getPermCode())  
            .append("PermUrl",getPermUrl())  
            .append("HttpMethod",getHttpMethod())  
            .append("Content",getContent())  
            .append("IsEnable",getIsEnable())  
            .append("IsDelete",getIsDelete())  
            .append("Version",getVersion())  
            .append("Appid",getAppid())  
            .append("CreateTime",getCreateTime())  
            .append("UpdateTime",getUpdateTime())  
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
        if(obj instanceof PermissionVO == false) {return false; }
        if(this == obj) { return true; }
        PermissionVO other = (PermissionVO)obj;
        return new EqualsBuilder()  
            .append(getId(),other.getId())  
            .isEquals();  
    }  

    
}

