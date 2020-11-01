//package com.laptrinhjavaweb.repository.impl;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class EntityManagerFactory {
//	private static final EntityManagerFactory instance = new EntityManagerFactory();
//
//	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	private static final String DB_URL = "jdbc:mysql://localhost/javaweb62020module1";
//	private static final String USER = "root";
//	private static final String PASS = "123456";
//	
//	// private constructor to avoid client applications to use constructor
//	private EntityManagerFactory() {
//	}
//
//	public static EntityManagerFactory getInstance() {
//		return instance;
//
//	}
//
//	public Connection getConnection() {
//		try {
//			Class.forName(JDBC_DRIVER);
//			return DriverManager.getConnection(DB_URL, USER, PASS);
//		} catch (Exception e) {
//			return null;
//		}
//	}
//}
