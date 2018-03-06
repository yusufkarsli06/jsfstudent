package net.student.entities;

public class District {

	private int districtId;
	private String districtName;
	
	public District(int districtId, String districtName){
		
		this.districtId=districtId;
		this.districtName=districtName;
		
	}
	
	public District(){
		
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
}
