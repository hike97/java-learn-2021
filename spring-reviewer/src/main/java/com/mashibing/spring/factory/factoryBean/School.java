package com.mashibing.spring.factory.factoryBean;

/**
 * @author hike97 2month
 * @create 2021-05-06 15:00
 * @desc 普通Bean
 **/
public class School {
	private String schoolName;
	private String address;
	private int studentNumber;
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	@Override
	public String toString() {
		return "School [schoolName=" + schoolName + ", address=" + address
				+ ", studentNumber=" + studentNumber + "]";
	}
}
