package net.student.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import net.student.dao.StudentMasterDAOImpl;
import net.student.entities.*;



@Service
public class StudentMasterBoImpl implements StudentMasterBo {


	@Override
	public boolean addStudent( String name, String surname, String mobilePhone,  int cityId,int districtId, String description) {
	StudentMasterDAOImpl StudentMasterDAO=new StudentMasterDAOImpl();	
	return StudentMasterDAO.addStudent(name,surname,mobilePhone,cityId,districtId,description);		
	}
	
	@Override
	public boolean updateStudent (int studentId,String name, String surname, String mobilePhone, int cityId,int districtId, String description){
		
		StudentMasterDAOImpl StudentMasterDAO=new StudentMasterDAOImpl();
		return StudentMasterDAO.updateStudent(studentId,name, surname,  mobilePhone,  cityId, districtId, description);	}
	
	@Override
	public boolean deleteStudent (int studentId){	
		StudentMasterDAOImpl StudentMasterDAO=new StudentMasterDAOImpl();
		return StudentMasterDAO.deleteStudent(studentId);
	}
	
	@Override
	public  List<Student> listStudent(){
		StudentMasterDAOImpl StudentMasterDAO=new StudentMasterDAOImpl();
		return StudentMasterDAO.listStudent();		
	}
	
	public  List<Student> listSearchStudent(String name, String surname){
		StudentMasterDAOImpl StudentMasterDAO=new StudentMasterDAOImpl();
		return StudentMasterDAO.listSearchStudent(name, surname);		
	}
	
	public List<City> listCity(){
		StudentMasterDAOImpl StudentMasterDAO=new StudentMasterDAOImpl();
		return StudentMasterDAO.listCity();	
	}
	
	public List<District> listDistrict(int cityId){
		StudentMasterDAOImpl StudentMasterDAO=new StudentMasterDAOImpl();
		return StudentMasterDAO.listDistrict(cityId);	
	}
}
