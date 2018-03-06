package net.student.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Converter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import net.student.entities.*;


public class StudentMasterDAOImpl implements StudentMasterDAO {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public void setDataSource(DataSource dataSource){
		this.dataSource=dataSource;
		
	}	
	
	public boolean addStudent( String name,String surname, String mobilePhone, int cityId,int districtId,String description)
	{ 				
							
		String sql = "INSERT INTO TBL_STUDENT " +
				"(student_id, name,surname,mobile_phone,city_id,district_id,description) VALUES (seq_student_id.nextval, ?, ?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {name,surname,mobilePhone,cityId,districtId,description});		
		
		
		return true;		
	}

	public boolean updateStudent( int studentId, String name,String surname, String mobilePhone,  int cityId,int districtId,String description)
	{
		System.out.println("status : "+ "update success");	
		return true;		
	}
	public boolean deleteStudent( int studentId)
	{	
		String sql = "delete from tbl_student t where t.student_id =?";
		jdbcTemplate.update(sql, new Object[] {studentId});		
		
		return true;	
	}
	
	public  List<Student> listStudent(){
						
		String sql = "select t.* ,(select district_name  from tbl_district dtc  where dtc.district_id=t.district_id ) as district_name ,(select city_name  from tbl_city cty  where cty.city_id=t.city_id ) as city_name from tbl_student t ";
		List<Map<String, Object>> lll = jdbcTemplate.queryForList(sql);	
		List<Student> students = new ArrayList<>();
		for(Map<String,Object> map : lll){
			Student student = new Student();
			student.setName(map.get("NAME").toString());	
			student.setSurname(map.get("SURNAME").toString());
			student.setMobilePhone(map.get("MOBILE_PHONE").toString());
			student.setCityName(map.get("CITY_NAME").toString());
			student.setDistrictName(map.get("DISTRICT_NAME").toString());
			student.setDescription(map.get("DESCRIPTION").toString());
			students.add(student);
		}
		return students;
	}
	public  List<Student> listSearchStudent(String name, String surname){
		
						
		String sql = "select t.* ,(select district_name  from tbl_district dtc  where dtc.district_id=t.district_id ) as district_name ,(select city_name  from tbl_city cty  where cty.city_id=t.city_id ) as city_name from tbl_student t where (? is null or t.name like ?) and (? is null or t.surname like ?) order by t.student_id desc";
		List<Map<String, Object>> lll = jdbcTemplate.queryForList(sql,name,name,surname,surname);	
		List<Student> students = new ArrayList<>();
		for(Map<String,Object> map : lll){
			Student student = new Student();
			student.setStudentId(Integer.parseInt(map.get("STUDENT_ID").toString()));
			student.setName(map.get("NAME").toString());	
			student.setSurname(map.get("SURNAME").toString());
			student.setMobilePhone(map.get("MOBILE_PHONE").toString());
			student.setCityName(map.get("CITY_NAME").toString());
			student.setDistrictName(map.get("DISTRICT_NAME").toString());
			student.setDescription(map.get("DESCRIPTION").toString());
			students.add(student);
		}
		return students;
	}
	
	public void listStudentSelection(int studentId){
		
					
		String sql = "select * from tbl_student where student_id=?";
		List<Map<String, Object>> lll = jdbcTemplate.queryForList(sql,studentId);	
		
	}
	
	public List<District> listDistrict(int cityId){
						
		String sql = "select * from tbl_district where city_id =? order by district_name ";
		List<Map<String, Object>> lll = jdbcTemplate.queryForList(sql,cityId);	
		List<District> districts = new ArrayList<>();
		for(Map<String,Object> map : lll){
			District district = new District();
			district.setDistrictName(map.get("DISTRICT_NAME").toString());	
			district.setDistrictId(Integer.parseInt(map.get("DISTRICT_ID").toString()));			
			districts.add(district);
		}		
		return districts;
		
	}
	
	
	public List<City> listCity(){
			
						
		String sql = "select * from tbl_city  order by city_name";
		List<Map<String, Object>> lll = jdbcTemplate.queryForList(sql);	
		List<City> citys = new ArrayList<>();
		for(Map<String,Object> map : lll){
			City city = new City();
			city.setCityName(map.get("CITY_NAME").toString());	
			city.setCityId(Integer.parseInt(map.get("CITY_ID").toString()));		
			
			citys.add(city);
		}
		return citys;
			
	}
	
	
}
