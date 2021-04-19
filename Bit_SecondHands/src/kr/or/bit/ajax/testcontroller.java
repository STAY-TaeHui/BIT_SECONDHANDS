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
    		
    		System.out.println("�ڵ��ϼ� ���");
    		


    		    String[] array = {"��ġ ������", "�Ŷ��", "�����", "����", "�Ϻ���","�ʱ���","�����","�ȼ�����","�Ҵߺ�����","¥��","���縮"};
    		    
    		       	

    		    try {
    				    				
    				//Json ��ü �ϳ� = ��� �ϳ�
    				//�迭
    		    	
    				JSONArray jsonarr = new JSONArray();
    				/*
    				
  					//json ��ü �� ��� ���̺���
    					JSONObject jsonObj = new JSONObject();
    					
    					//Json��ü�� repllist�� ��ҵ��� �־��ش�
    					for(int i = 0; i < array.length; i++) {
    						jsonObj.put(array[i]);
    					}
    					
    					
    					jsonarr.add(jsonObj);
    				*/
    		    	JSONObject jsonObj = new JSONObject();
					
					//Json��ü�� repllist�� ��ҵ��� �־��ش�
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
