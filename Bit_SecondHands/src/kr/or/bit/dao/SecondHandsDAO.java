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
	//로그인체크 함수 - stay
	public boolean getLoginOk(String email, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			conn=ds.getConnection();
			String sql = "select * from member where m_email=? and m_pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//참이면
				System.out.println("TRUE입니당");
				return true;
			}
			else {
				System.out.println("FALSE입니당");
				return false;
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
	//이메일 중복체크 - stay
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
				System.out.println("TRUE입니당");
				return true;
			}
			else {
				System.out.println("FALSE입니당");
				return false;
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
	//storename 중복체크 - hyunjin
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
	
	//메인에 뿌려줄 상품 리스트 뽑기 - stay
	public JSONArray getProductList() { 
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs=null;
	      JSONArray arr = new JSONArray();
	      
	      System.out.println("리스트 함수 실행");
	      
	      try {
	         conn=ds.getConnection();
	         String sql = "select pi.pimg_name, p.p_subj,p.p_price, p.p_wr_time"
	               +"from product p left join product_img pi "
	               +"on p.p_num=pi.p_num "
	               +"where pi.pimg_num=1";
	         pstmt = conn.prepareStatement(sql);
	         
	         rs= pstmt.executeQuery();
	         System.out.println(pstmt.executeQuery());
	         while(rs.next()) {
	            JSONObject obj = new JSONObject();
	            obj.put("pimg_name",rs.getString("pimg_name"));
	            obj.put("p_subj",rs.getString("p_subj"));
	            obj.put("p_price",rs.getInt("p_price"));
	            System.out.println(obj);
	            arr.add(obj);
	            
	            System.out.println("배열 담겼나 : " +arr.get(0));
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
	
	//검색하는 함수 (가희)
	public JSONArray searchProduct(String keyword){
		System.out.println("k : " + keyword);
		 Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs=null;
	      JSONArray arr = new JSONArray();
	      
	      
	      try {
	         conn=ds.getConnection();
	         String sql = "select pi.pimg_name, p.p_subj,p.p_price "
	               +"from product p left join product_img pi "
	               +"on p.p_num=pi.p_num "
	               +"where p.p_subj Like '%" + keyword + "%' or p.p_content Like '%"+ keyword + "%' ";
	         pstmt = conn.prepareStatement(sql);
	         
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	        	 
	            JSONObject obj = new JSONObject();
	            
	            obj.put("pimg_name",rs.getString("pimg_name"));
	            obj.put("p_subj",rs.getString("p_subj"));
	            obj.put("p_price",rs.getInt("p_price"));
	            
	            System.out.println("제이슨 객체 : "+obj);
	            
	            arr.add(obj);
	         } 
	         System.out.println("배열 : " +arr);

	         
	      
	         
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
	
	//검색 후 최신순 정렬(가희)
	public JSONArray ProductOderByTime(String keyword){
		System.out.println("k : " + keyword);
		 Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs=null;
	      JSONArray arr = new JSONArray();
	      
	      
	      try {
	         conn=ds.getConnection();
	         String sql = "select pi.pimg_name, p.p_subj,p.p_price "
	               +"from product p left join product_img pi "
	               +"on p.p_num=pi.p_num "
	               +"where p.p_subj Like '%" + keyword + "%' or p.p_content Like '%"+ keyword + "%' "
	               +"order by p.p_wr_time";
	         pstmt = conn.prepareStatement(sql);
	         
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	        	 
	            JSONObject obj = new JSONObject();
	            
	            obj.put("pimg_name",rs.getString("pimg_name"));
	            obj.put("p_subj",rs.getString("p_subj"));
	            obj.put("p_price",rs.getInt("p_price"));
	            
	            System.out.println("제이슨 객체 : "+obj);
	            
	            arr.add(obj);
	         } 
	         System.out.println("배열 : " +arr);

	         
	      
	         
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
	
	//검색 후 가격순 정렬 가희
	public JSONArray ProductOderByPrice(String keyword){
		System.out.println("k : " + keyword);
		 Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs=null;
	      JSONArray arr = new JSONArray();
	      
	      
	      try {
	         conn=ds.getConnection();
	         String sql = "select pi.pimg_name, p.p_subj,p.p_price "
	               +"from product p left join product_img pi "
	               +"on p.p_num=pi.p_num "
	               +"where p.p_subj Like '%" + keyword + "%' or p.p_content Like '%"+ keyword + "%' "
	               +"order by p.p_price";
	         pstmt = conn.prepareStatement(sql);
	         
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	        	 
	            JSONObject obj = new JSONObject();
	            
	            obj.put("pimg_name",rs.getString("pimg_name"));
	            obj.put("p_subj",rs.getString("p_subj"));
	            obj.put("p_price",rs.getInt("p_price"));
	            
	            System.out.println("제이슨 객체 : "+obj);
	            
	            arr.add(obj);
	         } 
	         System.out.println("배열 : " +arr);

	         
	      
	         
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
	public JSONObject ProductInfo(String email) {
		System.out.println( "ProductInfO함수이지롱");
		 Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs=null;
	      JSONObject obj = new JSONObject();
	      try {
	    	  System.out.println("TRY and CHATCH");
	    	  System.out.println("email : " + email);
	    	  	conn=ds.getConnection();
	    	  	//상점이름, 프로필사진파일 이름 얻기
		         String sql = "select storename, m_profile "
		         		+"from member "
		         		+"where m_email=?";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, email);
		           
		         rs = pstmt.executeQuery();
		         
		         if(rs.next()) {
		           	 obj.put("storename", rs.getString("storename"));
			         obj.put("m_profile", rs.getString("m_profile"));
		         }
		        
		         //상품 전체개수 얻기
		         sql="select count(*)as cnt "
		         		+ "from product "
		         		+ "group by storename having storename=?";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, (String)obj.get("storename"));
		         
		         rs=pstmt.executeQuery();
		         
		         if(rs.next()) {
		        	 obj.put("p_count", rs.getString("cnt"));
		         }

		         System.out.println(obj.toString());
		         
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}



}