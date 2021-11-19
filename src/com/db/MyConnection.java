package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConnection {
	public Connection getConnection() throws Exception{
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/gifted?characterEncoding=utf8","root","root");
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Db connection is null");
		}
	}
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gifted","root","root");
			con=new com.db.MyConnection().getConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from login where emailid='admin@ds.com' and password='admin'");
			if(rs.next()){
				System.out.println(rs.getString("ul"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
