package com.slk.training.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	static Connection con=null;
	 public static Connection getConnection()
	 {
		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/slktraining","root","root");
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		return con;

	}

}
