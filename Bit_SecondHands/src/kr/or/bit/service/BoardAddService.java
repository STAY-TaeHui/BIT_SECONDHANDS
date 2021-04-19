package kr.or.bit.service;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardAddService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String uploadpath = request.getSession().getServletContext().getRealPath("upload");// 실제경로 가져오기
		System.out.println(uploadpath);
	    
		//cos.jar 파일에서 제공하는 MultipartRequest 객체 사용
		
		//업로드 파일에 대한 기본 정보 세팅
		int size = 1024*1024*10; //10MB 네이버 계산기
		String realPath="";
		String orifilename1="";
		
		MultipartRequest multi=null;
		try {
			multi = new MultipartRequest(
				request, //HttpServletRequest request 주소값
				uploadpath, //실 저장경로 >> 배포된 경로
				size,
				"UTF-8",
				new DefaultFileRenamePolicy() // 파일중복이 걸리면,  a_1.txt로 만들겠다.
			);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//파일업로드 완료
		//여기까지가 서버에 upload폴더에 파일이 저장됨.
		// DB에는 저장된 파일의 경로만 넣어준다.		
		//자료실
		
		//2가지 필요
		//1. 서버에 파일 업로드
		//2. 작석자, 제목, 내용 파일명, 파일사이즈를 DB insert하는 작업 >> MultipartRequest에서 뽑아야됨
		
		
		Enumeration filenames =  multi.getFileNames();
		
		String file1 = (String)filenames.nextElement();//filename1(input 태그의 이름)
		realPath = uploadpath+"\\"+multi.getFilesystemName(file1); //>> 중복처리되어서 바뀌어진 이름
		orifilename1 = multi.getOriginalFileName(file1); // >> 원본파일의 이름
		System.out.println("realPath : " + realPath);
		System.out.println("orifilenam1 : " + orifilename1);
		
		String subject = multi.getParameter("subject");
		String writer = multi.getParameter("writer");
		String email = multi.getParameter("email");
		String homepage = multi.getParameter("homepage");
		String content = multi.getParameter("content");
		String pwd = multi.getParameter("pwd");
		int filesize=0;		
		int result = 0;

		Board board = new Board();
		
		if(multi.getFile(file1)!=null){
			filesize=(int)multi.getFile(file1).length(); //파일의 크기
			board.setFilename(realPath);
		}
		board.setSubject(subject);
		board.setWriter(writer);
		board.setEmail(email);
		board.setHomepage(homepage);
		board.setContent(content);
		board.setPwd(pwd);
		
		board.setFilesize(filesize);
		
		System.out.println(subject);
		System.out.println(writer);
		System.out.println(email);
		System.out.println(homepage);
		System.out.println(content);
		System.out.println(pwd);
		System.out.println(realPath);
		System.out.println(filesize);
		
		try {
			BoardDao dao = new BoardDao();
			
			result = dao.writeok(board);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		

		// write.jsp 화면 >> writeok.jsp 처리 >> service >> dao > DB 작업 >
		// return dao > return service > writeok.jsp 결과처리 >> 이동 (공통) >> redirect.jsp

		String msg = "";
		String url = "";
		if (result > 0) {
			msg = "insert success";
			url = "BoardList.do";
		} else {
			msg = "insert fail";
			url = "BoardWrite.do";
		}

		request.setAttribute("board_msg", msg);
		request.setAttribute("board_url", url);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/board/redirect.jsp");

		return forward;

	}

}
