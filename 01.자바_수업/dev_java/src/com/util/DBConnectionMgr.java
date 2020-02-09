package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc2.JDBCTest;

public class DBConnectionMgr {
	Connection 			con 	= null;
	public static final String _DRIVER 
		= "oracle.jdbc.driver.OracleDriver";
	//물리적으로 떨어져 있는 오라클 서버에 URL정보 추가
	public static final String _URL 
		= "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	public static String _USER = "scott";
	public static String _PW = "tiger";	
	//물리적으로 떨어져 있는 오라클 서버와 연결통로 만들기
	public Connection getConnection() {
		System.out.println("getConnection호출 성공");
		//오라클 회사 정보를 수집함.
		try {
			Class.forName(JDBCTest._DRIVER);
			con = DriverManager.getConnection(JDBCTest._URL
					, JDBCTest._USER
					, JDBCTest._PW);			
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버 클래스 이름을 찾을 수 없어요.");
		} catch(Exception e) {
			System.out.println("예외가 발생했음. 정상적으로 처리가 안됨.");			
		}
		return con;		
	}
}
