package com.slk.training.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.training.dao.AccountDao;
//import com.slk.training.dao.List;
import com.slk.training.pojo.Account;


@Service
public class AccountService {

	@Autowired
	AccountDao accountDao;
	
    public void deposit(int aid,int deposit){
		accountDao.deposit(aid,deposit);
	}
	
	public void withdraw(int aid,int withdraw){
		accountDao.withdraw(aid,withdraw);
	}
	
	public Account balance(int aid){
		return accountDao.balance(aid);
	}
	
	public void transfer(int p,int r,int am,AccountService aService){
		accountDao.transfer(p,r,am,aService);
	}

	
}
