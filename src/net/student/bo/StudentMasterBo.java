package net.student.bo;

import java.util.List;

import net.student.entities.*;

public interface StudentMasterBo {

	  boolean addStudent( String name,String surname, String mobilePhone, int cityId,int districtId,String description);
	
	  boolean updateStudent(int studentId, String name,String surname, String mobilePhone,int cityId,int districtId,String description);
		
	  boolean deleteStudent(int studentId);
		
	  public  List<Student> listStudent();
	  
	  public  List<Student> listSearchStudent(String name, String surname);
	  
	  public List<City> listCity();
	  
	  public List<District> listDistrict(int cityId);
}
