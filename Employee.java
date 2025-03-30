package model;

public class Employee {
	private int employeeId;
	private String employeename;
	private String designation;
	private float amount;
	
	public Employee(int employeeId, String employeename, String designation, float amount) {
		super();
		this.employeeId = employeeId;
		this.employeename = employeename;
		this.designation = designation;
		this.amount = amount;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
