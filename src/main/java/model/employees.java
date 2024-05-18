package model;

public class employees {
	private int employee_id;
	private String name;
	private String department;
	private String email;
	private String password;
	
	public employees() {
		
	}
	
	
	
	public employees(int employee_id, String name, String department, String email, String password) {
		this.employee_id = employee_id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.password = password;
	}
	
	
	
	
	public int getemployee_id() {
		return employee_id;
	}
	public void setemployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getdepartment() {
		return department;
	}
	public void setdepartment(String department) {
		this.department = department;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	

}

