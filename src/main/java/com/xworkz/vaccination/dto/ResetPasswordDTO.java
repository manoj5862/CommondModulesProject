package com.xworkz.vaccination.dto;

public class ResetPasswordDTO {

	private String email;
	private String password;
	private String confirmpassword;
	
	public ResetPasswordDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResetPasswordDTO(String email, String password, String confirmpassword) {
		super();
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	@Override
	public String toString() {
		return "ResetPasswordDTO [email=" + email + ", password=" + password + ", confirmpassword=" + confirmpassword
				+ "]";
	}
	
	
	
}
