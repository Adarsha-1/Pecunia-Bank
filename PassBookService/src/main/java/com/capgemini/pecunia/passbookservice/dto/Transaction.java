package com.capgemini.pecunia.passbookservice.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class Transaction {

	@Id
	@Column(name="TRANSACTIONID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionId;
	@Column(name="ACCOUNTNO")
	private long accountNo;
	@Column(name="TRANSACTIONTYPE")
	private String transactionType;
	@Column(name="TRANSACTIONAMOUNT")
	private double transactionAmount;
	@Column(name="TRANSACTIONDATE")
	private LocalDate transactionDate;
	@Column(name="TRANSACTIONSTATUS")
	private String transactionStatus;
	@Column(name="ACCOUNTBALANCE")
	private double accountBalance;
	public Transaction() {}
	public Transaction(long transactionId, long accountNo, String transactionType, double transactionAmount,
			LocalDate transactionDate, String transactionStatus, double accountBalance) {
		super();
		this.transactionId = transactionId;
		this.accountNo = accountNo;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
		this.accountBalance = accountBalance;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNo=" + accountNo + ", transactionType="
				+ transactionType + ", transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate
				+ ", transactionStatus=" + transactionStatus + ", accountBalance=" + accountBalance + "]";
	}
	
	
}
