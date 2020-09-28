package com.capgemini.pecunia.entity;

import java.util.List;

public class UserTransactions {

	private List<Transcation> userTransaction;

	public UserTransactions() {}
	public UserTransactions(List<Transcation> userTransaction) {
		super();
		this.userTransaction = userTransaction;
	}
	public List<Transcation> getUserTransaction() {
		return userTransaction;
	}
	public void setUserTransaction(List<Transcation> userTransaction) {
		this.userTransaction = userTransaction;
	}
	
	
}
