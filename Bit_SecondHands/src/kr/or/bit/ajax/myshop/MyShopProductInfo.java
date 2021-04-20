package kr.or.bit.ajax.myshop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.SecondHandsDAO;


@WebServlet("/productinfo.ajax")
public class MyShopProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyShopProductInfo() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 세션의 [상점이름], [프로필사진파일], [상품개수] 가 필요 >> JSON으로 보내버리기
    	System.out.println("productinfo.ajax 이지롱");
    	HttpSession session = request.getSession();
    	String email =(String) session.getAttribute("email");
    	
    	SecondHandsDAO dao = new SecondHandsDAO();
    	dao.ProductInfo(email);
    	
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
