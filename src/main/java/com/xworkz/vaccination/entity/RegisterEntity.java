package com.xworkz.vaccination.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "vaccination_table")
@NamedQueries({
		@NamedQuery(name = "GetRecordByMail", query = "SELECT citizen FROM RegisterEntity citizen WHERE citizen.email=:em "),
        @NamedQuery(name = "updateNoOfLoginAttempByEmail", query = "update  RegisterEntity entity set entity.noOfLoginAttempts=:login where entity.email=:emailId"),
        @NamedQuery(name = "getNoOfLoginAttemptsByMail", query = "SELECT citizen.noOfLoginAttempts FROM RegisterEntity citizen WHERE citizen.email=:em "),
        @NamedQuery(name = "updatePasswordByEmail", query = "update  RegisterEntity entity set entity.password=:pass where entity.email=:emailId"),
        @NamedQuery(name = "updateNoOfLoginAttemptsByEmail", query = "update  RegisterEntity entity set entity.noOfLoginAttempts=:loginAttempts where entity.email=:emailId"),
        @NamedQuery(name = "getNoOfCheckAddmembersByMail", query = "SELECT citizen.noAddMemberCount FROM RegisterEntity citizen WHERE citizen.email=:em "),
        @NamedQuery(name = "updateAddMemberCountByEmail", query = "update  RegisterEntity entity set entity.noAddMemberCount=:addMemberCount where entity.email=:emailId")
		})
public class RegisterEntity {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ID")
	private int id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "AGE")
	private int age;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "PHONENUMBER")
	private long phonenumber;
	@Column(name = "VACCINETYPE")
	private String vaccineType;
	@Column(name = "NO_OF_lOGIN_ATTEMPT")
	private int noOfLoginAttempts;
	@Column(name = "NOOF_ADDMEMBER_COUNT")
	private int noAddMemberCount;
	

	public int getNoAddMemberCount() {
		return noAddMemberCount;
	}

	public void setNoAddMemberCount(int noAddMemberCount) {
		this.noAddMemberCount = noAddMemberCount;
	}

	public RegisterEntity(int id, String username, String email, int age, String password, long phonenumber,
			String vaccineType, int noOfLoginAttempts, int noAddMemberCount) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.age = age;
		this.password = password;
		this.phonenumber = phonenumber;
		this.vaccineType = vaccineType;
		this.noOfLoginAttempts = noOfLoginAttempts;
		this.noAddMemberCount = noAddMemberCount;
	}

	public RegisterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterEntity(int id, String username, String email, int age, String password, long phonenumber,
			String vaccineType, int noOfLoginAttempts) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.age = age;
		this.password = password;
		this.phonenumber = phonenumber;
		this.vaccineType = vaccineType;
		this.noOfLoginAttempts = noOfLoginAttempts;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNoOfLoginAttempts() {
		return noOfLoginAttempts;
	}

	public void setNoOfLoginAttempts(int noOfLoginAttempts) {
		this.noOfLoginAttempts = noOfLoginAttempts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOtp() {
		return age;
	}

	public void setOtp(int otp) {
		this.age = otp;
	}

	@Override
	public String toString() {
		return "RegisterEntity [id=" + id + ", username=" + username + ", email=" + email + ", age=" + age
				+ ", password=" + password + ", phonenumber=" + phonenumber + ", vaccineType=" + vaccineType
				+ ", noOfLoginAttempts=" + noOfLoginAttempts + ", noAddMemberCount=" + noAddMemberCount + "]";
	}

}
