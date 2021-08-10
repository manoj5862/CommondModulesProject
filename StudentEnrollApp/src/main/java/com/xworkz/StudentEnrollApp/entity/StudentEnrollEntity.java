package com.xworkz.StudentEnrollApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "student_table")
public class StudentEnrollEntity implements java.io.Serializable   {
	
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "STUDENT_ID")	
	private int id;
	@Column(name = "STUDENT_NAME")
	private String name;
	@Column(name = "STUDENT_EMAIL")
	private String email;
	@Column (name = "STUDENT_PASSWORD")
	private String password;
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public StudentEnrollEntity() {
		super();
	}

	public StudentEnrollEntity(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "StudentEnrollEntity [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}


	}
	

