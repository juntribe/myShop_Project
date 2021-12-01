package com.Project.goods.controller;

import com.Project.goods.action.*;
import com.Project.goods.vo.ActionForward;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet Filter implementation class FrontControllerFilter
 */
@WebFilter(urlPatterns = {"/main","*.gd"})
public class FrontControllerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FrontControllerFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
    	String contextPath = request.getContextPath();
		System.out.println(contextPath);
    	String command = 
        requestURI.substring(contextPath.length());
		System.out.println(requestURI.substring(contextPath.length()));
    	
    	Action action = null;

    	
    	ActionForward forward = null;

    	if(command.equals("/List.gd") || command.equals("/main")){
    		action = new ListAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
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
				out.print(" location.href='/'");
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

    	else if(command.equals("/View.gd")){
    		action = new ViewAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}

    	else if(command.equals("/CartAdd.gd")){
    		action = new CartAddAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}


    	else if(command.equals("/CartList.gd")){
    		action = new CartListAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	else if(command.equals("/CartRemove.gd")){
    		action = new CartRemoveAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	else if(command.equals("/CartQtyUp.gd")){
    		action = new CartQtyUpAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	else if(command.equals("/CartQtyDown.gd")){
    		action = new CartQtyDownAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}


    	if(forward != null){
    		if(forward.isRedirect()){
    			response.sendRedirect(forward.getPath());
    		}
    		else{
    			RequestDispatcher dispatcher
    			= request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
