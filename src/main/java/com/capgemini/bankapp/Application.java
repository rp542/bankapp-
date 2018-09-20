package com.capgemini.bankapp;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.exceptions.LowBalancException;

public class Application {

	public static void main(String[] args) throws AccountNotFoundException, LowBalancException {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 */
		BankAccountController bankAccountController = context.getBean("bankAccountController",
				BankAccountController.class);
		/*System.out.println(bankAccountController.getBalance(1234));
		System.out.println(bankAccountController.withdraw(1234,1000.0));*/
		System.out.println(bankAccountController.getBalance(1234));
	}

}
