package com.Project.board.action;

import com.Project.board.service.BoardDetailService;
import com.Project.board.vo.ActionForward;
import com.Project.board.vo.BoardBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoardModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			int board_num=Integer.parseInt(request.getParameter("board_num"));
			BoardDetailService boardDetailService
			= new BoardDetailService();	
		   	BoardBean article =boardDetailService.getArticle(board_num);
		   	request.setAttribute("article", article);
	   		forward.setPath("/board/qna_board_modify.jsp");
	   		return forward;
	   		
	 }
	 
}