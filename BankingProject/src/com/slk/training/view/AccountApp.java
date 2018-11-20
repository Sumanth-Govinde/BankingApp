package com.slk.training.view;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.slk.training.pojo.*;
import com.slk.training.service.*;

public class AccountApp {

	public static void main(String[] args) {
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
		System.out.println("welcome to our App");
		while(true){
		System.out.println("\n1. Deposit \n 2. Withdraw \n 3. Balance\n 4. Transfer\n");
		Scanner sc=new Scanner(System.in);
		
		
		AccountService aService=(AccountService)context.getBean("accountService");
		Account p1=(Account)context.getBean("account");
		int choice=sc.nextInt();
		
		switch(choice){
		
		case 1: 
			System.out.println("Enter the aid and amount to be deposited\n");
			int aid=sc.nextInt();
			int dep=sc.nextInt();
			aService.deposit(aid,dep);
			break;
		
		case 2:
			System.out.println("Enter the aid and amount to be withdrawn\n");
			aid=sc.nextInt();
			int wit=sc.nextInt();
			aService.withdraw(aid,wit);
			break;
		
		case 3:
			System.out.println("Enter the aid\n");
			Account a1=aService.balance(sc.nextInt());
			System.out.println(a1.getAid()+" "+a1.getAccName()+" "+a1.getBalance());
			break;
			
		case 4: 
			
			System.out.println("enter the aid of payer and amount of transfer");
			int p=sc.nextInt();
			int am=sc.nextInt();
			System.out.println("enter the aid of reciever");
			int r=sc.nextInt();
			aService.transfer(p,r,am,aService);
			break;
		
		default: System.out.println("Invalid choice\n");
		}

	}

}
	
}
