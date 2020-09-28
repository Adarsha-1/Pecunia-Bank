package com.capgemini.pecunia.atmservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="atmregistry")
public class AtmRegistry {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ATMNUMBER")
	private long atmNumber;
	@NotNull
	@Column(name="ACCOUNTNUMBER")
	private long accountNumber;
	@NotNull
	@Column(name="STATUS")
	private String status;
	public AtmRegistry() {}
	public AtmRegistry(long atmNumber, long accountNumber, String status) {
		super();
		this.atmNumber = atmNumber;
		this.accountNumber = accountNumber;
		this.status = status;
	}
	public long getAtmNumber() {
		return atmNumber;
	}
	public void setAtmNumber(long atmNumber) {
		this.atmNumber = atmNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AtmRegistry [atmNumber=" + atmNumber + ", accountNumber=" + accountNumber + ", status=" + status + "]";
	}
	
}
