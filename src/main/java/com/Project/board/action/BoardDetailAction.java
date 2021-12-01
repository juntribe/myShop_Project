package com.Project.board.action;

import com.Project.board.service.BoardDetailService;
import com.Project.board.vo.ActionForward;
import com.Project.board.vo.BoardBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoardDetailAction implements Action {

    public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

       int board_num=Integer.parseInt(request.getParameter("board_num"));
       String page = request.getParameter("page");
       BoardDetailService boardDetailService = new BoardDetailService();
       BoardBean article = boardDetailService.getArticle(board_num);
       ActionForward forward = new ActionForward();
       request.setAttribute("page", page);
          request.setAttribute("article", article);
          forward.setPath("/board/qna_board_view.jsp");
          return forward;

    }

}