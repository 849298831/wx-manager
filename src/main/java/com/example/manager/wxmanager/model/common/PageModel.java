package com.example.manager.wxmanager.model.common;

import javax.persistence.Transient;

public class PageModel implements PageSupport{
	@Transient
	private Integer pageNum;
	@Transient
	private Integer pageSize;
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
