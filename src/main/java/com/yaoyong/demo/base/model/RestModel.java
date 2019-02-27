package com.yaoyong.demo.base.model;

import java.io.Serializable;

import com.yaoyong.demo.base.constant.HttpEnumStatus;

import io.swagger.annotations.ApiModel;

@ApiModel
public class RestModel<T> implements Serializable {
	private static final long serialVersionUID = 2389511624396502323L;


	private Integer status;
	private String msg;
	private T data;

	public RestModel(T data) {
		this.status = HttpEnumStatus.OK.getIndex();
		this.msg = HttpEnumStatus.OK.getName();
		this.data = data;
	}

	// 返回数据
	public static <T> RestModel<T> data(T t) {
		RestModel<T> restModel = new RestModel<T>(t);
		restModel.setData(t);
		restModel.setStatus(restModel.getStatus());
		restModel.setMsg(restModel.getMsg());
		return restModel;
	}



	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static <T>  RestModel<T> status(HttpEnumStatus status) {
		RestModel<T> restModel = new RestModel<T>(null);
		restModel.setStatus(status.getIndex());
		restModel.setMsg(status.getName());
		return restModel;
	}

}
