package com.Project.member.db;

import java.sql.Timestamp;

public class MemberDTO {
	// model2-itwill_memeber 테이블 참고
	
	private String id;
	private String pass;
	private String name;
	private int age;
	private String gender;
	private String email;
	private String	zipcode;
	private String	roadAddress;
	private String	jibunAddress;
	private String	namujiAddress;
	private Timestamp reg_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getJibunAddress() {
		return jibunAddress;
	}

	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}

	public String getNamujiAddress() {
		return namujiAddress;
	}

	public void setNamujiAddress(String namujiAddress) {
		this.namujiAddress = namujiAddress;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;

	}

	@Override
	public String toString() {
		return "MemberDTO{" +
				"id='" + id + '\'' +
				", pass='" + pass + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				", email='" + email + '\'' +
				", zipcode='" + zipcode + '\'' +
				", roadAddress='" + roadAddress + '\'' +
				", jibunAddress='" + jibunAddress + '\'' +
				", namujiAddress='" + namujiAddress + '\'' +
				", reg_date=" + reg_date +
				'}';
	}
}


