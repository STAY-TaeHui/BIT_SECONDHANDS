package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;



//CRUD 함수 > ConnectionPool > 함수단위 연결 ,받환 
public class SecondHandsDAO {
	DataSource ds = null;
	
	public SecondHandsDAO() {
		Context context;
		try {
			context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); 
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//메인에 뿌려줄 상품 리스트 뽑기
	public void getProductList() { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn=ds.getConnection();
			String sql = ""
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//연결 테스트 함수
	public void member() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		ResultSet rs=null;
		int count=0;
		try {
			conn = ds.getConnection();
			String sql="select * from member";
			pstmt = conn.prepareStatement(sql);
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				count+=1;
			}
			System.out.println("MEMBER COUNT : " + count);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				pstmt.close();
				conn.close();//반환하기
			} catch (Exception e2) {
			
			}
		}
		
	}

}