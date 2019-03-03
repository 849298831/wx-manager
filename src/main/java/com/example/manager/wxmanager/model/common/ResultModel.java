package com.example.manager.wxmanager.model.common;


import java.io.Serializable;

public class ResultModel implements Serializable {

	private static final long serialVersionUID = -1387824061906626473L;
	private boolean success;//是否成功
	private String msg;//消息
	private Object data;//数据
	private int status;//状态 0 成功  1 失败

	public ResultModel() {

	}

	public ResultModel(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public ResultModel(boolean success, String msg, Object data) {
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public ResultModel(boolean success, String msg, Object data, int status) {
		this.success = success;
		this.msg = msg;
		this.data = data;
		this.status = status;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
