package model;

public class PaySlip {
    private int slipId;
    private int employeeId;
    private String month;
    private int year;
    private double grossSalary;
    private double netSalary;
    private double deductions;
    
	public PaySlip(int slipId, int employeeId, String month, int year, double grossSalary, double netSalary,
			double deductions) {
		super();
		this.slipId = slipId;
		this.employeeId = employeeId;
		this.month = month;
		this.year = year;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
		this.deductions = deductions;
	}
	
	public int getSlipId() {
		return slipId;
	}
	public void setSlipId(int slipId) {
		this.slipId = slipId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	public double getDeductions() {
		return deductions;
	}
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
    
}