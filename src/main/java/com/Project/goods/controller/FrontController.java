package com.Project.goods.controller;

import com.Project.goods.action.*;
import com.Project.goods.vo.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = {"*.gd","/main"})
public class FrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String requestURI = request.getRequestURI();
		System.out.println(requestURI);

		
		String contextPath = request.getContextPath();

		
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;
		

		if(command.equals("/List.gd") ||  command.equals("/main")){
			action = new ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/admin/List.gd")){
			HttpSession session =request.getSession();
			String id = (String) session.getAttribute("id");
			if (id == null || !id.equals("admin")){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print(" alert('관리자가 아닙니다');");
				out.print(" location.href='/main'");
				out.print("</script>");

			}else{
				action = new AdminListAction();
			}

			try{
				forward = action.execute(request, response);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}


		else if(command.equals("/admin/DeleteAction.gd")){
			System.out.println("C : /DeleteAction.gd 호출");
			// 정보를 전달받아서 DB에서 삭제
			// MemberDeleteAction() 객체 생성
			action = new DeleteAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		else if(command.equals("/View.gd")){
			action = new ViewAction();
			System.out.println("View.gd 호출");

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/CartAdd.gd")){
			action = new CartAddAction();
			System.out.println("CartAdd.gd 호출");

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/CartList.gd")){
			action = new CartListAction();
			System.out.println("CartList.gd 호출");

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/CartSearch.gd")){
			action = new CartSearchAction();
			System.out.println("CartSearch.gd 호출");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/CartRemove.gd")){
			action = new CartRemoveAction();
			System.out.println("CartRemove.gd 호출");

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/CartQtyUp.gd")){
			action = new CartQtyUpAction();
			System.out.println("CartQtyUp.gd 호출");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/CartQtyDown.gd")){
			action = new CartQtyDownAction();
			System.out.println("CartQtyDown.gd 호출");

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/admin/Regist.gd")){
			action = new RegistAction();
			System.out.println("Regist.gd");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/admin/RegistForm.gd")){
			action = new RegistFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(forward !=null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
				System.out.println("실행");
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);

			}
		}
		
	}
	
}
