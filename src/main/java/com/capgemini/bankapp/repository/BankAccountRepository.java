package com.capgemini.bankapp.repository;

import javax.security.auth.login.AccountNotFoundException;

public interface BankAccountRepository {
	
	public double getBalance(long accountId) throws AccountNotFoundException;
	public boolean updateBalance(long accountId, double newBalance);
}