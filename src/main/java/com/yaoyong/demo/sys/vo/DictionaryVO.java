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


@ApiModel(description = "Dictionary")
public class DictionaryVO implements Serializable {
	
	 @ApiModelProperty("字典ID")
	 @Max(9223372036854775807L)
	private Long id;
	
	 @ApiModelProperty("双亲ID")
	 @Max(9223372036854775807L)
	private Long pid;
	
	 @ApiModelProperty("字典层级")
	 @Max(9999999999L)
	private Integer layer;
	
	 @ApiModelProperty("字典名称")
	 @Length(max=64)
	private String name;
	
	 @ApiModelProperty("字典CODE值")
	 @Length(max=32)
	private String code;
	
	 @ApiModelProperty("字典详细描述")
	 @Length(max=512)
	private String content;
	
	 @ApiModelProperty("排序")
	 @Max(9999999999L)
	private Integer sort;
	
	 @ApiModelProperty("'叶子节点{leaf：0，叶子节点；cate：1，目录节点;}' ")
	 @Max(9999999999L)
	private Integer isLeaf;
	
	 @ApiModelProperty("是否启动")
	 @Max(9999999999L)
	private Integer isEnable;
	
	 @ApiModelProperty("是否删除")
	 @Max(9999999999L)
	private Integer isDelete;
	
	 @ApiModelProperty("商户ID")
	 @Length(max=32)
	private String appid;
	
	 @ApiModelProperty("乐观锁字段")
	 @Max(9223372036854775807L)
	private Long version;
	

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

	public void setLayer(Integer value) {
		this.layer = value ;
	}
	public Integer getLayer() {
		return layer;
	}

	public void setName(String value) {
		this.name = value ;
	}
	public String getName() {
		return name;
	}

	public void setCode(String value) {
		this.code = value ;
	}
	public String getCode() {
		return code;
	}

	public void setContent(String value) {
		this.content = value ;
	}
	public String getContent() {
		return content;
	}

	public void setSort(Integer value) {
		this.sort = value ;
	}
	public Integer getSort() {
		return sort;
	}

	public void setIsLeaf(Integer value) {
		this.isLeaf = value ;
	}
	public Integer getIsLeaf() {
		return isLeaf;
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

	public void setAppid(String value) {
		this.appid = value ;
	}
	public String getAppid() {
		return appid;
	}

	public void setVersion(Long value) {
		this.version = value ;
	}
	public Long getVersion() {
		return version;
	}
	@Override
    public String toString() {  
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)  
            .append("Id",getId())  
            .append("Pid",getPid())  
            .append("Layer",getLayer())  
            .append("Name",getName())  
            .append("Code",getCode())  
            .append("Content",getContent())  
            .append("Sort",getSort())  
            .append("IsLeaf",getIsLeaf())  
            .append("IsEnable",getIsEnable())  
            .append("IsDelete",getIsDelete())  
            .append("Appid",getAppid())  
            .append("Version",getVersion())  
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
        if(obj instanceof DictionaryVO == false) {return false; }
        if(this == obj) { return true; }
        DictionaryVO other = (DictionaryVO)obj;
        return new EqualsBuilder()  
            .append(getId(),other.getId())  
            .isEquals();  
    }  

    
}

