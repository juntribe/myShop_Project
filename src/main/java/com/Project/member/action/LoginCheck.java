package com.Project.member.action;

import com.Project.member.db.MemberDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginCheck implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        MemberDAO dao = new MemberDAO();
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        boolean checkID = dao.idCheck(id);
        if (checkID){
            out.print("이미 존재하는 아이디 입니다.");
        }else {
            out.print("사용가능한 아이디 입니다.");
        }
        return null;
    }
}
