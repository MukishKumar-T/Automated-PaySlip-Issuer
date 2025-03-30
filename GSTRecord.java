package model;

import java.util.Date;

public class GSTRecord {
    private int gstId;
    private Date transactionDate;
    private String transactionType;
    private double amount;
    private double gstRate;
    private double gstAmount;
	public GSTRecord(int gstId, Date transactionDate, String transactionType, double amount, double gstRate,
			double gstAmount) {
		super();
		this.gstId = gstId;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.amount = amount;
		this.gstRate = gstRate;
		this.gstAmount = gstAmount;
	}
	public int getGstId() {
		return gstId;
	}
	public void setGstId(int gstId) {
		this.gstId = gstId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getGstRate() {
		return gstRate;
	}
	public void setGstRate(double gstRate) {
		this.gstRate = gstRate;
	}
	public double getGstAmount() {
		return gstAmount;
	}
	public void setGstAmount(double gstAmount) {
		this.gstAmount = gstAmount;
	}

    
}
