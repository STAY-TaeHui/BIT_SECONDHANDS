package kr.or.bit.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class testcontroller
 */
@WebServlet("*.ajax")
public class testcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	System.out.println("url_Command : " + url_Command);
    	
    	if(url_Command.equals("/search.ajax")) {
    		
    		System.out.println("자동완성 기능");
    		


    		    String[] array = {"김치 볶음밥", "신라면", "진라면", "라볶이", "팥빙수","너구리","삼양라면","안성탕면","불닭볶음면","짜왕","라면사리"};
    		    
    		       	

    		    try {
    				    				
    				//Json 객체 하나 = 댓글 하나
    				//배열
    		    	
    				JSONArray jsonarr = new JSONArray();
    				/*
    				
  					//json 객체 즉 댓글 테이블을
    					JSONObject jsonObj = new JSONObject();
    					
    					//Json객체에 repllist의 요소들을 넣어준다
    					for(int i = 0; i < array.length; i++) {
    						jsonObj.put(array[i]);
    					}
    					
    					
    					jsonarr.add(jsonObj);
    				*/
    		    	JSONObject jsonObj = new JSONObject();
					
					//Json객체에 repllist의 요소들을 넣어준다
					for(int i = 0; i < array.length; i++) {
						//jsonObj.put("name",array[i]);
						jsonarr.add(array[i]);
					}
    				response.setContentType("application/x-json; charset=UTF-8");
    				response.getWriter().print(jsonarr);
    				//response.getWriter().print(jsonObj);

    			
    			}catch (Exception e) {

    			} finally {

    			}

    		
    		
    		
    	}
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
