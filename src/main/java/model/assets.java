package model;

import java.util.Date;

public class assets {
	private int asset_id;
	private String name;
	private String type;
	private int serial_number;
	private String purchase_date;
	private String location;
	private String status;
	private int owner_id;
	
	public assets(){
		
	}
	
	
	
	
	
	public assets(int asset_id, String name, String type, String purchase_date, String location, String status, int owner_id, int serial_number) {
		this.asset_id = asset_id;
		this.name = name;
		this.type = type;
		this.serial_number=serial_number;
		this.purchase_date = purchase_date;
		this.location = location;
		this.status = status;
		this.owner_id = owner_id;
	}





	public int getserial_number() {
		return serial_number;
	}





	public void setserial_number(int serial_number) {
		this.serial_number = serial_number;
	}





	public int getasset_id() {
		return asset_id;
	}
	public void setasset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type = type;
	}
	public String getpurchase_date() {
		return purchase_date;
	}
	public void setpurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location = location;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	public int getowner_id() {
		return owner_id;
	}
	public void setowner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	
	
}

