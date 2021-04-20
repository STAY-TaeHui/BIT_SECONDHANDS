package kr.or.bit.controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SecondHandsDAO;
import kr.or.bit.service.*;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();

    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	System.out.println("url_Command : " + url_Command);
    	
    	Action action=null;
    	ActionForward forward=null;
    	
    	//index페이지
    	if(url_Command.equals("/index.do")) { //글쓰기 처리
    		//UI+로직
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("index.jsp");
    		
    		
    	}
    	//회원가입 페이지
    	else if(url_Command.equals("/resister.do")) {
    		
			System.out.println("member DAO 진입");
    		/*
    		SecondHandsDAO dao = null;
			dao = new SecondHandsDAO();
			forward = new ActionForward();
			forward.setPath("WEB-INF/views/member/Resister.jsp");
			forward.setRedirect(false);
    		*/
    	}
    	//로그인 페이지
    	else if(url_Command.equals("/login.do")) {
    		System.out.println("LOGIN.DO");
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("WEB-INF/views/member/Login.jsp");
    	}
    	//로그인 서비스
    	else if(url_Command.equals("/loginok.do")) {
    		action = new LoginOkAction();
    		forward = action.execute(request, response);
    	}
    	//내 상점 페이지
    	else if(url_Command.equals("/myshop.do")) {
    		System.out.println("myshop.do");
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("WEB-INF/views/myshop/Myshop.jsp");
//    		HttpSession session = request.getSession(true);
//    		if(session!=null) {
//    			String email = (String)session.getAttribute("member_ID");
//        		System.out.println("현재 EMAIL : " + email);
//    		}
//    		else {
//    			System.out.println("SESSIOn is null");
//    			System.out.println(session);
//    		}
    		
    	}
///////////////////////////////////////////////////////////////////
    	if(forward != null) {
    		System.out.println("FORWARD");
    		if(forward.isRedirect()) { //true 
    			System.out.println("true");
    			response.sendRedirect(forward.getPath());
    		}else { //false (모든 자원 ) 사용
    			System.out.println("false");
   			//UI
    			//UI + 로직
    			//forward url 주소 변환 없어 View 내용을 받을 수 있다
    			RequestDispatcher dis  = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
    	
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}