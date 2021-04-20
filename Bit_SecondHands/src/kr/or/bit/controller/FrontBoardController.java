package kr.or.bit.controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SecondHandsDAO;
import kr.or.bit.service.LoginOkAction;

@WebServlet("*.do")
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontBoardController() {
        super();

    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	System.out.println("url_Command : " + url_Command);
    	Action action=null;
    	ActionForward forward=null;
    	
    	if(url_Command.equals("/member.do")) { //DB연결 테스트
    		//UI+로직
    		SecondHandsDAO dao = null;
			dao = new SecondHandsDAO();
			System.out.println("DAO 진입");
    		dao.member();
    		
    	}
    	else if(url_Command.equals("/LoginOk.do")) {
    		action = new LoginOkAction();
    		forward = action.execute(request, response);
    	}
    	
//    	if(forward != null) {
//    		if(forward.isRedirect()) { //true 
//    			response.sendRedirect(forward.getPath());
//    		}else { //false (모든 자원 ) 사용
//    			//UI
//    			//UI + 로직
//    			//forward url 주소 변환 없어 View 내용을 받을 수 있다
//    			RequestDispatcher dis  = request.getRequestDispatcher(forward.getPath());
//    			dis.forward(request, response);
//    		}
//    	}
    	
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
