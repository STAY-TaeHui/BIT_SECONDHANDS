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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



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
   
   //
   public boolean getEmailCheck(String email) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs=null;
      try {
         conn=ds.getConnection();
         String sql = "select * from member where m_email=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, email);
         
         rs=pstmt.executeQuery();
         
         if(rs.next()) {//참이면
            System.out.println("이메일존재");
            return false;
         }
         else {
            System.out.println("이메일존재X");
            return true;
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         try {
            rs.close();
            pstmt.close();
            conn.close();//반환하기
         } catch (Exception e2) {
            System.out.println(e2.getMessage());
         }
      }
      return false;
   }
   
   public boolean getNameCheck(String storename) {
	    Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs=null;
	      try {
	          conn=ds.getConnection();
	          String sql = "select * from member where storename=?";
	          pstmt = conn.prepareStatement(sql);
	          pstmt.setString(1, storename);
	          rs=pstmt.executeQuery();
	          
	          if(rs.next()) {//참이면
	             System.out.println("닉네임존재");
	             return false;
	          }
	          else {
	             System.out.println("닉네임존재X");
	             return true;
	          }
	       } catch (SQLException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	       }finally {
	          try {
	             rs.close();
	             pstmt.close();
	             conn.close();//반환하기
	          } catch (Exception e2) {
	             System.out.println(e2.getMessage());
	          }
	       }
	      return false;
  }
   
   //메인에 뿌려줄 상품 리스트 뽑기
   public JSONArray getProductList() { 
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs=null;
      JSONArray arr = new JSONArray();
      
      try {
         conn=ds.getConnection();
         String sql = "select pi.pimg_name, p.p_subj,p.p_price "
               +"from product p left join product_img pi "
               +"on p.p_num=pi.p_num "
               +"where pi.pimg_num=1";
         pstmt = conn.prepareStatement(sql);
         
         rs=pstmt.executeQuery();
         
         while(rs.next()) {
            JSONObject obj = new JSONObject();
            obj.put("pimg_name",rs.getString("pimg_name"));
            obj.put("p_subj",rs.getString("p_subj"));
            obj.put("p_price",rs.getInt("p_price"));
            System.out.println(obj);
            arr.add(obj);
         } 
         System.out.println(arr);
         
      
         
      } catch (SQLException e) {
         // TODO: handle exception
         System.out.println(e.getMessage());
      }catch(Exception e3) {
         System.out.println(e3.getMessage());
      }
      finally {
         try {
            rs.close();
            pstmt.close();
            conn.close();//반환하기
         } catch (Exception e2) {
            System.out.println(e2.getMessage());
         }
      }
      return arr;
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