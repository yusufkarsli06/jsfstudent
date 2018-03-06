package net.student.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.student.bo.StudentMasterBo;
import net.student.entities.*;



@Component
@ManagedBean(name="studentMasterBean")
@RequestScoped
public class StudentMasterBean {
	
	@Autowired
	StudentMasterBo studentMasterBo;
	private String surname;
	private String mobilePhone;
	private int cityId;	
	private int districtId;
	private String description;
	private int studentId;
	private String name;
	private String srcName;
	private String srcSurname;
	private int cityIdd;
	private int selectionCityId;
	private int selectionDistrictId;
	private int selectedStudentId;

	public int getStudentId() {
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

	public List<Student> getStudentList() {

		 List<Student> students =studentMasterBo.listStudent();
		 return students;		
	}
    	
	public List<Student> getSearchStudentList() {

		 List<Student> students =studentMasterBo.listSearchStudent(srcName, srcSurname);
		 return students;		
	}	

	public List<City> getCityList(){
		List<City> citys =studentMasterBo.listCity();
		return citys;		 
	}
		
	public List<District> getDistrictList(){
		List<District> districts =null;
		if(selectionCityId!=0){
			districts = studentMasterBo.listDistrict(selectionCityId);
			
		}
		return districts;
	}
	
	public List<District> districtList(){
		
		List<District> districts = studentMasterBo.listDistrict(selectionCityId);
		
		return districts;
	}
	
	public int getSelectedStudentId() {
		return selectedStudentId;
	}

	public void setSelectedStudentId(int selectedStudentId) {
		this.selectedStudentId = selectedStudentId;
	}

	public int getSelectionDistrictId() {
		return selectionDistrictId;
	}

	public void setSelectionDistrictId(int selectionDistrictId) {
		this.selectionDistrictId = selectionDistrictId;
	}

	public int getSelectionCityId() {
		return selectionCityId;
	}

	public void setSelectionCityId(int selectionCityId) {
		this.selectionCityId = selectionCityId;
	}

	public int getCityIdd() {
		return cityIdd;
	}

	public void setCityIdd(int cityIdd) {
		this.cityIdd = cityIdd;
	}

	public String getSrcName() {
		return srcName;
	}

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}

	public String getSrcSurname() {
		return srcSurname;
	}

	public void setSrcSurname(String srcSurname) {
		this.srcSurname = srcSurname;
	}


	public void addStudent()  {
	
		try {
			boolean success=studentMasterBo.addStudent(name,surname,mobilePhone,selectionCityId,selectionDistrictId,description);
			
			FacesMessage msg;
			
			if (success)
					 msg = new FacesMessage(FacesMessage.SEVERITY_INFO, " added to the student successfully", "success");
			else
					msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "error in adding student", "failure");
		    
			FacesContext.getCurrentInstance().addMessage("Message", msg);
			getStudentList();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

	public void updateStudent()  {
	
		boolean success=studentMasterBo.updateStudent(studentId,name,surname,mobilePhone,selectionCityId,selectionDistrictId,description);
		
		FacesMessage msg;
		
		if (success)
				 msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "update to the student successfully", "success");
		else
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "error in update student", "failure");
	    
		FacesContext.getCurrentInstance().addMessage("Message", msg);
	}
	
	public void deleteStudent()  {
	
		boolean success=studentMasterBo.deleteStudent(selectedStudentId);
				
		FacesMessage msg;
		
		if (success)
				 msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "delete to the student successfully", "success");
		else
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "error in delete student", "failure");
	    
		FacesContext.getCurrentInstance().addMessage("Message", msg);
	}



	public StudentMasterBo getStudentMasterBo() {
		return studentMasterBo;
	}


	public void setStudentMasterBo(StudentMasterBo studentMasterBo) {
		this.studentMasterBo = studentMasterBo;
	}

}
