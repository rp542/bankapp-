package com.capgemini.bankapp.service;

import javax.security.auth.login.AccountNotFoundException;

import com.capgemini.bankapp.exceptions.LowBalancException;

public interface BankAccountService {

	public double getBalance(long accountId) throws AccountNotFoundException;

	public double withdraw(long accountId, double amount) throws LowBalancException, AccountNotFoundException;

	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalancException, AccountNotFoundException;

	public double deposit(long accountId, double amount) throws AccountNotFoundException;
}