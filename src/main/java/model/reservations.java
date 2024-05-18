package model;

import java.util.Date;

public class reservations {
	private int reservation_id;
	private int asset_id;
	private int employee_id;
	private String reservation_date;
	private String start_date;
	private String end_date;
	private String status;
	
	public reservations() {
		
	}

	public reservations(int reservation_id, int asset_id, int employee_id, String reservation_date, String start_date, String end_date, String status) {
		this.reservation_id = reservation_id;
		this.asset_id = asset_id;
		this.employee_id = employee_id;
		this.reservation_date = reservation_date;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
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

	public String getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	

}

