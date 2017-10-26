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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="did")
	private Integer id;
	@Column(name="dname")
	private String name;
	@Column(name="dloc")
	private String location;

	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Dept(Integer no, String name, String location) {
		super();
		this.id = no;
		this.name = name;
		this.location = location;
	}
	public Dept() {
		super();
	}
	
}
