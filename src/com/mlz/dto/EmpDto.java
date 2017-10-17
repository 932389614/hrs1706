package com.mlz.dto;

import java.io.Serializable;

import com.mlz.domain.Emp;

public class EmpDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer no;
	private String name;
	private String sex;
	private String status;
	private String job;
	private String tel;
	public Integer getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getStatus() {
		return status;
	}
	public String getJob() {
		return job;
	}
	public String getTel() {
		return tel;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public EmpDto(Emp emp) {
		this.setNo(emp.getNo());
		this.setName(emp.getName());
		this.setSex(emp.getSex()?"男":"女");
		this.setJob(emp.getJob());
		this.setStatus(emp.getStatus()?"在职":"离职");
	}
	
	
	
}
