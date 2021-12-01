package com.Project.member.action;

import com.Project.member.db.MemberDAO;
import com.Project.member.db.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


public class MemberUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("M : MemberUpdateProAction_execute() 호출! ");
		
        // 세션 제어 
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        
        ActionForward forward = new ActionForward();
        if(id == null){
        	forward.setPath("./MemberLogin.mm");
        	forward.setRedirect(true);
        	return forward;
        }
        
        // 한글처리
        request.setCharacterEncoding("UTF-8");
        // 전달된 정보를 저장(DTO)
        MemberDTO dto = new MemberDTO();
        dto.setId(request.getParameter("id"));
        dto.setAge(Integer.parseInt(request.getParameter("age")));
        dto.setEmail(request.getParameter("email"));
        dto.setGender(request.getParameter("gender"));
        dto.setName(request.getParameter("name"));
        dto.setPass(request.getParameter("pass"));
        dto.setZipcode(request.getParameter("zipcode"));
        dto.setRoadAddress(request.getParameter("roadAddress"));
        dto.setJibunAddress(request.getParameter("jibunAddress"));
        dto.setNamujiAddress(request.getParameter("namujiAddress"));
        // DAO생성 -> updateMember(DTO);
        MemberDAO dao = new MemberDAO();
        int check = dao.updateMember(dto);
        		
        // 수정 결과에 따른 페이지 이동
        // (0 : 비밀번호 오류, 1 : 수정완료 ,-1: 아이디없음)
        // => 자바스크립트 사용 이동
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        
        if(check==0){
        	out.print("<script>");
        	out.print(" alert('비밀번호 오류!'); ");
        	out.print(" history.back(); ");
        	out.print("</script>");
        	out.close();
        	return null;        	
        }
        if(check == -1){
        	out.print("<script>");
        	out.print(" alert('아이디 없음!'); ");
        	out.print(" history.back(); ");
        	out.print("</script>");
        	out.close();
        	return null; 
        }
        
        // check==1 일때
        out.print("<script>");
    	out.print(" alert('정보 수정완료!'); ");
    	out.print(" location.href='./Main.mm'; ");
    	out.print("</script>");
    	out.close();
		return null;
	}

}
