package com.yaoyong.demo.sys.vo;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "User")
public class UserVO implements Serializable {

	 @ApiModelProperty("用户物理ID")
	 @Max(9223372036854775807L)
	private Long id;

	 @ApiModelProperty("用户UUID")
	 @Length(max=64)
	private String userId;

	 @ApiModelProperty("角色ID")
	 @Max(9223372036854775807L)
	private Long roleId;

	 @ApiModelProperty("用户类型")
	 @Max(9999999999L)
	private Integer userType;

	 @ApiModelProperty("商家ID")
	 @Length(max=64)
	private String merchantId;

	 @ApiModelProperty("用户状态0正常、1冻结")
	 @Max(9999999999L)
	private Integer userStatus;

	 @ApiModelProperty("loginName")
	 @Length(max=64)
	private String loginName;

	 @ApiModelProperty("登录匿称")
	 @Length(max=64)
	private String userName;

	 @ApiModelProperty("真是姓名")
	 @Length(max=64)
	private String realName;

	 @ApiModelProperty("加密后密码")
	 @Length(max=256)
	private String password;

	 @ApiModelProperty("电子邮件")
	 @Email @Length(max=128)
	private String email;

	 @ApiModelProperty("联系电话、多个")
	 @Length(max=128)
	private String mobile;

	 @ApiModelProperty("审批流程  0 审批  1 审批通过")
	 @Max(9999999999L)
	private Integer approve;

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

	public void setUserType(Integer value) {
		this.userType = value ;
	}
	public Integer getUserType() {
		return userType;
	}

	public void setMerchantId(String value) {
		this.merchantId = value ;
	}
	public String getMerchantId() {
		return merchantId;
	}

	public void setUserStatus(Integer value) {
		this.userStatus = value ;
	}
	public Integer getUserStatus() {
		return userStatus;
	}

	public void setLoginName(String value) {
		this.loginName = value ;
	}
	public String getLoginName() {
		return loginName;
	}

	public void setUserName(String value) {
		this.userName = value ;
	}
	public String getUserName() {
		return userName;
	}

	public void setRealName(String value) {
		this.realName = value ;
	}
	public String getRealName() {
		return realName;
	}

	public void setPassword(String value) {
		this.password = value ;
	}
	public String getPassword() {
		return password;
	}

	public void setEmail(String value) {
		this.email = value ;
	}
	public String getEmail() {
		return email;
	}

	public void setMobile(String value) {
		this.mobile = value ;
	}
	public String getMobile() {
		return mobile;
	}

	public void setApprove(Integer value) {
		this.approve = value ;
	}
	public Integer getApprove() {
		return approve;
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
            .append("UserId",getUserId())
            .append("RoleId",getRoleId())
            .append("UserType",getUserType())
            .append("MerchantId",getMerchantId())
            .append("UserStatus",getUserStatus())
            .append("LoginName",getLoginName())
            .append("UserName",getUserName())
            .append("RealName",getRealName())
            .append("Password",getPassword())
            .append("Email",getEmail())
            .append("Mobile",getMobile())
            .append("Approve",getApprove())
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
        if(obj instanceof UserVO == false) {return false; }
        if(this == obj) { return true; }
        UserVO other = (UserVO)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }


}

