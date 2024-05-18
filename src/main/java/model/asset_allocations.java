package model;

import java.util.Date;

public class asset_allocations {
	private int allocation_id;
	private int asset_id;
	private int employee_id;
	private String allocation_date;
	private String return_date;
	
	public asset_allocations() {
		
	}

	
	
	public asset_allocations(int allocation_id, int asset_id, int employee_id, String allocation_date, String return_date) {
		this.allocation_id = allocation_id;
		this.asset_id = asset_id;
		this.employee_id = employee_id;
		this.allocation_date = allocation_date;
		this.return_date = return_date;
	}



	
	
	
	public int getAllocation_id() {
		return allocation_id;
	}



	public void setAllocation_id(int allocation_id) {
		this.allocation_id = allocation_id;
	}



	public int getAsset_id() {
		return asset_id;
	}



	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}



	public int getEmployee_id() {
		return employee_id;
	}



	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}



	public String getallocation_date() {
		return allocation_date;
	}



	public void setallocation_date(String allocation_date) {
		this.allocation_date = allocation_date;
	}



	public String getreturn_date() {
		return return_date;
	}



	public void setreturn_date(String return_date) {
		this.return_date = return_date;
	}
	
	
	
}

