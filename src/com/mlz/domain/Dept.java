package com.mlz.domain;

import java.io.Serializable;

import javax.persistence.*;
/**
 * ≤ø√≈¿‡
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_dept")
public class Dept implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="dno")
	private Integer no;
	@Column(name="dname")
	private String name;
	@Column(name="dloc")
	private String location;

	public Integer getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Dept(Integer no, String name, String location) {
		super();
		this.no = no;
		this.name = name;
		this.location = location;
	}
	public Dept() {
		super();
	}
	
}
