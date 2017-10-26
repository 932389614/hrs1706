package com.mlz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
/**
 * 员工类
 * @author Administrator
 *
 *
 */
@Entity
@Table(name="tb_emp")
public class Emp implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="eid")
	private Integer id;		//编号
	@Column(name="ename")
	private String name;	//姓名
	@Column(name="esex")
	private Boolean sex;	//性别
	@Column(name="ejob")
	private String job;		//职位
	
	@ManyToOne
	@JoinColumn(name="emgr")
	private Emp mgr;		//主管
	@Column(name="esal")
	private Double salary;	//薪水
	@Column(name="ehirdate")
	private Date hirDate;	//入职时间
	@Column(name="estatus")
	private Boolean status;	//在职状态
	@Column(name="ephoto")
	private String photo;	//头像
	@Column(name="etel")
	private	String tel;		//电话
	
	@ManyToOne
	@JoinColumn(name="dno")
	private Dept dept;		//部门	

	public String getName() {
		return name;
	}
	public Boolean getSex() {
		return sex;
	}
	public String getJob() {
		return job;
	}

	public Double getSalary() {
		return salary;
	}

	public Boolean getStatus() {
		return status;
	}
	public String getPhoto() {
		return photo;
	}
	public String getTel() {
		return tel;
	}
	public Dept getDept() {
		return dept;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Emp getMgr() {
		return mgr;
	}
	public Date getHirDate() {
		return hirDate;
	}
	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}
	public void setHirDate(Date hirDate) {
		this.hirDate = hirDate;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	public Emp() {
		super();
	}
	public Emp(Integer id, String name, Boolean sex, String job, Emp mgr, Double salary, Date hirDate, Boolean status,
			String photo, String tel, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.job = job;
		this.mgr = mgr;
		this.salary = salary;
		this.hirDate = hirDate;
		this.status = status;
		this.photo = photo;
		this.tel = tel;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Emp [no=" + id + ", name=" + name + ", sex=" + sex + ", job=" + job + ", mgr=" + mgr + ", salary="
				+ salary + ", hirDate=" + hirDate + ", status=" + status + ", photo=" + photo + ", tel=" + tel
				+ ", dept=" + dept + "]";
	}

}
