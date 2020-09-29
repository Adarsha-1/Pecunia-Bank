package com.capgemini.pecunia.passbookservice.dto;

import java.time.LocalDate;

public class Transcation {
	
	private Long transactionId;
	private long accountNo;
	private String transcationType;
	private double transcationAmount;
	private double balance;
	private LocalDate transcationDate;
	private String transcationStatus;
	
	public Transcation() {
		super();
	}
	
	public Transcation(long accountNo, String transcationType, double transcationAmount,double balance,
			LocalDate transcationDate, String transcationStatus) {
		super();
		this.accountNo = accountNo;
		this.transcationType = transcationType;
		this.transcationAmount = transcationAmount;
		this.transcationDate = transcationDate;
		this.transcationStatus = transcationStatus;
		this.balance=balance;
	}
	
	public Transcation(Long transactionId, long accountNo, String transcationType, double transcationAmount,
			double balance, LocalDate transcationDate, String transcationStatus) {
		super();
		this.transactionId = transactionId;
		this.accountNo = accountNo;
		this.transcationType = transcationType;
		this.transcationAmount = transcationAmount;
		this.balance = balance;
		this.transcationDate = transcationDate;
		this.transcationStatus = transcationStatus;
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
	public void setAccountNo(long account) {
		this.accountNo = account;
	}
	public String getTranscationType() {
		return transcationType;
	}
	public void setTranscationType(String transcationType) {
		this.transcationType = transcationType;
	}
	public double getTranscationAmount() {
		return transcationAmount;
	}
	public void setTranscationAmount(double transcationAmount) {
		this.transcationAmount = transcationAmount;
	}
	public LocalDate getTranscationDate() {
		return transcationDate;
	}
	public void setTranscationDate(LocalDate transcationDate) {
		this.transcationDate = transcationDate;
	}
	public String getTranscationStatus() {
		return transcationStatus;
	}
	public void setTranscationStatus(String transcationStatus) {
		this.transcationStatus = transcationStatus;
	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transcation [transcationId=" + transactionId + ", accountNo=" + accountNo + ", transcationType="
				+ transcationType + ", transcationAmount=" + transcationAmount + ", balance=" + balance
				+ ", transcationDate=" + transcationDate + ", transcationStatus=" + transcationStatus + "]";
	}

	
	
	
}
