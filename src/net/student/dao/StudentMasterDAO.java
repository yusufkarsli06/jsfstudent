package net.student.dao;

import java.util.List;

import net.student.entities.*;

public interface StudentMasterDAO {
	
	boolean addStudent( String name,String surname, String mobilePhone, int cityId,int districtId,String description);
	boolean updateStudent(int studentId, String name,String surname, String mobilePhone,  int cityId,int districtId,String description); 
	boolean deleteStudent(int studentId) ;
	List<Student> listStudent();
	List<Student> listSearchStudent(String name, String surname);
	List<City> listCity();
	List<District> listDistrict(int cityId);
	
	
}
