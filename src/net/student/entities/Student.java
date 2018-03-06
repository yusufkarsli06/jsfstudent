package net.student.entities;

import net.student.bo.StudentMasterBo;

public class Student {
	private int studentId;
	private String name;
	private String surname;
	private String mobilePhone;
	private int cityId;
	private String cityName;
	private String districtName;
	private int districtId;
	private String description;
	
	public Student (int studentId,String name,String surname,String mobilePhone,int cityId,int districtId,String description,String cityName,String districtName){
		this.studentId=studentId;
		this.name=name;
		this.surname=surname;
		this.mobilePhone=mobilePhone;
		this.cityId=cityId;
		this.cityName=cityName;
		this.districtId=districtId;
		this.districtName=districtName;
		this.description=description;				
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getStudentId(){
		return studentId;
	}
	
	public void setStudentId(int studentId) {
	    this.studentId = studentId;
	}	
	
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	 
	public String getSurname() {
	    return surname;
	}
	 
	public void setSurname(String surname) {
	    this.surname = surname;
	}
	 
	public String getMobilePhone() {
	    return mobilePhone;
	}
	 
	public void setMobilePhone(String mobilePhone) {
	    this.mobilePhone = mobilePhone;
	}
	
 
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDescription() {
	    return description;
	}
	
	public void setDescription(String description) {
	    this.description = description;
	}
 
}
