package com.mlz.util;

import java.util.*;
/**
 * ·ÖÒ³Æ÷¶ÔÏó
 * @author Administrator
 *
 * @param <T>
 */
public class PageBean<T> {
	private List<T> dataModel;
	private int totalPage;
	private int currentPage;
	private int pageSize;
	public List<T> getDataModel() {
		return dataModel;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setDataModel(List<T> dataModel) {
		this.dataModel = dataModel;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public PageBean(List<T> dataModel, int totalPage, int currentPage, int pageSize) {
		super();
		this.dataModel = dataModel;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	
}
