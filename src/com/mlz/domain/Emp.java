package com.mlz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
/**
 * Ա����
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
	private Integer id;		//���
	@Column(name="ename")
	private String name;	//����
	@Column(name="esex")
	private Boolean sex;	//�Ա�
	@Column(name="ejob")
	private String job;		//ְλ
	
	@ManyToOne
	@JoinColumn(name="emgr")
	private Emp mgr;		//����
	@Column(name="esal")
	private Double salary;	//нˮ
	@Column(name="ehirdate")
	private Date hirDate;	//��ְʱ��
	@Column(name="estatus")
	private Boolean status;	//��ְ״̬
	@Column(name="ephoto")
	private String photo;	//ͷ��
	@Column(name="etel")
	private	String tel;		//�绰
	
	@ManyToOne
	@JoinColumn(name="dno")
	private Dept dept;		//����	

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
