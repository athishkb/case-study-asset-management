package model;

import java.util.Date;

public class maintenance_records {
	private int maintenance_id;
	private int asset_id;
	private String maintenance_date; 
	private String description;
	private double cost;
	
	public maintenance_records() {
		
	}

	
	public maintenance_records(int maintenance_id, int asset_id, String maintenance_date, String description, double cost) {
		this.maintenance_id = maintenance_id;
		this.asset_id = asset_id;
		this.maintenance_date = maintenance_date;
		this.description = description;
		this.cost = cost;
	}


	
	
	public int getmaintenance_id() {
		return maintenance_id;
	}


	public void setmaintenance_id(int maintenance_id) {
		this.maintenance_id = maintenance_id;
	}


	public int getasset_id() {
		return asset_id;
	}


	public void setasset_id(int asset_id) {
		this.asset_id = asset_id;
	}


	public String getmaintenance_date() {
		return maintenance_date;
	}


	public void setmaintenance_date(String maintenance_date) {
		this.maintenance_date = maintenance_date;
	}


	public String getdescription() {
		return description;
	}


	public void setdescription(String description) {
		this.description = description;
	}


	public double getcost() {
		return cost;
	}


	public void setcost(double cost) {
		this.cost = cost;
	}
	
	
	
	
	
}

