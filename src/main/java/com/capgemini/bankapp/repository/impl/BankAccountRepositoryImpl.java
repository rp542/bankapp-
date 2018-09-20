package com.capgemini.bankapp.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.database.DbUtil;
import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {
	private HashSet<BankAccount> bankAccounts;
	@Autowired
	DbUtil dbUtil;

public BankAccountRepositoryImpl() {
		super();
		bankAccounts = new HashSet<>();
		bankAccounts.add(new BankAccount(1234, "priyanka", "saving", 34000));
		bankAccounts.add(new BankAccount(2345, "priya", "current", 44000));
		bankAccounts.add(new BankAccount(2222, "amrin", "saving", 33000));
	}
	@Override
	public double getBalance(long accountId) throws AccountNotFoundException{
		String query = "SELECT accountBalance FROM bankaccount WHERE accountId = ?";
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			
			statement.setLong(1, accountId);
			try(ResultSet result = statement.executeQuery()){
			if (result.next()) {
				return result.getInt(1);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new AccountNotFoundException("Account doesn't exist!");
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		String query = "UPDATE bankaccount SET accountBalance = ? WHERE accountId = ?";
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setDouble(1, newBalance);
			statement.setLong(2, accountId);
			if(statement.executeUpdate() != 0) {
				System.out.println("Record inserted successfully");
			return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}
