package com.test;

import com.util.DBConnectionMgr;

public class DBConnectionTest {
	void methodA(DBConnectionMgr dbMgr1) {
		System.out.println(this+", "+dbMgr1);
	}
	public static void main(String[] args) {
		DBConnectionTest dbTest = new DBConnectionTest();
		DBConnectionMgr dbMgr1 = DBConnectionMgr.getInstance();
		DBConnectionMgr dbMgr2 = DBConnectionMgr.getInstance();
		dbTest.methodA(dbMgr1);
		if(dbMgr1 == dbMgr2) {
			System.out.println("true");
		}else {
			System.out.println("false");			
		}
	}

}
