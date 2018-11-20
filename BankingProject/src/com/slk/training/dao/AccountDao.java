package com.slk.training.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.slk.training.pojo.Account;
import com.slk.training.service.AccountService;

import java.util.*;
@Repository
public class AccountDao {

	
	@Autowired
JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void deposit(int aid,int deposit){
		
		
		jdbcTemplate.update("update account set balance=balance+? where aid=?",deposit,aid);
		System.out.println("deposited");
	}
	
	public void withdraw(int aid,int withdraw){
		
		jdbcTemplate.update("update account set balance=balance-? where aid=?",withdraw,aid);
		System.out.println("withdrawn");
	}
	
	public Account balance(int aid){
		System.out.println("balance");
		return jdbcTemplate.queryForObject("select * from account where aid=?",new BeanPropertyRowMapper<Account>(Account.class),aid);
	}
	
	public void transfer(int p,int r,int am,AccountService aService){
		System.out.println("transfer");
		aService.withdraw(p, am);
		System.out.println("\nReturn \n");
		aService.deposit(r, am);

	}
}
