package com.Project.member.action;

import com.Project.member.db.MemberDAO;
import com.Project.member.db.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M :MemberLoginAction_execute() 실행 ");

		// 전달정보 저장(id,pass)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// DAO객체 생성 -> idCheck(id,pass)
		MemberDAO mdao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		boolean result = false;
		int check = mdao.idCheck(id, pass);

		// 결과에 따른 페이지 이동
		// 컨트롤러 X - 비밀번호,아이디없음 오류(javascript)
		// => 컨트롤러에는 가지만 페이지이동 X
		if (check == 0) { // 비밀번호 오류 - 페이지 뒤로가기
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			out.print("<script>");
			out.print(" alert('비밀번호 오류~!'); ");
			out.print(" history.back(); ");
			out.print("</script>");

			out.close();
			return null;
		} else if (check == -1) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			out.print("<script>");
			out.print(" alert('아이디 없음~!'); ");
			out.print(" history.back(); ");
			out.print("</script>");

			out.close();
			return null;
		}
		dto.setId(id);
		dto.setPass(pass);
		result = mdao.isExisted(dto);
		// 컨트롤러 O - 로그인성공
		// check == 0 
		// => 메인페이지로 이동
		
		// 아이디 정보를 session객체에 저장
		if (result){
			HttpSession session = request.getSession();
			session.setAttribute("isLogOn ", true);
			session.setAttribute("id", id);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print(" alert('로그인 성공!');");
			out.print(" location.href='./Main.mm';");
			out.print("</script>");
			out.close();
		}


	    // 페이지 이동 (./Main.me)
//		ActionForward forward = new ActionForward();
//		forward.setPath("./Main.mm");
//		forward.setRedirect(true);
		return null;
	}

}
