package com.board.bdi.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static String URL;
	private static String ID;
	private static String PWD;
	static {
		InputStream is = DBCon.class.getResourceAsStream("/config/dbconfig.properties");
		System.out.println(is);
		Properties prop = new Properties();
		try {
			prop.load(is);
			URL = prop.getProperty("url");
			ID = prop.getProperty("id");
			PWD = prop.getProperty("pwd");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = DBCon.getCon();
		System.out.println(con);
	}
}
