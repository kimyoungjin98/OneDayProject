package com.callor.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	public static Connection dbConn = null;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "food";
		String password = "food";
		
		try {
			Class.forName(jdbcDriver);
			
			if(dbConn == null) {
			dbConn = DriverManager.getConnection(url, user, password);
			}
			System.out.println("오라클 접속 OK");
			
		} catch (SQLException e) {
			System.out.println("오라클 접속 실패");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다");
			System.out.println("ojdbc6.jar 파일을 찾으세요");
		}
		
	}
	
	public static Connection getDBConnection() {
		
		
		return dbConn;
	}
	
}
