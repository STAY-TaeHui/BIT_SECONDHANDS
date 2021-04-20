package kr.or.bit.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SecondHandsDAO;

public class LoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String msg="";
		String url="";
		
		SecondHandsDAO dao = new SecondHandsDAO();
		boolean result = dao.getLoginOk(email, password);
		
		if(!result) {
			System.out.println("로그인실 패");
			msg="로그인 실패 : 아이디/비밀번호가 일치하지 않습니다.";
			url="login.do";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/redirect/redirect.jsp");
		}
		else {
			System.out.println("로그인성공");
			HttpSession session = request.getSession(true);
			session.setAttribute("member_ID", email);
			
			msg="로그인 성공!!";
			url="index.do";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/redirect/redirect.jsp");
		}
		return forward;
		
		
	}

}
